package projects.projectTwo209;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
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

    private GameLogic game;
    private Timer timer;
    
    public Project2Runner() {
        setPreferredSize(new Dimension(GameLogic.WIDTH, GameLogic.HEIGHT));
        setBackground(new Color(180, 180, 180));
        addMouseListener(this);
        addMouseMotionListener(this);
        
        game = new GameLogic();
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
        game.drawUI(g);
        if (game.isGameEnded()) {
            game.drawGameOver(g);
        } else {
            game.drawInstructions(g);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        game.update();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) { game.startDrag(e.getX(), e.getY()); }
    @Override
    public void mouseDragged(MouseEvent e) { game.drag(e.getX(), e.getY()); }
    @Override
    public void mouseReleased(MouseEvent e) { game.release(e.getX(), e.getY());}
    
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
                if (e.getKeyCode() == KeyEvent.VK_R && game.game.isGameEnded()) {
                    game.game.restart();
                }
            }
        });
        
        game.setFocusable(true);
        game.requestFocusInWindow();
    }
}