package projects.projectTwo209;

import java.awt.*;
import java.util.Random;

public class BombOmb {
    // Constants
    public static final int SIZE = 35;
    public static final int MAX_FUSE = 250;
    
    // Position and movement
    private int x, y;
    private int dx, dy;
    private int width, height;
    
    // Properties
    private int fuseTimer;
    private boolean isExploding;
    private int explosionTimer;
    private boolean isPink;
    
    // Animation
    private int step;
    private boolean leftFootUp;
    private Random random;
    
    // Colors
    private static final Color PINK_BODY = new Color(255, 182, 193);
    private static final Color BLACK_BODY = new Color(30, 30, 35);
    private static final Color PINK_HIGHLIGHT = new Color(255, 200, 210);
    private static final Color BLACK_HIGHLIGHT = new Color(70, 70, 80);
    private static final Color FUSE_COLOR = new Color(139, 69, 19);
    private static final Color FEET_COLOR = new Color(255, 220, 100);
    
    public BombOmb(int startX, int startY, int playWidth, int playHeight) {
        this.x = startX;
        this.y = startY;
        this.width = playWidth;
        this.height = playHeight;
        this.fuseTimer = MAX_FUSE;
        this.random = new Random();
        this.isPink = random.nextBoolean();
        
        // Random starting direction on spawn
        this.dx = random.nextInt(3) + 2;
        this.dy = random.nextInt(3) + 2;
        if (random.nextBoolean()) dx = -dx;
        if (random.nextBoolean()) dy = -dy;
    }
    
    public void update() { 
        update(null, null);
    }
    
