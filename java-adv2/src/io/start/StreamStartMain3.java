package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

    public static void main(String[] args) throws IOException {
        final FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        final byte[] input = { 65, 66, 67, 68 };
        fos.write(input);

        fos.close();

        final FileInputStream fis = new FileInputStream("temp/hello.dat");
        final byte[] buffer = new byte[10];
        final int readCount = fis.read(buffer, 0, 10);
        System.out.println("readCount = " + readCount);
        System.out.println(Arrays.toString(buffer));
        fis.close();
    }
}
