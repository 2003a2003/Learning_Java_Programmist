package lesson6.part_03.newRealization;

import javax.swing.*;
import java.awt.*;

public class ShopUI {

    public ShopUI() {

        JFrame f = new JFrame("ShopUI");
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(100, 100);

        f.getContentPane().add(createJPanel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private JPanel createJPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.BLUE);

        JMenuBar jb = new JMenuBar();
        jb.setLayout(new BoxLayout(jb, BoxLayout.PAGE_AXIS));
        JMenu jmCustomer = addMenuCustomers();
        JMenu jmSeparator = addSeparator();
        JMenu jmProduct = addMenuProduct();

        jb.add(jmCustomer);
        jb.add(jmSeparator);
        jb.add(jmProduct);

        jb.setBorder(BorderFactory.createMatteBorder(0,0,0,1, Color.black));

        p.add(jb);

        return p;
    }

    private JMenu addMenuCustomers(){
        JMenu customres = new JMenu("Customres");

        JMenuItem addCustomer = new JMenuItem("Add Customres ");
        JMenuItem chengeCustomer = new JMenuItem("Chenge Customer ");
        JMenuItem viewCustomer = new JMenuItem("View Customer ");
        JMenuItem remCustomer = new JMenuItem("Remove Customer ");



        customres.add(addCustomer);
        customres.add(chengeCustomer);
        customres.add(viewCustomer);
        customres.add(remCustomer);

        return customres;
    }

    private JMenu addMenuProduct(){
        JMenu product = new JMenu("Product ");

        JMenuItem addProduct = new JMenuItem("Add Product ");
        JMenuItem chengeProduct = new JMenuItem("Chenge Product ");
        JMenuItem viewProduct = new JMenuItem("View Product ");
        JMenuItem remProduct = new JMenuItem("Remove Product ");



        product.add(addProduct);
        product.add(chengeProduct);
        product.add(viewProduct);
        product.add(remProduct);

        return product;
    }

    private JMenu addSeparator(){
        JMenu separator = new JMenu(" | ");


        return separator;
    }

}
