package lesson5.part_04.frame_03;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.text.NumberFormat;
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
        p.setLayout(new GridBagLayout());

        JLabel lName = new JLabel("Name Customer: ");
        JTextField tfName = new JTextField(25);

        p.add(lName, new GridBagConstraints(0,0,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0,0,0,0),0,0));
        p.add(tfName, new GridBagConstraints(1,0,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0,0,0,0),0,0));

//        JLabel lProducts = new JLabel("Product: ");
//        menuLaptop = createComboBoxMenu();
//        JComboBox tovarList = new JComboBox(menuLaptop);
//        tovarList.setSelectedIndex(0);
//        p.add(lProducts, new GridBagConstraints(0,1,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
//                new Insets(0,0,0,0),0,0));
//        p.add(tovarList, new GridBagConstraints(1,1,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
//                new Insets(0,0,0,0),0,0));

        JLabel lProducts = new JLabel("Product: ");
        String[] products = getLaptops();
        Arrays.sort(products);
        ButtonGroup productsGroup = new ButtonGroup();

        JPanel pProducts = new JPanel();
        pProducts.setLayout(new GridLayout(shop.getTailLaptop(), 0));
        pProducts.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        for (String l : products){
                JRadioButton rb = new JRadioButton(l);
                productsGroup.add(rb);
                pProducts.add(rb);
        }

        p.add(lProducts, new GridBagConstraints(0,1,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0,0,0,0),0,0));
        p.add(pProducts, new GridBagConstraints(1,1,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0,3,0,0),0,0));


        JLabel lCount = new JLabel("Count:");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);
        p.add(lCount, new GridBagConstraints(0,2,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0,0,0,0),0,0));
        p.add(tfCount, new GridBagConstraints(1,2,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.ABOVE_BASELINE,
                new Insets(0,0,0,0),0,0));

        JButton jbBuy = new JButton("BUY");
        p.add(jbBuy, new GridBagConstraints(1,3,1,1,0,0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0,0,0,0),0,0));

        return p;
    }

//    private String[] createComboBoxMenu() {
//
//        String[] rez = new String[shop.getTailLaptop()];
//        for (int i = 0; i < rez.length; i++) {
//            rez[i] = shop.getLaptops()[i].getModel();
//        }
//
//        Arrays.sort(rez);
//
//        return rez;
//    }

    private String[] getLaptops() {

        String[] rez = new String[shop.getTailLaptop()];
        for (int i = 0; i < rez.length; i++) {
            rez[i] = shop.getLaptops()[i].getModel();
        }

        Arrays.sort(rez);

        return rez;
    }
}
