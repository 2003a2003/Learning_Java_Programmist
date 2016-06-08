package lesson6.part_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;

public class ShopUI {

    private Shop shop;
    private int productIndex = 0;
    JFrame f;

    public ShopUI(Shop shop) {

        this.shop = shop;

        f = new JFrame("Selling");
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

        p.add(lName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        p.add(tfName, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        JLabel lProducts = new JLabel("Product: ");
        List<Product> products = shop.getProducts();
        ButtonGroup productsGroup = new ButtonGroup();

        JPanel pProducts = new JPanel();
        pProducts.setLayout(new GridLayout(products.size(), 0));
        pProducts.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        ActionListener rbListener = new RBListener();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            JRadioButton rb = new JRadioButton(product.toString());
            rb.setActionCommand(String.valueOf(i));
            rb.addActionListener(rbListener);
            if (i == 0) {
                rb.setSelected(true);
            }
            productsGroup.add(rb);
            pProducts.add(rb);
        }

        p.add(lProducts, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        p.add(pProducts, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 3, 0, 0), 0, 0));

        JLabel lCount = new JLabel("Count:");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);
        p.add(lCount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        p.add(tfCount, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.ABOVE_BASELINE,
                new Insets(0, 0, 0, 0), 0, 0));

        //**************************************************************
        String[] columnNames = {"№", "Date", "Product", "Count", "Price", "Customer"};
//        JPanel pTable = new JPanel();
//        pTable.setLayout(new GridLayout(1,0));

//        pTable.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        Object[][] data = {
                {"№", "Date", "Product", "Count", "Price", "Customer"},
                {"№", "Date", "Product", "Count", "Price", "Customer"},
        };

        JTable table = new JTable(data, columnNames);

//        pTable.add(table.getTableHeader(), BorderLayout.PAGE_START);
//        pTable.add(table, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setName("TABLE");
//        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
//        table.setFillsViewportHeight(true);

//        table.setOpaque(true);
//        pTable.add(table);



        p.add(scrollPane, new GridBagConstraints(1, 6,  6, 6, 6, 8, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 5, 5));


        //**************************************************************
        JButton jbBuy = new JButton("BUY");
        p.add(jbBuy, new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        jbBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("******** Transaction Start ****************");

                Customer cust = new Customer();
                cust.setName(tfName.getText());

                Product product = shop.getProducts().get(productIndex);

                int count = Integer.parseInt(tfCount.getText());

                shop.sell(product, cust, count);


                System.out.println("******** Transaction Stop *****************");
            }
        });


        JButton jbExit = new JButton("Exit");
        p.add(jbExit, new GridBagConstraints(3, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


//        p.add(simpleTable(), new GridBagConstraints(1, 6, 6, 6, 6, 8, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
//                new Insets(10, 10, 10, 10), 5, 5));

        return p;
    }

    private JPanel simpleTable() {
        //**************************************************************
        JPanel pTable = new JPanel();
        pTable.setLayout(new GridLayout());

        pTable.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        String[] columnNames = {"№", "Date", "Product", "Count", "Price", "Customer"};

        Object[][] data = {

        };

        final JTable table = new JTable(data, columnNames);
        table.setAutoCreateRowSorter(false);
        JScrollPane scrollPane = new JScrollPane(table);

        //table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(true);
        table.setVisible(true);
        table.setOpaque(true);
        pTable.add(table);
        f.dispose();

        return pTable;

//        p.add(pTable, new GridBagConstraints(1, 6,  6, 6, 6, 8, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
//                new Insets(10, 10, 10, 10), 5, 5));
        //**************************************************************
    }


    private class RBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productIndex = Integer.parseInt(e.getActionCommand());
        }
    }

}
