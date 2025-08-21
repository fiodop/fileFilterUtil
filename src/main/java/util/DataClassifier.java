package util;

import lombok.RequiredArgsConstructor;
import model.DataBucket;
import model.DataType;

import java.util.ArrayList;

@RequiredArgsConstructor
public class DataClassifier {
    private final ArrayList<String> data;
    private DataBucket dataBucket;

    public DataType classify(String line) {
        try {
            int parsedLine = Integer.parseInt(line);
            dataBucket.addToIntegerList(parsedLine);

        }catch (NumberFormatException e){
            try {
                float parsedLine = Float.parseFloat(line);
                dataBucket.addToFloatList(parsedLine);
            }catch (NumberFormatException e2){
                dataBucket.addToStringList(line);
            }
        }
    }

}
