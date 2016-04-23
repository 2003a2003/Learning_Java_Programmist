package lesson5.part_02.frame_02;

import javafx.scene.text.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class FirstWindows extends JPanel {

    public static int x = 0;
    public static int y = 0;

    public FirstWindows() {
        JFrame win = new JFrame("First Windows");

        win.setMinimumSize(new Dimension(800, 600));
        win.setLocation(300, 100);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JLabel label01 = new JLabel("Some text ....................", SwingConstants.RIGHT);
//        label01.setFont(new Font("Verdana", Font.PLAIN, 20));
//        this.add(label01);
//        this.setBackground(Color.GREEN);

        win.getContentPane().add(this);

        win.pack();
        win.setVisible(true);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(x, y, 800, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        g.drawString("My First TEXT on Panel ^).............", 50, 50);

        g.setColor(Color.RED);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("My First TEXT on Panel ^).............", 50, 80);
    }

    public static void main(String[] args) throws Exception {
        FirstWindows f = new FirstWindows();
    }
}
