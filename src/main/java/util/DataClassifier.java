package util;

import lombok.RequiredArgsConstructor;
import model.DataBucket;
import model.DataType;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DataClassifier {
    private final List<String> data;
    private final DataBucket dataBucket = new DataBucket();

    public DataBucket classify() {
        for (int i = 0; i < data.size(); i++) {
            String notClassifiedLine = data.get(i);
            try {
                int parsedLine = Integer.parseInt(notClassifiedLine);
                dataBucket.addToIntegerList(parsedLine);

            } catch (NumberFormatException e) {
                try {
                    float parsedLine = Float.parseFloat(notClassifiedLine);
                    dataBucket.addToFloatList(parsedLine);
                } catch (NumberFormatException e2) {
                    dataBucket.addToStringList(notClassifiedLine);
                }
            }
        }
        return dataBucket;
    }

}
