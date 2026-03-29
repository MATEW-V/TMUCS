package projects.projectTwo209;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Project2Runner extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    /*
     * Name: <name>
     * Student ID: <id>
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     *
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * 
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     */

    private ArrayList<BombOmb> bombs;
    private Diffuser leftDiffuser;
    private Diffuser rightDiffuser;
    private Timer timer;
    private BombOmb draggedBomb;
    private int dragOffsetX, dragOffsetY;
    private int score;
    private int spawnCounter;
    private int gameTime;
    private long startTime;
    private boolean gameActive;
    private boolean gameEnded;
    private String gameEndMessage;
    
    // Game constants
    private static final int MAX_GAME_TIME_SECONDS = 90;
    private static final int MIN_SPAWN_DELAY = 12;
    private static final int MAX_SPAWN_DELAY = 45;
    private static final int MAX_BOMBS = 20;
    private static final int SPAWN_ZONE_WIDTH = 120;
    private static final int SPAWN_ZONE_HEIGHT = 40;
    
    public Project2Runner() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(180, 180, 180));
        addMouseListener(this);
        addMouseMotionListener(this);
        
        bombs = new ArrayList<>();
        startTime = System.currentTimeMillis();
        gameActive = true;
        
        initDiffusers();
        
        timer = new Timer(16, this);
        timer.start();
    }
    
    private void initDiffusers() {
        int diffuserY = (getHeight() - Diffuser.HEIGHT) / 2;
        leftDiffuser = new Diffuser(20, diffuserY, Diffuser.TYPE_PINK);
        rightDiffuser = new Diffuser(getWidth() - Diffuser.WIDTH - 20, diffuserY, Diffuser.TYPE_BLACK);
    }
    
    private int getCurrentSpawnDelay() {
        float progress = Math.min(1.0f, (float) gameTime / ((MAX_GAME_TIME_SECONDS * 2/3) * 60));
        return MAX_SPAWN_DELAY - (int)(progress * (MAX_SPAWN_DELAY - MIN_SPAWN_DELAY));
    }
    
    private float getCurrentSpawnRate() {
        return 60.0f / getCurrentSpawnDelay();
    }
    
    private void spawnBombInZone() {
        if (!gameActive || bombs.size() >= MAX_BOMBS) return;
        
        int bombWidth = BombOmb.SIZE;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        int zoneX = (panelWidth / 2) - (SPAWN_ZONE_WIDTH / 2);
        boolean spawnAtTop = Math.random() < 0.5;
        
        int x = zoneX + (int)(Math.random() * (SPAWN_ZONE_WIDTH - bombWidth));
        int y = (spawnAtTop ? 5 : panelHeight - SPAWN_ZONE_HEIGHT + 5);
        
        x = Math.max(0, Math.min(x, panelWidth - bombWidth));
        y = Math.max(0, Math.min(y, panelHeight - bombWidth));
        
        bombs.add(new BombOmb(x, y, panelWidth, panelHeight));
    }
    
    private void drawSpawnZones(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        int zoneX = (panelWidth / 2) - (SPAWN_ZONE_WIDTH / 2);
        int topZoneY = 0;
        int bottomZoneY = panelHeight - SPAWN_ZONE_HEIGHT;
        
        // Draw both zones
        drawZone(g2d, zoneX, topZoneY, "TOP SPAWN");
        drawZone(g2d, zoneX, bottomZoneY, "BOTTOM SPAWN");
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
    
    private String formatTime(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }
    
    private void endGame(String reason, Diffuser wrongDiffuser) {
        if (!gameActive) return;
        
        gameActive = false;
        gameEnded = true;
        timer.stop();
        
        int diffusedCount = 0;
        int finalScore = 0;
        
        if (reason.equals("wrong") && wrongDiffuser != null) {
            // Count bombs in correct diffuser
            if (wrongDiffuser != leftDiffuser && leftDiffuser != null) {
                finalScore += leftDiffuser.getCount() * 10;
                diffusedCount += leftDiffuser.getCount();
            }
            if (wrongDiffuser != rightDiffuser && rightDiffuser != null) {
                finalScore += rightDiffuser.getCount() * 10;
                diffusedCount += rightDiffuser.getCount();
            }
            
            // Explode only wrong diffuser
            for (BombOmb bomb : wrongDiffuser.getCollectedBombs()) {
                if (!bomb.isExploding()) bomb.explode();
            }
        } else {
            // Count all diffused bombs
            if (leftDiffuser != null) {
                finalScore += leftDiffuser.getCount() * 10;
                diffusedCount += leftDiffuser.getCount();
            }
            if (rightDiffuser != null) {
                finalScore += rightDiffuser.getCount() * 10;
                diffusedCount += rightDiffuser.getCount();
            }
            
            // Explode all diffuser bombs
            if (leftDiffuser != null) {
                for (BombOmb bomb : leftDiffuser.getCollectedBombs()) {
                    if (!bomb.isExploding()) bomb.explode();
                }
            }
            if (rightDiffuser != null) {
                for (BombOmb bomb : rightDiffuser.getCollectedBombs()) {
                    if (!bomb.isExploding()) bomb.explode();
                }
            }
        }
        
        score = finalScore;
        
        // Explode all active bombs
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
        
        repaint();
    }
    
    private void endGame(String reason) {
        endGame(reason, null);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        SwingUtilities.invokeLater(this::initDiffusers);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawSpawnZones(g);
        
        if (leftDiffuser != null) leftDiffuser.draw(g);
        if (rightDiffuser != null) rightDiffuser.draw(g);
        
        for (BombOmb bomb : bombs) {
            bomb.draw(g, bomb == draggedBomb);
        }
        
        drawUI(g);
        
        if (gameEnded) {
            g.setColor(new Color(0, 0, 0, 200));
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("GAME OVER", getWidth() / 2 - 140, getHeight() / 2 - 80);
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            
            String[] lines = gameEndMessage.split("\n");
            int y = getHeight() / 2 - 20;
            for (String line : lines) {
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(line)) / 2;
                g.drawString(line, x, y);
                y += 35;
            }
            
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.setColor(Color.LIGHT_GRAY);
            String restartMsg = "Press R to restart";
            FontMetrics fm = g.getFontMetrics();
            g.drawString(restartMsg, (getWidth() - fm.stringWidth(restartMsg)) / 2, y + 30);
        } else {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString("Drag PINK bombs to LEFT diffuser | Drag BLACK bombs to RIGHT diffuser", 
                        20, getHeight() - 20);
            g.drawString("Wrong diffuser or fuse explosion = GAME OVER! | Bombs spawn in grey zones", 
                        20, getHeight() - 35);
        }
    }
    
    private void drawUI(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        
        int diffusedCount = (leftDiffuser != null ? leftDiffuser.getCount() : 0) + 
                           (rightDiffuser != null ? rightDiffuser.getCount() : 0);
        g.drawString("Diffused: " + diffusedCount, 20, 30);
        
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        int remainingSeconds = Math.max(0, MAX_GAME_TIME_SECONDS - (int)elapsedSeconds);
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Time: " + formatTime(remainingSeconds), getWidth() - 120, 30);
        
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.setColor(Color.CYAN);
        g.drawString(String.format("Spawn Rate: %.1f/sec", getCurrentSpawnRate()), getWidth() - 120, 50);
        
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.setColor(Color.WHITE);
        g.drawString("Active: " + bombs.size(), 20, 55);
        
        if (leftDiffuser != null) {
            g.drawString("Pink: " + leftDiffuser.getCount(), 20, 75);
            g.drawString("Black: " + rightDiffuser.getCount(), 20, 90);
        }
    }
    
    private void restartGame() {
        bombs.clear();
        score = 0;
        spawnCounter = 0;
        gameTime = 0;
        startTime = System.currentTimeMillis();
        gameActive = true;
        gameEnded = false;
        draggedBomb = null;
        
        initDiffusers();
        timer.start();
        repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameActive) {
            repaint();
            return;
        }
        
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
        
        if (++spawnCounter >= getCurrentSpawnDelay()) {
            spawnCounter = 0;
            if (bombs.size() < MAX_BOMBS) spawnBombInZone();
        }
        
        repaint();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (!gameActive) return;
        
        for (int i = bombs.size() - 1; i >= 0; i--) {
            BombOmb bomb = bombs.get(i);
            if (bomb.contains(e.getX(), e.getY()) && !bomb.isExploding()) {
                draggedBomb = bomb;
                dragOffsetX = e.getX() - bomb.getX();
                dragOffsetY = e.getY() - bomb.getY();
                break;
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (!gameActive || draggedBomb == null) return;
        
        int newX = Math.max(0, Math.min(e.getX() - dragOffsetX, getWidth() - BombOmb.SIZE));
        int newY = Math.max(0, Math.min(e.getY() - dragOffsetY, getHeight() - BombOmb.SIZE));
        draggedBomb.setPosition(newX, newY);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (!gameActive || draggedBomb == null) return;
        
        boolean onLeft = leftDiffuser != null && leftDiffuser.contains(e.getX(), e.getY());
        boolean onRight = rightDiffuser != null && rightDiffuser.contains(e.getX(), e.getY());
        
        if ((onLeft && leftDiffuser.canDiffuse(draggedBomb)) || 
            (onRight && rightDiffuser.canDiffuse(draggedBomb))) {
            Diffuser target = onLeft ? leftDiffuser : rightDiffuser;
            if (target.diffuse(draggedBomb)) bombs.remove(draggedBomb);
        } else if (onLeft || onRight) {
            endGame("wrong", onLeft ? leftDiffuser : rightDiffuser);
        }
        
        draggedBomb = null;
    }
    
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sort or Splode");
        Project2Runner game = new Project2Runner();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R && game.gameEnded) game.restartGame();
            }
        });
        
        game.setFocusable(true);
        game.requestFocusInWindow();
    }
}