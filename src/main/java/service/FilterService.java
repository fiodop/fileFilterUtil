package service;

import config.AppConfig;
import io.FileLineReader;
import io.output.FileWriter;
import model.DataBucket;
import model.StatsMode;
import stats.Statistics;
import util.DataClassifier;

import java.util.ArrayList;


public class FilterService {
    public void run(AppConfig config) {
        FileLineReader reader = new FileLineReader();
        ArrayList<String> lines = (ArrayList<String>) reader.read(config.getInputFiles());

        DataClassifier classifier = new DataClassifier();
        DataBucket classifiedData = classifier.classify(lines);
        FileWriter writer = new FileWriter(config.getOutputDirection(), config.getPrefix());
        writer.write(classifiedData);
        Statistics statistics = new Statistics(classifiedData);

        if(config.getStatsMode() == StatsMode.FULL){
            System.out.println(statistics.getFullStatistics().toString());
        } else {
            System.out.println(statistics.getShortStatistics().toString());
        }
    }
}
