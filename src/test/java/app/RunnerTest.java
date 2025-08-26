package app;

import config.AppConfig;
import model.StatsMode;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest{

    private final Runner runner = new Runner();

    private static final String OUTPUT_DIR = "/home/fiodop/IdeaProjects/fileFilterUtil/src/test/resources";
    private static final String INPUT_FILE = "/home/fiodop/IdeaProjects/fileFilterUtil/src/main/resources/test.txt";

    @Test
    void parseWithAllOptionsFullStatsTest() {
        String[] args = {
                INPUT_FILE,
                "-o", OUTPUT_DIR,
                "-p", "result_",
                "-a",
                "-f"
        };

        AppConfig config = runner.parseArgs(args);

        assertEquals(Path.of(INPUT_FILE), config.getInputFiles().get(0));
        assertEquals(Paths.get(OUTPUT_DIR), config.getOutputDirection());
        assertEquals("result_", config.getPrefix());
        assertTrue(config.isAppendMode());
        assertEquals(StatsMode.FULL, config.getStatsMode());
    }

    @Test
    void parseWithShortStatsTest() {
        String[] args = {
                INPUT_FILE,
                "-o", OUTPUT_DIR,
                "-s"
        };

        AppConfig config = runner.parseArgs(args);

        assertEquals(Path.of(INPUT_FILE), config.getInputFiles().get(0));
        assertEquals(Paths.get(OUTPUT_DIR), config.getOutputDirection());
        assertEquals("", config.getPrefix());
        assertFalse(config.isAppendMode());
        assertEquals(StatsMode.SHORT, config.getStatsMode());
    }

    @Test
    void parseWithoutInputFilesShouldThrowTest() {
        String[] args = {
                "-o", OUTPUT_DIR
        };

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> runner.parseArgs(args)
        );

        assertEquals("No input files specified", ex.getMessage());
    }

    @Test
    void parseWithUnknownOptionShouldThrowTest() {
        String[] args = {
                INPUT_FILE,
                "-x"
        };

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> runner.parseArgs(args)
        );

        assertEquals("Unknown option: -x", ex.getMessage());
    }

    @Test
    void parseWithMissingPrefixShouldThrowTest() {
        String[] args = {
                INPUT_FILE,
                "-p"
        };

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> runner.parseArgs(args)
        );

        assertEquals("Missing prefix after -p", ex.getMessage());
    }

    @Test
    void parseWithMissingOutputDirShouldThrowTest() {
        String[] args = {
                INPUT_FILE,
                "-o"
        };

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> runner.parseArgs(args)
        );

        assertEquals("Missing output directory", ex.getMessage());
    }
}
