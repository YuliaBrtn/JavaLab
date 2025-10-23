package bsu.rfe.java.group10.lab3.BritunY.varA5;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(label);
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int col) {

        if (value instanceof Double) {
            String formattedDouble = formatter.format(value);
            label.setText(formattedDouble);
            if (col == 1 && needle != null && needle.equals(formattedDouble)) {
                panel.setBackground(Color.RED);
            } else {
                panel.setBackground(Color.WHITE);
            }
        } else if (value instanceof Boolean) {
            // для Boolean значений (третий столбец) просто отображаем как текст
            // JTable автоматически отобразит флажок из-за указанного Boolean.class
            label.setText(value.toString());
            panel.setBackground(Color.WHITE);
        } else {
            label.setText(value.toString());
            panel.setBackground(Color.WHITE);
        }

        return panel;
    }
}

