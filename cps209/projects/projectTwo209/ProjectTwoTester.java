package projects.projectTwo209;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ProjectTwoTester extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private ArrayList<BombOmb> bombs;
    private Diffuser leftDiffuser;
    private Diffuser rightDiffuser;
    private Timer timer;
    private BombOmb draggedBomb;
    private int dragOffsetX, dragOffsetY;
    private int score;
    private int lives;
    private int spawnCounter;
    private int gameTime;
    private long startTime;
    
    // Game constants
    private static final int MAX_GAME_TIME_SECONDS = 150;
    private static final int MIN_SPAWN_DELAY = 15;
    private static final int MAX_SPAWN_DELAY = 60;
    private static final int MAX_BOMBS = 15;
    
    public ProjectTwoTester() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(180, 180, 180));
        addMouseListener(this);
        addMouseMotionListener(this);
        
        bombs = new ArrayList<>();
        score = 0;
        lives = 3;
        startTime = System.currentTimeMillis();
        
        initDiffusers();
        
        // Start with a few bombs
        for (int i = 0; i < 2; i++) {
            spawnBombAtTopCenter();
        }
        
        timer = new Timer(16, this);
        timer.start();
    }
    
    private void initDiffusers() {
        int diffuserY = (getHeight() - Diffuser.HEIGHT) / 2;
        leftDiffuser = new Diffuser(20, diffuserY, Diffuser.TYPE_PINK);
        rightDiffuser = new Diffuser(getWidth() - Diffuser.WIDTH - 20, diffuserY, Diffuser.TYPE_BLACK);
    }
    
    private int getCurrentSpawnDelay() {
        float progress = Math.min(1.0f, (float) gameTime / (MAX_GAME_TIME_SECONDS * 60));
        return MAX_SPAWN_DELAY - (int)(progress * (MAX_SPAWN_DELAY - MIN_SPAWN_DELAY));
    }
    
    private void spawnBombAtTopCenter() {
        if (bombs.size() >= MAX_BOMBS) return;
        
        int centerX = getWidth() / 2;
        int x = centerX - BombOmb.SIZE / 2 + (int)(Math.random() * 60) - 30;
        x = Math.max(10, Math.min(x, getWidth() - BombOmb.SIZE - 10));
        
        bombs.add(new BombOmb(x, 10, getWidth(), getHeight()));
    }
    
    private String formatTime(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        SwingUtilities.invokeLater(this::initDiffusers);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (leftDiffuser != null) leftDiffuser.draw(g);
        if (rightDiffuser != null) rightDiffuser.draw(g);
        
        for (BombOmb bomb : bombs) {
            bomb.draw(g, bomb == draggedBomb);
        }
        
        drawUI(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Drag PINK bombs to LEFT diffuser | Drag BLACK bombs to RIGHT diffuser", 
                    20, getHeight() - 20);
        g.drawString("Wrong diffuser = explosion! | Bombs stop ticking when sorted", 
                    20, getHeight() - 35);
    }
    
    private void drawUI(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);
        
        // Draw lives as hearts
        for (int i = 0; i < lives; i++) {
            g.setColor(Color.RED);
            g.fillOval(20 + i * 30, 50, 20, 20);
        }
        
        // Time display
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        int remainingSeconds = Math.max(0, MAX_GAME_TIME_SECONDS - (int)elapsedSeconds);
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Time: " + formatTime(remainingSeconds), getWidth() - 120, 30);
        
        // Spawn rate and counts
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.setColor(Color.CYAN);
        g.drawString("Spawn Rate: " + (60 / getCurrentSpawnDelay()) + "/sec", getWidth() - 120, 50);
        
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.setColor(Color.WHITE);
        g.drawString("Bombs: " + bombs.size(), 20, 90);
        
        if (leftDiffuser != null) {
            g.drawString("Pink diffuser: " + leftDiffuser.getCount(), 20, 110);
            g.drawString("Black diffuser: " + rightDiffuser.getCount(), 20, 125);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check game time
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        if (elapsedSeconds >= MAX_GAME_TIME_SECONDS) {
            gameOver(true);
            return;
        }
        
        gameTime++;
        
        // Update diffusers
        if (leftDiffuser != null) leftDiffuser.update();
        if (rightDiffuser != null) rightDiffuser.update();
        
        // Update bombs and remove exploded
        for (int i = 0; i < bombs.size(); i++) {
            BombOmb bomb = bombs.get(i);
            if (bomb != draggedBomb) bomb.update();
            if (bomb.isExplosionFinished()) {
                bombs.remove(i);
                i--;
            }
        }
        
        // Spawn bombs
        if (++spawnCounter >= getCurrentSpawnDelay()) {
            spawnCounter = 0;
            if (bombs.size() < MAX_BOMBS) {
                spawnBombAtTopCenter();
            }
        }
        
        repaint();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
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
        if (draggedBomb != null) {
            int newX = Math.max(0, Math.min(e.getX() - dragOffsetX, getWidth() - BombOmb.SIZE));
            int newY = Math.max(0, Math.min(e.getY() - dragOffsetY, getHeight() - BombOmb.SIZE));
            draggedBomb.setPosition(newX, newY);
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggedBomb == null) return;
        
        boolean onLeft = leftDiffuser != null && leftDiffuser.contains(e.getX(), e.getY());
        boolean onRight = rightDiffuser != null && rightDiffuser.contains(e.getX(), e.getY());
        
        if ((onLeft && leftDiffuser.canDiffuse(draggedBomb)) || 
            (onRight && rightDiffuser.canDiffuse(draggedBomb))) {
            // Correct diffuser
            Diffuser target = onLeft ? leftDiffuser : rightDiffuser;
            if (target.diffuse(draggedBomb)) {
                score += 10;
                bombs.remove(draggedBomb);
            }
        } else if (onLeft || onRight) {
            // Wrong diffuser - explosion!
            draggedBomb.explode();
            if (--lives <= 0) gameOver(false);
        }
        
        draggedBomb = null;
    }
    
    private void gameOver(boolean won) {
        timer.stop();
        String message = won ? "You Win! Time's up!\nFinal Score: " + score 
                             : "Game Over! No lives remaining!\nFinal Score: " + score;
        JOptionPane.showMessageDialog(this, message);
        System.exit(0);
    }
    
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sort or Splode");
        frame.add(new ProjectTwoTester());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}