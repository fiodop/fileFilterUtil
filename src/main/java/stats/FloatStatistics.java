package stats;

import lombok.Data;

@Data
public class DoubleStatistics {
    private int counter = 0;
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private double average = Double.NaN;
    private double sum = 0;

    public void addValue(double value) {
        sum += value;
        counter++;
        min = Math.min(min, value);
        max = Math.max(max, value);
        average = sum / counter;
    }

}
