package lesson5.part_01.learning;

import javax.swing.*;
import java.awt.*;

public class HowToDraw extends JPanel{
    static int x =50;

    public HowToDraw(){

        JFrame frame = new JFrame("My Windows");
        frame.setLocation(300, 100);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        //repaint()
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.blue);
        g.fillRect(x, 50, 10, 10);

        g.setColor(Color.CYAN);
        g.fillRect(100, 100, 10, 10);
    }

    public static void main(String[] args) throws Exception{

        HowToDraw htd = new HowToDraw();

        Thread.sleep(5000);
        System.out.println("woke up");

        x = 150;
        htd.repaint();
    }
}
