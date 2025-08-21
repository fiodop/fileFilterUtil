package config;

import lombok.Data;
import stats.StatsMode;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Конфигурационный класс
 */
@Data
public class AppConfig {
    ArrayList<Path> inputFiles;
    Path outputDirection = Paths.get(".");
    String prefix = "";
    boolean appendMode = false;
    StatsMode statsMode;

    public void addInputFile(Path path) {
        inputFiles.add(path);
    }

}
