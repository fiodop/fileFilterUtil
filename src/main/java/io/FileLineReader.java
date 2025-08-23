package io;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class FileLineReader {

    /**
     * Читает все строки из всех файлов и возвращает список
     * @return List<String>
     */
    public List<String> read(ArrayList<Path> inputFiles) {
        List<String> result = new ArrayList<>();
        for (Path path : inputFiles) {
            List<String> lines;
            try {
                lines = Files.readAllLines(path);
            } catch (IOException e) {
                throw new RuntimeException("Error reading file " + path, e);
            }
            result.addAll(lines);
        }

        if (result.isEmpty()) {
            throw new RuntimeException("Empty file");
        }
        return result;
    }

}
