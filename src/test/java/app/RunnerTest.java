package app;

import config.AppConfig;
import model.StatsMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @TempDir
    Path tempDir;

    @Test
    void parseArgumentsWithOutputAndPrefixTest() {
        String[] args = {
                "input.txt",
                "-o", tempDir.toString(),
                "-p", "result_",
                "-a",
                "-f"
        };

        Runner runner = new Runner();
        AppConfig config = runner.parseArgs(args);

        assertEquals(1, config.getInputFiles().size());
        assertTrue(config.getInputFiles().get(0).toString().endsWith("input.txt"));
        assertEquals(tempDir, config.getOutputDirection());
        assertEquals("result_", config.getPrefix());
        assertTrue(config.isAppendMode());
        assertEquals(StatsMode.FULL, config.getStatsMode());
    }

    @Test
    void parseArgumentsWithShortStatsTest() {
        String[] args = {
                "input.txt",
                "-o", tempDir.toString(),
                "-s"
        };

        Runner runner = new Runner();
        AppConfig config = runner.parseArgs(args);

        assertEquals(1, config.getInputFiles().size());
        assertEquals(tempDir, config.getOutputDirection());
        assertEquals(StatsMode.SHORT, config.getStatsMode());
    }

    @Test
    void parseArgumentsWithoutInputFilesTest() {
        String[] args = {"-o", tempDir.toString()};

        Runner runner = new Runner();

        assertThrows(IllegalArgumentException.class, () -> runner.run(args));
    }

    @Test
    void parseArgumentsWithUnknownOptionTest() {
        String[] args = {"input.txt", "-unknown"};

        Runner runner = new Runner();

        assertThrows(IllegalArgumentException.class, () -> runner.run(args));
    }
}
