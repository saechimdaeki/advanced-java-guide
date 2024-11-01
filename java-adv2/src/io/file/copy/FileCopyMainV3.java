package io.file.copy;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {

        final long startTime = System.currentTimeMillis();

        final Path source = Path.of("temp/copy.dat");
        final Path target = Path.of("temp/copy_new.dat");

        Files.copy(source, target, REPLACE_EXISTING);

        final long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
