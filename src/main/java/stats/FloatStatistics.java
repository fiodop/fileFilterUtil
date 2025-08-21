package stats;

import lombok.Data;

import java.util.HashMap;

@Data
public class FloatStatistics {
    private int counter = 0;
    private float min = Float.MAX_VALUE;
    private float max = Float.MIN_VALUE;
    private float average = Float.NaN;
    private double sum = 0;

    public void addValue(float value) {
        sum += value;
        counter++;
        min = Math.min(min, value);
        max = Math.max(max, value);
        average = (float) (sum / counter);
    }

    /**
     * Метод для получения полной статистики по float
     * @return HashMap<String, Object> String - название статистического поля, Object - значение
     */
    public HashMap<String, Object> getFullStatistics() {
        HashMap<String, Object> fullStats = new HashMap<>();
        fullStats.put("min", min);
        fullStats.put("max", max);
        fullStats.put("average", average);
        fullStats.put("sum", sum);
        fullStats.put("counter", counter);
        return fullStats;
    }
}
