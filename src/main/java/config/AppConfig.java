package config;

import lombok.Data;
import lombok.Getter;
import model.StatsMode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Конфигурационный класс
 */

@Getter
public class AppConfig {
    ArrayList<Path> inputFiles = new ArrayList<>();
    Path outputDirection = Paths.get(".");
    String prefix = "";
    boolean appendMode = false;
    StatsMode statsMode;

    public void addInputFile(Path path) {
        inputFiles.add(path);
    }

    public void setOutputDirection(Path path) {
        if (path == null || !Files.exists(path) || !Files.isDirectory(path)) {
            throw new IllegalArgumentException("The specified path does not exist or is not a directory: " + path);
        }
        this.outputDirection = path;
    }

    public void setInputFiles(ArrayList<Path> inputFiles) {
        this.inputFiles = inputFiles;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setAppendMode(boolean appendMode) {
        this.appendMode = appendMode;
    }

    public void setStatsMode(StatsMode statsMode) {
        this.statsMode = statsMode;
    }

}
