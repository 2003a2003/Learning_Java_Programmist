package lesson5.part_04.frame_01;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ShopUI {

    private Shop shop;
    private String[] menuLaptop;

    public ShopUI(Shop shop) {

        this.shop = shop;

        JFrame f = new JFrame("Selling");
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(100, 100);

        f.getContentPane().add(createSellingPanel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }

    private JPanel createSellingPanel() {
        JPanel p = new JPanel();

        JLabel lName = new JLabel("Name Customer:");
        lName.setBounds(50, 250, 50, 50);
        JTextField tfName = new JTextField(10);

        JButton jbBuy = new JButton("BUY");

        menuLaptop = createComboBoxMenu();
        JComboBox tovarList = new JComboBox(menuLaptop);
        tovarList.setSelectedIndex(0);

        JLabel lAmt = new JLabel("Nubber:");
        JTextField tfAmt = new JTextField(3);


        p.add(lName);
        p.add(tfName);
        p.add(tovarList);
        p.add(lAmt);
        p.add(tfAmt);
        p.add(jbBuy);


        return p;
    }

    private String[] createComboBoxMenu(){

        String[] rez = new String[shop.getTailLaptop()];
        for(int i=0; i < rez.length; i++){
            rez[i] = shop.getLaptops()[i].getModel();
        }

        Arrays.sort(rez);

        return rez;
    }
}
