package io.buffered;

import static io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV4 {

    public static void main(String[] args) throws IOException {

        final FileInputStream fis = new FileInputStream(FILE_NAME);
        final long startTime = System.currentTimeMillis();

        final byte[] bytes = fis.readAllBytes();
        fis.close();
        final long endTime = System.currentTimeMillis();

        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + bytes.length / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
