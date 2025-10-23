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
        return 3;
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
            case 2 ->{
                double fractionalPart = Math.abs(result - (int)result);
                if (fractionalPart == 0) yield false; // если дробная часть равна 0
                // Проверяем, является ли дробная часть квадратом целого числа
                boolean isSquare = false;
                for (int i = 0; i <= 100; i++) { // проверяем числа от 0 до 100
                    double square = i * i * 0.01; // квадрат в формате дробной части
                    if (Math.abs(fractionalPart - square) < 1e-10) {
                        isSquare = true;
                        break;
                    }
                }
                yield isSquare;
            }

            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return switch (col) {
            case 0 -> "Значение X";
            case 1 -> "Значение многочлена";
            case 2 -> "Дробная часть является квадратом?";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return (col == 2) ? Boolean.class : Double.class;
    }
}









