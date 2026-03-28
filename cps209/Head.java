import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;


public class Head extends JPanel implements MouseListener {

    private boolean isHovered = false;

    public Head() { 
        JPanel pp = new JPanel();
        pp.setSize(500, 500);
        pp.setBorder(BorderFactory.createLineBorder(Color.black, 20));
        addMouseListener(this);
    }
    public void mouseEntered(MouseEvent e) {
        isHovered = true;
        repaint();
    }
    public void mouseExited(MouseEvent e) {
        isHovered = false;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(100, 100, 250, 250);
        g.drawOval(100, 100, 250, 250);
        g.setColor(Color.WHITE);

        if (isHovered) {
            g.fillOval(160, 185, 25, 25);
            g.fillOval(250, 185, 25, 25);
        } else {
            g.drawLine(160, 185,185,185);
            g.drawLine(250, 185,275,185);
        }
        
        g.drawArc(175, 200, 80, 40, 0, -180);
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    
}

