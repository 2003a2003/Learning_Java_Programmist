package lesson6.part_03;

import javax.swing.*;
import java.awt.*;

public class TranzactionsUI {







    private JPanel simpleTable() {
        //**************************************************************
        JPanel pTable = new JPanel();
        pTable.setLayout(new GridLayout());

        pTable.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        String[] columnNames = {"№", "Date", "Product", "Count", "Price", "Customer"};

        Object[][] data = {

        };

        final JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(true);
        table.setVisible(true);
        table.setOpaque(true);
        pTable.add(table);


        return pTable;

//        p.add(pTable, new GridBagConstraints(1, 6,  6, 6, 6, 8, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
//                new Insets(10, 10, 10, 10), 5, 5));
        //**************************************************************
    }
}
