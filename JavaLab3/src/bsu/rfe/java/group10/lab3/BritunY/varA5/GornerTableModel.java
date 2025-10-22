package bsu.rfe.java.group10.lab3.BritunY.varA5;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private final Double[] coefficients;
    private final double from;
    private final double to;
    private final double step;

    public GornerTableModel(double from, double to, double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getStep() {
        return step;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return (int) Math.ceil((to - from) / step) + 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        double result = coefficients[0];
        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }

        return switch (col) {
            case 0 -> x;
            case 1 -> result;
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return switch (col) {
            case 0 -> "Значение X";
            case 1 -> "Значение многочлена";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return Double.class;
    }
}









