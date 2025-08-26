package util;

import model.DataBucket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataClassifierTest {

    @Test
    public void classifyingIntegerTest(){
        String[] arr = {"0", "-1", "1"};
        List<String> integers = List.of(arr);

        DataClassifier testClassifier = new DataClassifier();
        DataBucket testBucket = testClassifier.classify(integers);
        assertEquals(integers.toString(), testBucket.getIntegerList().toString());
    }

    @Test
    public void classifyingFloatTest(){
        String[] arr = {"0.0", "-1.0", "1.0"};
        List<String> floats = List.of(arr);

        DataClassifier testClassifier = new DataClassifier();
        DataBucket testBucket = testClassifier.classify(floats);
        assertEquals(floats.toString(), testBucket.getFloatList().toString());
    }

    @Test
    public void classifyingStringTest(){
        String[] arr = {"q", "й", "e"};
        List<String> strings = List.of(arr);

        DataClassifier testClassifier = new DataClassifier();
        DataBucket testBucket = testClassifier.classify(strings);
        assertEquals(strings.toString(), testBucket.getStringList().toString());
    }

    @Test
    public void classifyingListTest(){
        String[] arr = {"1", "1.5", "test"};
        List<String> list = List.of(arr);
        DataClassifier testClassifier = new DataClassifier();
        DataBucket testBucket = testClassifier.classify(list);
        assertEquals("[1]", testBucket.getIntegerList().toString());
        assertEquals("[1.5]", testBucket.getFloatList().toString());
        assertEquals("[test]", testBucket.getStringList().toString());
    }


}
