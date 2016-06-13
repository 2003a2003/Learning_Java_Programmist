package lesson6.part_04.frame_03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.AbstractList;
import java.util.List;

public class ShopUI {

    private Font font = new Font("Verdana", Font.PLAIN, 12);

    private Shop shop;
    private int productIndex = 0;

    private JFrame f;
    private JPanel jpSale;
    private JPanel jpTranzaction;

    private JTable jtSale;

    private String[] headers = {"№", "Date", "Product", "Count", "Price", "Customer"};
    private Object[][] data = {};


    public ShopUI(Shop shop) {

        this.shop = shop;

        fillJTableTransaction();

        f = new JFrame("ShopUI");

        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(100, 100);

        f.setJMenuBar(createJMenuBar());

        jpSale = createJPanelSale();
        jpTranzaction = jpTransactions();

        f.getContentPane().add(jpTranzaction);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private JMenuBar createJMenuBar() {

        //Create the menu bar.
        JMenuBar jb = new JMenuBar();

        jb.setBackground(Color.DARK_GRAY);

        jb.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));

//        JMenu jmCustomers = addMenuCustomers();
//        JMenu jmProducts = addMenuProducts();
        JMenu jmSales = addMenuSale();
//        JMenu jmReports = addMenuReports();


//        jb.add(jmCustomers);
//        jb.add(addSeparator());
//        jb.add(jmProducts);
//        jb.add(addSeparator());
        jb.add(jmSales);
//        jb.add(addSeparator());
//        jb.add(jmReports);
//
        return jb;
    }

    private JMenu addMenuCustomers() {

        JMenu customres = new JMenu("Customres");

        customres.setForeground(Color.LIGHT_GRAY);
        customres.setFont(font);

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

    private JMenu addMenuProducts() {
        JMenu product = new JMenu("Product ");

        product.setForeground(Color.LIGHT_GRAY);
        product.setFont(font);

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

    private JMenu addSeparator() {
        JMenu separator = new JMenu(" | ");

        separator.setForeground(Color.LIGHT_GRAY);
        separator.setFont(font);

        return separator;
    }

    private JMenu addMenuReports() {
        JMenu reports = new JMenu("Reports");

        reports.setForeground(Color.LIGHT_GRAY);
        reports.setFont(font);

        JMenuItem viewReportsSales = new JMenuItem("Report Sale ");
        reports.add(viewReportsSales);

        return reports;
    }

    private JMenu addMenuSale() {

        JMenu sales = new JMenu("Sale");

        sales.setForeground(Color.LIGHT_GRAY);
        sales.setFont(font);

        JMenuItem jmSales = new JMenuItem("Buy Product");
        sales.add(jmSales);
        jmSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                f.getAccessibleContext().removeAll();
//                f.remove(jpTranzaction);
//                f.setContentPane(jpSale);
//                f.revalidate();
                f.getContentPane().removeAll();
                f.getContentPane().add(jpSale);
                f.pack();
                f.repaint();
            }
        });

        return sales;
    }

    private JPanel createJPanelSale() {

        JPanel sale = new JPanel();

        sale.setBorder(BorderFactory.createLineBorder(Color.black));

        sale.setLayout(new GridBagLayout());

        JLabel lName = new JLabel("Name Customer: ");
        JTextField tfName = new JTextField(25);

        sale.add(lName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));
        sale.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));

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

        sale.add(lProducts, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));
        sale.add(pProducts, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));

        JLabel lCount = new JLabel("Count:");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);

        sale.add(lCount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));
        sale.add(tfCount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.ABOVE_BASELINE,
                new Insets(5, 0, 0, 0), 0, 0));

        JButton jbBuy = new JButton("BUY");

        jbBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Transaction t = new Transaction();

                Customer cust = new Customer();

                cust.setName(tfName.getText());

                Product product = shop.getProducts().get(productIndex);

                int count = Integer.parseInt(tfCount.getText());

                shop.sell(product, cust, count);

                fillJTableTransaction();

                updateJTableDate();

//                f.remove(jpSale);
//                f.setContentPane(jpTransactions());
//                f.revalidate();
                f.getContentPane().removeAll();
                f.getContentPane().add(jpTransactions());
                f.pack();
                f.repaint();

            }
        });

        sale.add(jbBuy, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));

        return sale;
    }

    private JPanel jpTransactions(){
        JPanel tranzaction = new JPanel();
        tranzaction.add(createJScrollPane());
        return  tranzaction;
    }


    private JScrollPane createJScrollPane() {
        return new JScrollPane(createJTable());
    }

    private JTable createJTable() {
        jtSale = new JTable(createDefaultTableModel());

        jtSale.getColumnModel().getColumn(0).setPreferredWidth(5);
        jtSale.getColumnModel().getColumn(1).setPreferredWidth(120);

        jtSale.setPreferredScrollableViewportSize(new Dimension(600, 200));

        return jtSale;
    }

    private DefaultTableModel createDefaultTableModel() {
        return new DefaultTableModel(data, headers);
    }

    private void updateJTableDate() {
        jtSale.setModel(createDefaultTableModel());
        jtSale.getColumnModel().getColumn(0).setPreferredWidth(5);
        jtSale.getColumnModel().getColumn(1).setPreferredWidth(120);
    }

    private void fillJTableTransaction() {
        AbstractList<Transaction> t = shop.getTransactions();

        Object[][] temp = new Object[t.size()][6];

        if (t.size() > 0) {
            for (int i = 0; i < t.size(); i++) {
                Transaction tranz = t.get(i);
                temp[i][0] = tranz.getId();
                temp[i][1] = tranz.getDate();
                temp[i][2] = tranz.getProduct();
                temp[i][3] = tranz.getCount();
                temp[i][4] = tranz.getPrice();
                temp[i][5] = tranz.getCustomer().getName();
            }
        } else {
            temp = new Object[][]{};
        }
        data = temp;
    }

    private class RBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productIndex = Integer.parseInt(e.getActionCommand());
        }
    }
}
