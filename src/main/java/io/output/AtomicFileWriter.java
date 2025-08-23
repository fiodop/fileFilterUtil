package io.output;

import lombok.Data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Data
public class AtomicFileWriter {
    private final Path targetFile;
    private final boolean append;

    public void writeLines(List<String> lines) throws IOException {
        Files.createDirectories(targetFile.getParent());

        Path tempFile = Files.createTempFile(targetFile.getParent(), "tmp-", ".tmp");

        try(BufferedWriter writer = Files.newBufferedWriter(
                tempFile,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING
        )){
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }

        if (append && Files.exists(tempFile)) {
            List<String> existingLines = Files.readAllLines(tempFile);
            existingLines.addAll(lines);
            Files.write(targetFile, existingLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            Files.delete(tempFile);
        } else {
            Files.move(tempFile, targetFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        }
    }
}
