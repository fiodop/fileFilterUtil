package stats;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class StringStatistics {
    private int counter = 0;
    private int maxSize = 0;
    private int minSize = Integer.MAX_VALUE;

    public void addValue(String string) {
        counter++;
        maxSize = Math.max(maxSize, string.length());
        minSize = Math.min(minSize, string.length());
    }

    /**
     * Метод для получения полной статистики по String
     * @return HashMap<String, Object> String - название статистического поля, Object - значение
     */
    public HashMap<String, Object> getFullStats(){
        HashMap<String, Object> fullStats = new HashMap<>();
        fullStats.put("counter", counter);
        fullStats.put("maxSize", maxSize);
        fullStats.put("minSize", minSize);
        return fullStats;
    }
}
