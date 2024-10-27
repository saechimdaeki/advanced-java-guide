package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {

    public static void main(String[] args) throws IOException {
        final byte[] input = { 1, 2, 3};

        // 메모리에 쓰기

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(input);

        // 메모리에서 읽기

        final ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        final byte[] bytes = bais.readAllBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