    public void update(Diffuser leftDiffuser, Diffuser rightDiffuser) {
        if (isExploding) { explosionTimer++; return; }
        
        x += dx;
        y += dy;
        
        // Bounce off walls
        if (x <= 0) { x = 0; dx = -dx; }
        if (x + SIZE >= width) { x = width - SIZE; dx = -dx; }
        if (y <= 0) { y = 0; dy = -dy; }
        if (y + SIZE >= height) { y = height - SIZE; dy = -dy; }
        
        // Bounce off diffusers
        if (leftDiffuser != null) bounceOffDiffuser(leftDiffuser);
        if (rightDiffuser != null) bounceOffDiffuser(rightDiffuser);
        
        // Leg animation
        if (++step >= 20) {
            step = 0;
            leftFootUp = !leftFootUp;
        }
        
        if (--fuseTimer <= 0) explode();
    }
    //bounce off diffusers like it was a wall logic
    private void bounceOffDiffuser(Diffuser diffuser) {
        Rectangle bombBounds = getBounds();
        Rectangle diffuserBounds = diffuser.getBounds();
        
        if (bombBounds.intersects(diffuserBounds)) {
            // Calculate overlap
            int overlapLeft = bombBounds.x + bombBounds.width - diffuserBounds.x;
            int overlapRight = diffuserBounds.x + diffuserBounds.width - bombBounds.x;
            int overlapTop = bombBounds.y + bombBounds.height - diffuserBounds.y;
            int overlapBottom = diffuserBounds.y + diffuserBounds.height - bombBounds.y;
            
            // Find smallest overlap
            int minOverlap = Math.min(Math.min(overlapLeft, overlapRight), Math.min(overlapTop, overlapBottom));
            
            // Push bomb out and reverse direction
            if (minOverlap == overlapLeft) {
                x = diffuserBounds.x - SIZE;
                dx = -Math.abs(dx);
            } else if (minOverlap == overlapRight) {
                x = diffuserBounds.x + diffuserBounds.width;
                dx = Math.abs(dx);
            } else if (minOverlap == overlapTop) {
                y = diffuserBounds.y - SIZE;
                dy = -Math.abs(dy);
            } else if (minOverlap == overlapBottom) {
                y = diffuserBounds.y + diffuserBounds.height;
                dy = Math.abs(dy);
            }
        }
    }
    //insude diffuser logic (basically same)
    public void updateInsideContainer(int containerX, int containerY, int containerWidth, int containerHeight) {
        if (isExploding) { explosionTimer++; return; }

        x += dx;
        y += dy;
        
        if (x <= containerX) { x = containerX; dx = -dx; }
        if (x + SIZE >= containerX + containerWidth) { x = containerX + containerWidth - SIZE; dx = -dx; }
        if (y <= containerY) { y = containerY; dy = -dy; }
        if (y + SIZE >= containerY + containerHeight) { y = containerY + containerHeight - SIZE; dy = -dy; }
        
        if (++step >= 20) {
            step = 0;
            leftFootUp = !leftFootUp;
        }
    }
    //draw fucntion base
    public void draw(Graphics g) {
        draw(g, false);
    }
    //overloaded draw when holding plus if explode
    public void draw(Graphics g, boolean isDragging) {
        if (isExploding) {
            drawExplosion(g);
            return;
        }
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (isDragging) {
            drawBomb(g2d, x - 4, y - 4, SIZE + 8);
        } else {
            drawBomb(g2d, x, y, SIZE);
        }
    }
    //bomb graphics method 
    private void drawBomb(Graphics2D g2d, int drawX, int drawY, int drawSize) {
        // Body
        g2d.setColor(isPink ? PINK_BODY : BLACK_BODY);
        g2d.fillOval(drawX, drawY, drawSize, drawSize);
        
        // Highlight
        int highlightOffset = drawSize / 8;
        g2d.setColor(isPink ? PINK_HIGHLIGHT : BLACK_HIGHLIGHT);
        g2d.fillOval(drawX + highlightOffset, drawY + highlightOffset, drawSize - (highlightOffset * 2), drawSize - (highlightOffset * 2));
        
        // Fuse (only if not in container)
        if (fuseTimer < Integer.MAX_VALUE - 1000) {
            drawFuse(g2d, drawX, drawY, drawSize);
        }
        
        // Eyes
        g2d.setColor(Color.WHITE);
        int eyeY = drawY + drawSize / 3;
        int eyeSize = drawSize / 8;
        g2d.fillOval(drawX + drawSize / 3, eyeY, eyeSize, eyeSize + 2);
        g2d.fillOval(drawX + (drawSize * 3 / 5), eyeY, eyeSize, eyeSize + 2);
        
        // Feet
        if (drawSize == SIZE) {
            drawFeet(g2d, drawX, drawY, drawSize);
        }
    }
    //fuse drawing method
    private void drawFuse(Graphics2D g2d, int drawX, int drawY, int drawSize) {
        int fuseHeight = Math.max(3, (int)((double)fuseTimer / MAX_FUSE * (drawSize / 2)));
        int fuseX = drawX + drawSize/2 - (drawSize / 12);
        int fuseY = drawY - (drawSize / 10);
        
        g2d.setColor(FUSE_COLOR);
        g2d.fillRect(fuseX, fuseY - fuseHeight + (drawSize / 10), drawSize / 6, fuseHeight);
        
        if (shouldSpark()) {
            g2d.setColor(Color.ORANGE);
            g2d.fillOval(fuseX - (drawSize / 25), fuseY - fuseHeight + (drawSize / 25), drawSize / 4, drawSize / 5);
            g2d.setColor(Color.YELLOW);
            g2d.fillOval(fuseX, fuseY - fuseHeight + (drawSize / 16), drawSize / 6, drawSize / 8);
        }
    }
    //moving feet
    private void drawFeet(Graphics2D g2d, int drawX, int drawY, int drawSize) {
        int footWidth = drawSize / 4;
        int footHeight = drawSize / 6;
        int footOffset = drawSize / 5;
        int footRaise = drawSize / 5;
        int footLower = drawSize / 12;
        
        g2d.setColor(FEET_COLOR);
        
        if (leftFootUp) {
            g2d.fillRoundRect(drawX + footOffset, drawY + drawSize - footRaise, footWidth, footHeight, 4, 4);
            g2d.fillRoundRect(drawX + drawSize - footOffset - footWidth, drawY + drawSize - footLower, footWidth, footHeight, 4, 4);
        } else {
            g2d.fillRoundRect(drawX + footOffset, drawY + drawSize - footLower, footWidth, footHeight, 4, 4);
            g2d.fillRoundRect(drawX + drawSize - footOffset - footWidth, drawY + drawSize - footRaise, footWidth, footHeight, 4, 4);
        }
    }
    //small indicator when time is low
    private boolean shouldSpark() {
        if (fuseTimer < MAX_FUSE / 3) {
            return System.currentTimeMillis() % 150 < 75;
        } else if (fuseTimer < MAX_FUSE * 2 / 3) {
            return System.currentTimeMillis() % 300 < 150;
        }
        return System.currentTimeMillis() % 500 < 250;
    }
    //explooosion
    private void drawExplosion(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int size = SIZE + explosionTimer * 8;
        int alpha = Math.max(0, 255 - explosionTimer * 20);
        
        g2d.setColor(new Color(255, 69, 0, alpha));
        g2d.fillOval(x - (size - SIZE)/2, y - (size - SIZE)/2, size, size);
        
        g2d.setColor(new Color(255, 140, 0, alpha));
        g2d.fillOval(x - (size - SIZE)/3, y - (size - SIZE)/3, size * 2/3, size * 2/3);
        
        g2d.setColor(Color.RED);
        for (int i = 0; i < 12; i++) {
            double angle = i * Math.PI * 2 / 12 + explosionTimer * 0.3;
            int sparkX = x + SIZE/2 + (int)(Math.cos(angle) * explosionTimer * 4);
            int sparkY = y + SIZE/2 + (int)(Math.sin(angle) * explosionTimer * 4);
            g2d.fillOval(sparkX - 2, sparkY - 2, 4, 4);
        }
        
        int smokeSize = SIZE / 2;
        g2d.setColor(new Color(80, 80, 80, alpha / 2));
        g2d.fillOval(x + SIZE/2 - smokeSize/2, y + SIZE/2 - smokeSize/3, smokeSize, smokeSize * 2/3);
    }
    
    public void explode() {
        isExploding = true;
        explosionTimer = 0;
    }
    //getters 
    public boolean isExploding() { return isExploding; }
    public boolean isExplosionFinished() { return isExploding && explosionTimer >= 20; }
    public Rectangle getBounds() { return new Rectangle(x, y, SIZE, SIZE); }
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + SIZE && mouseY >= y && mouseY <= y + SIZE;
    }
    public int getFuseTimer() { return fuseTimer; }
    public void setFuseTimer(int fuseTimer) { this.fuseTimer = fuseTimer; }
    public boolean isPink() { return isPink; }
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setSpeed(int speed) {
        this.dx = speed * (dx > 0 ? 1 : -1);
        this.dy = speed * (dy > 0 ? 1 : -1);
    }
}