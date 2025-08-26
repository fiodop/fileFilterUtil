package service;

import app.Runner;
import config.AppConfig;
import model.StatsMode;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilterServiceTest {

    @Test
    public void runTest(){
        AppConfig config = new AppConfig();
        Path path = Paths.get("src/test/resources/test.txt");
        ArrayList<Path> list = new ArrayList<>();
        list.add(path);
        config.setInputFiles(list);
        config.setOutputDirection(Paths.get("src/test/resources"));
        FilterService filterService = new FilterService();
        config.setPrefix("test-");
        config.setStatsMode(StatsMode.FULL);
        config.setAppendMode(true);
        filterService.run(config);
    }
}
