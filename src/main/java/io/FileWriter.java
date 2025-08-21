package io;

import lombok.Data;

import java.nio.file.Path;

@Data
public class FileWriter {
    private final Path outputDirectory;
    private final String prefix;
    private boolean append;


}
