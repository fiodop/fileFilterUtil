package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataBucketTest {

    @Test
    public void addToIntegerListTest(){
        int num = 1;
        DataBucket dataBucket = new DataBucket();
        dataBucket.addToIntegerList(num);
        assertEquals(1, dataBucket.getIntegerList().get(0));
    }

    @Test
    public void addToStringListTest(){
        String string = "test";
        DataBucket dataBucket = new DataBucket();
        dataBucket.addToStringList(string);
        assertEquals("test", dataBucket.getStringList().get(0));
    }

    @Test
    public void addToFloatListTest(){
        float num = 1.1f;
        DataBucket dataBucket = new DataBucket();
        dataBucket.addToFloatList(num);
        assertEquals(1.1f, dataBucket.getFloatList().get(0));
    }
}
