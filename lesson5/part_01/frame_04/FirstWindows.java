package lesson5.part_01.frame_04;

import javax.swing.*;
import java.awt.*;

public class FirstWindows {
    public static void main(String[] args) {
        JFrame win = new JFrame();

        //My Program
//        win.setName("My First windows!!!");
//        win.setBounds(300,100,800,600);
//        win.setVisible(true);

        //Uchitel variant
        win.setMinimumSize(new Dimension(800, 600));
        win.setLocation(300, 100);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();
        win.setVisible(true);

    }
}
