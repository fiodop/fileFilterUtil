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
        Path path = Paths.get("C:\\Users\\artem\\IdeaProjects\\fileFilterUtil\\src\\test\\resources\\test.txt");
        Path path2 = Paths.get("C:\\Users\\artem\\IdeaProjects\\fileFilterUtil\\src\\test\\resources\\test1.txt");
        ArrayList<Path> list = new ArrayList<>();
        list.add(path);
        list.add(path2);
        config.setInputFiles(list);
        config.setOutputDirection(Paths.get("C:\\Users\\artem\\IdeaProjects\\fileFilterUtil\\src\\test\\resources"));
        FilterService filterService = new FilterService();
        config.setPrefix("test-");
        config.setStatsMode(StatsMode.FULL);
        config.setAppendMode(true);
        filterService.run(config);
    }
}
