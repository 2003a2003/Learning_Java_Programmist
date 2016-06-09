package lesson6.part_03.newRealization;

import javax.swing.table.AbstractTableModel;

public class TableSale extends AbstractTableModel {

    private String[] headers = {"№", "Date", "Product", "Count", "Price", "Customer"};
    private Object[][] data = {};

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

}
