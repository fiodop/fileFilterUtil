package service;

import config.AppConfig;
import model.StatsMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void runTest() {
        AppConfig config = new AppConfig();

        Path inputFile = Paths.get("src/main/resources/test.txt");
        config.addInputFile(inputFile);

        config.setOutputDirection(tempDir);
        config.setPrefix("test-");
        config.setStatsMode(StatsMode.FULL);
        config.setAppendMode(true);

        FilterService filterService = new FilterService();
        filterService.run(config);

        assertTrue(tempDir.resolve("test_integers.txt").toFile().exists() ||
                tempDir.resolve("test_integers.txt").toFile().length() == 0);
        assertTrue(tempDir.resolve("test_floats.txt").toFile().exists() ||
                tempDir.resolve("test_floats.txt").toFile().length() == 0);
        assertTrue(tempDir.resolve("test_strings.txt").toFile().exists() ||
                tempDir.resolve("test_strings.txt").toFile().length() == 0);

    }
}
