package service;

import config.AppConfig;
import io.FIleLineReader;
import util.DataClassifier;

import java.util.ArrayList;
import java.util.List;

public class FilterService {


    public void run(AppConfig config) {
        FIleLineReader reader = new FIleLineReader(config.getInputFiles());
        ArrayList<String> lines = (ArrayList<String>) reader.read();

        DataClassifier classifier = new DataClassifier(lines);



    }
}
