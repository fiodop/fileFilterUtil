package io.output;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Data
public class BucketFileWriter {
    private final Path filePath;
    private final String prefix;
    private final boolean append;

    public <T> void writeList(List<T> list, String filename) {
        if(list == null || list.isEmpty()) return;

        Path path = filePath.resolve(prefix + filename);

        AtomicFileWriter atomicWriter = new AtomicFileWriter(path, append);
        try {
            atomicWriter.writeLines(list.stream().map(Object::toString).toList());
        } catch (IOException e) {
            throw new RuntimeException("Error writing list" + filePath, e);
        }
    }

}
