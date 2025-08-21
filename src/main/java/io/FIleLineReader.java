package io;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class FIleLineReader {
    private final List<Path> inputFiles;

    /**
     * Читает все строки из всех файлов и возвращает список
     * @return List<String>
     */
    public List<String> read() {
        List<String> result = new ArrayList<>();
        for (Path path : inputFiles) {
            List<String> lines = null;
            try {
                lines = Files.readAllLines(path);
            } catch (IOException e) {
                System.err.println("error reading file "+ e.getMessage());
            }
            result.addAll(lines);
        }
        return result;
    }

}
