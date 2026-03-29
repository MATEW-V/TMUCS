package projects.projectTwo209;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Diffuser {
    // Constants
    public static final int WIDTH = 140;
    public static final int HEIGHT = 180;
    public static final int TYPE_PINK = 0;
    public static final int TYPE_BLACK = 1;
    
    // Position and type
    private int x, y;
    private int type;
    private ArrayList<BombOmb> collectedBombs;
    
    // Colors
    private static final Color PINK_BG = new Color(255, 182, 193, 100);
    private static final Color BLACK_BG = new Color(30, 30, 35, 100);
    private static final Color BORDER = Color.YELLOW;
    
    public Diffuser(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.collectedBombs = new ArrayList<>();
    }
    
    public void update() {
        Iterator<BombOmb> iterator = collectedBombs.iterator();
        while (iterator.hasNext()) {
            BombOmb bomb = iterator.next();
            bomb.updateInsideContainer(x + 5, y + 5, WIDTH - 10, HEIGHT - 10);
            if (bomb.isExplosionFinished()) {
                iterator.remove();
            }
        }
    }
    //drawing the diffusers
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw background
        g2d.setColor(type == TYPE_PINK ? PINK_BG : BLACK_BG);
        g2d.fillRect(x, y, WIDTH, HEIGHT);
        
        // Draw border
        g2d.setColor(BORDER);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(x, y, WIDTH, HEIGHT);
        
        g2d.setStroke(new BasicStroke(1));
        g2d.drawRect(x + 2, y + 2, WIDTH - 4, HEIGHT - 4);
        
        // Draw collected bombs
        for (BombOmb bomb : collectedBombs) {
            bomb.draw(g, false);
        }
    }
    
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + WIDTH && 
               mouseY >= y && mouseY <= y + HEIGHT;
    }
    
    public boolean canDiffuse(BombOmb bomb) {
        if (bomb == null || bomb.isExploding()) return false;
        return (type == TYPE_PINK && bomb.isPink()) || (type == TYPE_BLACK && !bomb.isPink());
    }
    
    public boolean diffuse(BombOmb bomb) {
        if (!canDiffuse(bomb)) return false;
        
        bomb.setFuseTimer(Integer.MAX_VALUE);
        bomb.setPosition(x + 15 + (int)(Math.random() * (WIDTH - 30)), 
                        y + 15 + (int)(Math.random() * (HEIGHT - 30)));
        bomb.setSpeed(2);
        collectedBombs.add(bomb);
        return true;
    }

    public int getCount() { return collectedBombs.size(); }

    public Rectangle getBounds() { return new Rectangle(x, y, WIDTH, HEIGHT); }

    public ArrayList<BombOmb> getCollectedBombs() { return collectedBombs; }
}