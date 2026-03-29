package projects.projectTwo209;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Project2Runner extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    /*
     * Name: Matthew Vuong
     * Student ID: 501348434
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * For this project I recreated the Mario 3DS minigame “Sort or Splode”. 
     * 
     * A fun game where wandering Bob’Ombs in black or pink spawn in primed and need to be diffused. 
     * To diffuse them, drag and drop them into their respective diffuser pads. 
     * If sorted incorrectly, the entire batch inside said diffuser blows up. 
     *
     * Your score is based on how many remaining diffused Bob’Ombs are left, each are worth 10 points. 
     * Any explosion ends the game along with the time running out. 
     * The game spawns bombs on the top and bottom center of the screen. 
     * The spawn rate ramps up slowly as time goes on. 
     * 
     * The files contain a BombOmb object class, a Diffuser object class and a GameLogic Class. 
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * My game uses JLabels for the instruction displays, Time display, and Diffused count display. 
     * The spawn rate is shown by a JProgressBar to neatly indicate it ramping up over time. 
     * Lastly when the game ends a “Restart” JButton shows up. This calls the restart method. 
     * 
     * All of these Swing components are present in “GameLogic.java” at line 108 in the UpdateSwingUi method. 
     * They are initialized at line 20, used and updated in the other method. 
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * The program uses a JPanel for all 2D game rendering. 
     * Project2Runner extends JPanel (defined at line 7 of Project2Runner.java) and overrides paintComponent(Graphics g) 
     * (line 37) to draw all game elements each frame, including the spawn zones, diffusers, and bombs. 
     * The panel is added directly to the JFrame in main() and sized to 800x600 via setPreferredSize(). 
     * All graphical drawing occurs through this single panel, 
     * which is repainted every 16 milliseconds by the Timer in actionPerformed()
     * 
     * 16 ms is for approximately 60 fps. 
     * 
     * BombOmb and Diffuser make draw methods and are painted in paintComponent in this file. This is at line 86.  
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * Project2Runner implements both ActionListener and MouseListener directly on the class declaration at line 7 of Project2Runner.java. 
     * The ActionListener is called every 16 milliseconds by the Swing Timer (line 90) to drive the game loop.
     * This updates game state and repainting the panel. 
     * The MouseListener is satisfied by mousePressed() and mouseReleased() (line 117),  which handle picking up and dropping bombs onto diffusers. 
     * All three listeners are registered on the panel in the constructor at lines 83.
     * 
     * 
     * 
     */

     

    private GameLogic game;
    private Timer timer;
    
    public Project2Runner() {
        setPreferredSize(new Dimension(GameLogic.WIDTH, GameLogic.HEIGHT));
        setBackground(new Color(180, 180, 180));
        addMouseListener(this);
        addMouseMotionListener(this);
        
        game = new GameLogic();
        game.initSwingComponents(this);
        game.initDiffusers();
        
        timer = new Timer(16, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.drawSpawnZones(g);
        
        if (game.getLeftDiffuser() != null) game.getLeftDiffuser().draw(g);
        if (game.getRightDiffuser() != null) game.getRightDiffuser().draw(g);
        for (BombOmb bomb : game.getBombs()) {
            bomb.draw(g, bomb == game.getDraggedBomb());
        }
        if (game.isGameEnded()) {
            game.drawGameOver(g);
        } 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        game.update();
        game.updateSwingUI();  
        repaint();
    }

    @Override public void mousePressed(MouseEvent e) { game.startDrag(e.getX(), e.getY()); }
    @Override public void mouseDragged(MouseEvent e) { game.drag(e.getX(), e.getY()); }
    @Override public void mouseReleased(MouseEvent e) { game.release(e.getX(), e.getY());}
    
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sort or Splode");
        frame.add(new Project2Runner());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}