package finalspractice;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

/* Complete the Swing_Doubler class below.
    When running the Swing_Doubler_Runner.java file, you should have a window appear
    containing two buttons and a label containing a number. When you push one button,
    the displayed number should have its current value halved. Pushing the other button
    doubles the current value.

    What do you need to complete this program? Add any Swing modules as needed.

    Refer to the "Swing_Doubler_Reference.png" image in this directory to see what your resulting
    window should look like. Dimensions have intentionally not been provided, forcing you to
    use your knowledge of JSwing and positioning to properly define the dimensions to your liking.
    It does not need to be perfect, just approximate.
*/

public class Doubler{
    // Add any code you need here
    public static double num = 1.0;
    public static JLabel box = new JLabel(""+num);
    public static JButton mul = new JButton("x2");
    public static JButton div = new JButton("x/2");   
    
    static class mulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num*=2;
            box.setText(""+num);
            box.repaint();
        }
    }
    static class divListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num/=2;
            box.setText(""+num);
            box.repaint();
        }
    }
    public static void main(String[] args) {
        // Complete the main function.
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(400, 150);

        mul.addActionListener(new mulListener());
        div.addActionListener(new divListener());

        box.setBounds(150, 30, 100, 40);
        div.setBounds(30, 30, 100, 40);
        mul.setBounds(270, 30, 100, 40);

        frame.add(box);
        frame.add(mul);
        frame.add(div);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}
}