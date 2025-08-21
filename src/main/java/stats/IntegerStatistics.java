package stats;

import lombok.Data;

import java.util.HashMap;

@Data
public class IntegerStatistics {
    private int counter;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private long sum = 0L;
    private long average = 0L;

    public void addValue(int value) {
        counter++;
        sum += value;
        max = Math.max(value, max);
        min = Math.min(value, min);
        average = sum / counter;
    }

    /**
     * Метод для получения полной статистики по integer
     * @return HashMap<String, Object> String - название статистического поля, Object - значение
     */
    public HashMap <String, Object> getFullStatistics() {
        HashMap <String, Object> fullStatistics = new HashMap<>();
        fullStatistics.put("counter", counter);
        fullStatistics.put("max", max);
        fullStatistics.put("min", min);
        fullStatistics.put("average", average);
        return fullStatistics;
    }

}
