package stats;

import lombok.Data;
import model.DataBucket;
import model.DataType;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class Statistics {
    private DataBucket dataBucket;
    IntegerStatistics integerStatistics;
    FloatStatistics floatStatistics;
    StringStatistics stringStatistics;

    public Statistics(DataBucket dataBucket) {
        this.dataBucket = dataBucket;

    }

    /**
     * Метод для получения короткой статистики
     * @return HashMap<String, Integer> String - тип данных, Integer - количество
     */
    public HashMap<DataType, Integer> getShortStatistics(){
        HashMap<DataType, Integer> statistics = new HashMap<>();
        IntegerStatistics integerStatistics = dataBucket.getIntegerStatistics();
        FloatStatistics floatStatistics = dataBucket.getFloatStatistics();
        StringStatistics stringStatistics = dataBucket.getStringStatistics();

        statistics.put(DataType.INTEGER, integerStatistics.getCounter());
        statistics.put(DataType.FLOAT, floatStatistics.getCounter());
        statistics.put(DataType.STRING, stringStatistics.getCounter());
        return statistics;
    }

    /**
     * Метод для получения полной статистики
     * @return HashMap<DataType, HashMap<String, Object>> DataType - тип данных,
     * HashMap<String, Object> мапа, где String - название статистического поля, а Object - значение
     */
    public HashMap<DataType, HashMap<String, Object>> getFullStatistics(){
        HashMap<DataType, HashMap<String, Object>> statistics = new HashMap<>();
        IntegerStatistics integerStatistics = dataBucket.getIntegerStatistics();
        FloatStatistics floatStatistics = dataBucket.getFloatStatistics();
        StringStatistics stringStatistics = dataBucket.getStringStatistics();

        HashMap<String, Object> stringStatisticsMap = stringStatistics.getFullStats();
        statistics.put(DataType.STRING, stringStatisticsMap);

        HashMap<String, Object> integerStatisticsMap = integerStatistics.getFullStatistics();
        statistics.put(DataType.INTEGER, integerStatisticsMap);

        HashMap<String, Object> floatStatisticsMap = floatStatistics.getFullStatistics();
        statistics.put(DataType.FLOAT, floatStatisticsMap);

        return statistics;
    }
}
