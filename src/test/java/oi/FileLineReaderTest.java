package oi;

import io.FileLineReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileLineReaderTest {

    @Test
    public void testFileLineReader(@TempDir Path tempDir) throws IOException {
        String[] lines = {"1", "0", "-1", "1,5", "test", "тест", " "};
        Path file = tempDir.resolve("file.txt");
        ArrayList<Path> inputFiles = new ArrayList<>();
        inputFiles.add(file);
        Files.write(file, List.of(lines));

        FileLineReader reader = new FileLineReader();
        List<String> list = reader.read(inputFiles);

        assertEquals(List.of(lines), list);
    }

    @Test
    public void testReadFilesFileNotFoundThrowsException(@TempDir Path tempDir) throws IOException {
        ArrayList<Path> inputFiles = new ArrayList<>();
        inputFiles.add(Paths.get("nonexistent_file.txt"));

        FileLineReader reader = new FileLineReader();


        assertThrows(RuntimeException.class, () -> {
            reader.read(inputFiles);
        });
    }

    @Test
    public void testReadEmptyFileThrowsException(@TempDir Path tempDir) throws IOException {
        String[] lines = {};
        Path file = tempDir.resolve("file.txt");
        ArrayList<Path> inputFiles = new ArrayList<>();
        inputFiles.add(file);
        Files.write(file, List.of(lines));

        FileLineReader reader = new FileLineReader();
        assertThrows(RuntimeException.class, () -> {
            reader.read(inputFiles);
        });
    }

}
