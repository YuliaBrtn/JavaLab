package bsu.rfe.java.group10.lab3.BritunY.varA5;

import javax.swing.table.AbstractTableModel;
//import javax.swing.table.LinkedList;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    //класс хранит данные для таблицы
    // LinkedList
    //private final Double[] coefficients;
    private final LinkedList<Double> coefficients;
    private final double from;
    private final double to;
    private final double step;

    public GornerTableModel(double from, double to, double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        //this.coefficients = coefficients;
        // Преобразуем массив в LinkedList
        this.coefficients = new LinkedList<>();
        for (Double coefficient : coefficients) {
            this.coefficients.add(coefficient);
        }
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
    }//вычисляем кол-во строк в таблице

    @Override
    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        /* double result = coefficients[0];
        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }*/

        double result = coefficients.get(0);
        for (int i = 1; i < coefficients.size(); i++) {
            result = result * x + coefficients.get(i);
        }

        return switch (col) {
            case 0 -> x;
            case 1 -> result;
            case 2 -> {
                double fractionalPart = Math.abs(result - (long)result);
                if (fractionalPart == 0) yield false;
                // извлекаем корень и проверяем целое ли число
                double root = Math.sqrt(fractionalPart);
                // проверяем, является ли корень целым числом
                boolean isSquare = Math.abs(root - Math.round(root)) < 1e-10;

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









