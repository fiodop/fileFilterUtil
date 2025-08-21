package model;

import lombok.AllArgsConstructor;
import stats.FloatStatistics;
import stats.IntegerStatistics;
import stats.StringStatistics;

import java.util.List;
@AllArgsConstructor
public class DataBucket {
    private List<Integer> longList;
    private List<Float> doubleList;
    private List<String> stringList;

    private IntegerStatistics integerStatistics;
    private FloatStatistics floatStatistics;
    private StringStatistics stringStatistics;


    public void addToIntegerList(int number) {
        longList.add(number);
        integerStatistics.addValue(number);
    }

    public void addToFloatList(float number){
        doubleList.add(number);
        floatStatistics.addValue(number);
    }

    public void addToStringList(String string){
        stringList.add(string);
        stringStatistics.addValue(string);
    }
}
