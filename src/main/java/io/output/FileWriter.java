package io.output;

import lombok.Data;
import model.DataBucket;

import java.nio.file.Path;

@Data
public class FileWriter {
    private final Path outputDirectory;
    private final String prefix;
    private boolean append;


    public void write(DataBucket bucket) {
        new BucketFileWriter(outputDirectory, prefix, append)
                .writeList(bucket.getIntegerList(), "integers.txt");

        new BucketFileWriter(outputDirectory, prefix, append)
                .writeList(bucket.getFloatList(), "floats.txt");

        new BucketFileWriter(outputDirectory, prefix, append)
                .writeList(bucket.getStringList(), "strings.txt");
    }
}
