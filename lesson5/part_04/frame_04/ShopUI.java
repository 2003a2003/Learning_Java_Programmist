package lesson5.part_04.frame_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ShopUI {

    private Shop shop;

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

        p.add(lName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        p.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        JLabel lProducts = new JLabel("Product: ");
        List<Product> products = shop.getProducts();
        ButtonGroup productsGroup = new ButtonGroup();

        JPanel pProducts = new JPanel();
        pProducts.setLayout(new GridLayout(products.size(), 0));
        pProducts.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        for (Product product : products) {
            JRadioButton rb = new JRadioButton(product.toString());
            productsGroup.add(rb);
            pProducts.add(rb);
        }

        p.add(lProducts, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        p.add(pProducts, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 3, 0, 0), 0, 0));

        JLabel lCount = new JLabel("Count:");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);
        p.add(lCount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        p.add(tfCount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.ABOVE_BASELINE,
                new Insets(0, 0, 0, 0), 0, 0));

        JButton jbBuy = new JButton("BUY");
        p.add(jbBuy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        jbBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("******** Transaction Start ****************");
                if (tfName.getText().length() > 0) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    String date = dateFormat.format(new Date());
                    System.out.println(date + ", Customer: " + tfName.getText() + ", Count: " + tfCount.getText());
                }else{
                    System.out.println("Error in name customers......");
                }

                System.out.println("******** Transaction is Done **************");
            }
        });
        return p;
    }

}
