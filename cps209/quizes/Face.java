import javax.swing.*;
import java.awt.*;

class Face extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(100, 100, 250, 250);
        g.drawOval(100, 100, 250, 250);
        g.setColor(Color.WHITE);
        g.fillOval(160, 185, 25, 25);
        g.fillOval(250, 185, 25, 25);
        g.drawArc(175, 200, 80, 40, 0, -180);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Human Face Drawing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Face panel = new Face();
        frame.add(panel);
        frame.setVisible(true);
    }
}
