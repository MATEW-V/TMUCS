package projects.projectTwo209;

public class BombOmb {
    public static final int size = 40;
    public static final int maxFuse = 180; // frames until auto-explosion
    public static final int flash = 15; // frames per flash


    private boolean isPink;
    private int fuseTime = 7;
    private boolean isDefused = false;
    private int speed;
    private int isExploding;

    private boolean isFlashing;
    private int flashCount;
    private int flashTimer;
    // Position
    private int x, y;
}
