package projects.projectTwo209;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameLogic {
    private ArrayList<BombOmb> bombs;
    private Diffuser leftDiffuser;
    private Diffuser rightDiffuser;
    private int score;
    private int spawnCounter;
    private int gameTime;
    private long startTime;
    private boolean gameActive;
    private String gameEndMessage;
    private BombOmb draggedBomb;
    private int dragOffsetX, dragOffsetY;

    // Swing UI components
    private JLabel diffusedLabel;
    private JLabel timeLabel;
    private JLabel spawnRateLabel;
    private JLabel instructionsLabel1;
    private JLabel instructionsLabel2;
    private JButton restartButton;

    // Game constants
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int MAX_GAME_TIME_SECONDS = 90;
    public static final int MIN_SPAWN_DELAY = 20;
    public static final int MAX_SPAWN_DELAY = 55;
    public static final int MAX_BOMBS = 10;
    public static final int SPAWN_ZONE_WIDTH = 120;
    public static final int SPAWN_ZONE_HEIGHT = 40;

    public GameLogic() {
        bombs = new ArrayList<>();
        startTime = System.currentTimeMillis();
        gameActive = true;
        score = 0;
        spawnCounter = 0;
        gameTime = 0;
    }

    /**
     * Call this once from your panel's constructor, passing the panel itself.
     * This creates and adds all Swing UI components to the panel.
     */
    public void initSwingComponents(JPanel panel) {
        panel.setLayout(null); // keep absolute positioning for game objects

        // --- UI Labels (top) ---
        diffusedLabel = new JLabel("Diffused: 0");
        diffusedLabel.setForeground(Color.WHITE);
        diffusedLabel.setFont(new Font("Arial", Font.BOLD, 20));
        diffusedLabel.setBounds(20, 10, 200, 30);
        panel.add(diffusedLabel);

        timeLabel = new JLabel("Time: 01:30");
        timeLabel.setForeground(Color.YELLOW);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timeLabel.setBounds(WIDTH - 130, 10, 120, 25);
        panel.add(timeLabel);

        spawnRateLabel = new JLabel("Spawn Rate: 1.1/sec");
        spawnRateLabel.setForeground(Color.CYAN);
        spawnRateLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        spawnRateLabel.setBounds(WIDTH - 130, 35, 130, 20);
        panel.add(spawnRateLabel);

        // --- Instruction Labels (bottom) ---
        instructionsLabel1 = new JLabel("Drag bombs into their Diffusers. Incorrect sorting will explode the entire batch.");
        instructionsLabel1.setForeground(Color.WHITE);
        instructionsLabel1.setFont(new Font("Arial", Font.PLAIN, 11));
        instructionsLabel1.setBounds(10, HEIGHT - 65, 750, 15);
        panel.add(instructionsLabel1);

        instructionsLabel2 = new JLabel("Score is calculated at the end of the game, either when an explosion happens or time runs out.");
        instructionsLabel2.setForeground(Color.WHITE);
        instructionsLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        instructionsLabel2.setBounds(10, HEIGHT - 50, 780, 15);
        panel.add(instructionsLabel2);

        // --- Restart Button (hidden until game ends) ---
        restartButton = new JButton("Restart");
        restartButton.setBounds(WIDTH / 2 - 60, HEIGHT / 2 + 100, 120, 35);
        restartButton.setFont(new Font("Arial", Font.BOLD, 16));
        restartButton.setForeground(Color.BLACK);
        restartButton.setBackground(Color.YELLOW);
        restartButton.setFocusPainted(false);
        restartButton.setVisible(false); // hidden during gameplay
        restartButton.addActionListener(e -> restart());
        panel.add(restartButton);
    }

    /**
     * Call this each game tick (from your update loop) to keep labels current.
     */
    public void updateSwingUI() {
        if (diffusedLabel == null) return; // not yet initialised

        int diffusedCount = (leftDiffuser != null ? leftDiffuser.getCount() : 0)
                          + (rightDiffuser != null ? rightDiffuser.getCount() : 0);

        diffusedLabel.setText("Diffused: " + diffusedCount);
        timeLabel.setText("Time: " + formatTime(getRemainingSeconds()));
        spawnRateLabel.setText(String.format("Spawn Rate: %.1f/sec", getCurrentSpawnRate()));

        // Show restart button only when game has ended
        restartButton.setVisible(!gameActive);
    }

    public void initDiffusers() {
        int diffuserY = (HEIGHT - Diffuser.HEIGHT) / 2;
        leftDiffuser = new Diffuser(20, diffuserY, Diffuser.TYPE_PINK);
        rightDiffuser = new Diffuser(WIDTH - Diffuser.WIDTH - 20, diffuserY, Diffuser.TYPE_BLACK);
    }

    public void update() {
        if (!gameActive) return;

        if ((System.currentTimeMillis() - startTime) / 1000 >= MAX_GAME_TIME_SECONDS) {
            endGame("time");
            return;
        }

        gameTime++;

        if (leftDiffuser != null) leftDiffuser.update();
        if (rightDiffuser != null) rightDiffuser.update();

        for (int i = 0; i < bombs.size(); i++) {
            BombOmb bomb = bombs.get(i);
            if (bomb != draggedBomb) bomb.update(leftDiffuser, rightDiffuser);

            if (bomb.isExploding() && bomb.getFuseTimer() <= 0) {
                endGame("fuse");
                return;
            }

            if (bomb.isExplosionFinished()) {
                bombs.remove(i);
                i--;
            }
        }

        if (++spawnCounter >= getCurrentSpawnDelay() && bombs.size() < MAX_BOMBS) {
            spawnCounter = 0;
            spawnBomb();
        }
    }

    private int getCurrentSpawnDelay() {
        float progress = Math.min(1.0f, (float) gameTime / ((MAX_GAME_TIME_SECONDS * 2 / 3) * 60));
        return MAX_SPAWN_DELAY - (int) (progress * (MAX_SPAWN_DELAY - MIN_SPAWN_DELAY));
    }

    public float getCurrentSpawnRate() {
        return 60.0f / getCurrentSpawnDelay();
    }

    private void spawnBomb() {
        int bombWidth = BombOmb.SIZE;
        int zoneX = (WIDTH / 2) - (SPAWN_ZONE_WIDTH / 2);
        boolean spawnAtTop = Math.random() < 0.5;

        int x = zoneX + (int) (Math.random() * (SPAWN_ZONE_WIDTH - bombWidth));
        int y = (spawnAtTop ? 5 : HEIGHT - SPAWN_ZONE_HEIGHT + 5);

        x = Math.max(0, Math.min(x, WIDTH - bombWidth));
        y = Math.max(0, Math.min(y, HEIGHT - bombWidth));

        bombs.add(new BombOmb(x, y, WIDTH, HEIGHT));
    }

    public void startDrag(int mouseX, int mouseY) {
        if (!gameActive) return;

        for (int i = bombs.size() - 1; i >= 0; i--) {
            BombOmb bomb = bombs.get(i);
            if (bomb.contains(mouseX, mouseY) && !bomb.isExploding()) {
                draggedBomb = bomb;
                dragOffsetX = mouseX - bomb.getX();
                dragOffsetY = mouseY - bomb.getY();
                break;
            }
        }
    }

    public void drag(int mouseX, int mouseY) {
        if (!gameActive || draggedBomb == null) return;

        int newX = Math.max(0, Math.min(mouseX - dragOffsetX, WIDTH - BombOmb.SIZE));
        int newY = Math.max(0, Math.min(mouseY - dragOffsetY, HEIGHT - BombOmb.SIZE));
        draggedBomb.setPosition(newX, newY);
    }

    public void release(int mouseX, int mouseY) {
        if (!gameActive || draggedBomb == null) return;

        boolean onLeft = leftDiffuser != null && leftDiffuser.contains(mouseX, mouseY);
        boolean onRight = rightDiffuser != null && rightDiffuser.contains(mouseX, mouseY);

        if ((onLeft && leftDiffuser.canDiffuse(draggedBomb)) ||
            (onRight && rightDiffuser.canDiffuse(draggedBomb))) {
            Diffuser target = onLeft ? leftDiffuser : rightDiffuser;
            if (target.diffuse(draggedBomb)) bombs.remove(draggedBomb);
        } else if (onLeft || onRight) {
            endGame("wrong", onLeft ? leftDiffuser : rightDiffuser);
        }

        draggedBomb = null;
    }

    private void endGame(String reason) {
        endGame(reason, null);
    }

    private void endGame(String reason, Diffuser wrongDiffuser) {
        if (!gameActive) return;

        gameActive = false;

        int diffusedCount = 0;
        int finalScore = 0;

        if (reason.equals("wrong") && wrongDiffuser != null) {
            if (wrongDiffuser != leftDiffuser && leftDiffuser != null) {
                finalScore += leftDiffuser.getCount() * 10;
                diffusedCount += leftDiffuser.getCount();
            }
            if (wrongDiffuser != rightDiffuser && rightDiffuser != null) {
                finalScore += rightDiffuser.getCount() * 10;
                diffusedCount += rightDiffuser.getCount();
            }
            for (BombOmb bomb : wrongDiffuser.getCollectedBombs()) {
                if (!bomb.isExploding()) bomb.explode();
            }
        } else {
            if (leftDiffuser != null) {
                finalScore += leftDiffuser.getCount() * 10;
                diffusedCount += leftDiffuser.getCount();
            }
            if (rightDiffuser != null) {
                finalScore += rightDiffuser.getCount() * 10;
                diffusedCount += rightDiffuser.getCount();
            }
            if (leftDiffuser != null) {
                for (BombOmb bomb : leftDiffuser.getCollectedBombs()) bomb.explode();
            }
            if (rightDiffuser != null) {
                for (BombOmb bomb : rightDiffuser.getCollectedBombs()) bomb.explode();
            }
        }

        score = finalScore;

        for (BombOmb bomb : bombs) {
            if (!bomb.isExploding()) bomb.explode();
        }

        switch (reason) {
            case "time":
                gameEndMessage = "TIME'S UP!\nYou diffused " + diffusedCount + " bombs!\nFinal Score: " + score;
                break;
            case "wrong":
                gameEndMessage = "WRONG DIFFUSER!\nAll bombs in that diffuser exploded!\nYou diffused " + diffusedCount + " bombs!\nFinal Score: " + score;
                break;
            default:
                gameEndMessage = "BOMB EXPLODED!\nThe fuse ran out!\nYou diffused " + diffusedCount + " bombs!\nFinal Score: " + score;
                break;
        }
    }

    public void restart() {
        bombs.clear();
        score = 0;
        spawnCounter = 0;
        gameTime = 0;
        startTime = System.currentTimeMillis();
        gameActive = true;
        draggedBomb = null;
        if (restartButton != null) restartButton.setVisible(false);
        initDiffusers();
    }

    public String formatTime(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }

    public int getRemainingSeconds() {
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        return Math.max(0, MAX_GAME_TIME_SECONDS - (int) elapsedSeconds);
    }

    // Drawing methods
    public void drawSpawnZones(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int zoneX = (WIDTH / 2) - (SPAWN_ZONE_WIDTH / 2);
        drawZone(g2d, zoneX, 0, "TOP SPAWN");
        drawZone(g2d, zoneX, HEIGHT - SPAWN_ZONE_HEIGHT, "BOTTOM SPAWN");
    }

    private void drawZone(Graphics2D g2d, int x, int y, String label) {
        g2d.setColor(new Color(100, 100, 100, 150));
        g2d.fillRect(x, y, SPAWN_ZONE_WIDTH, SPAWN_ZONE_HEIGHT);
        g2d.setColor(new Color(80, 80, 80));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(x, y, SPAWN_ZONE_WIDTH, SPAWN_ZONE_HEIGHT);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        FontMetrics fm = g2d.getFontMetrics();
        int labelX = x + (SPAWN_ZONE_WIDTH - fm.stringWidth(label)) / 2;
        g2d.drawString(label, labelX, y + 20);
    }

    public void drawGameOver(Graphics g) {
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("GAME OVER", WIDTH / 2 - 140, HEIGHT / 2 - 80);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));

        String[] lines = gameEndMessage.split("\n");
        int y = HEIGHT / 2 - 20;
        for (String line : lines) {
            FontMetrics fm = g.getFontMetrics();
            int x = (WIDTH - fm.stringWidth(line)) / 2;
            g.drawString(line, x, y);
            y += 35;
        }
    }

    // Getters
    public ArrayList<BombOmb> getBombs() { return bombs; }
    public Diffuser getLeftDiffuser() { return leftDiffuser; }
    public Diffuser getRightDiffuser() { return rightDiffuser; }
    public int getScore() { return score; }
    public boolean isGameActive() { return gameActive; }
    public boolean isGameEnded() { return !gameActive; }
    public String getGameEndMessage() { return gameEndMessage; }
    public BombOmb getDraggedBomb() { return draggedBomb; }
}