package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {

    public static void main(String[] args) throws IOException {
        final FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        final byte[] input = { 65, 66, 67, 68 };
        fos.write(input);

        fos.close();

        final FileInputStream fis = new FileInputStream("temp/hello.dat");
        final byte[] readBytes = fis.readAllBytes();
        System.out.println(Arrays.toString(readBytes));
        fis.close();
    }
}
