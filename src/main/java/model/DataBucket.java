package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import stats.FloatStatistics;
import stats.IntegerStatistics;
import stats.StringStatistics;

import java.util.ArrayList;
import java.util.List;
@Data
public class DataBucket {
    private List<Integer> integerList = new ArrayList<>();
    private List<Float> floatList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();

    private IntegerStatistics integerStatistics = new IntegerStatistics();
    private FloatStatistics floatStatistics = new FloatStatistics();
    private StringStatistics stringStatistics = new StringStatistics();


    public void addToIntegerList(int number) {
        integerList.add(number);
        integerStatistics.addValue(number);
    }

    public void addToFloatList(float number){
        floatList.add(number);
        floatStatistics.addValue(number);
    }

    public void addToStringList(String string){
        stringList.add(string);
        stringStatistics.addValue(string);
    }
}
