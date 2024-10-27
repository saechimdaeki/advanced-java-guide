package io.start;

import static java.nio.charset.StandardCharsets.*;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        final PrintStream printStream = System.out;
        final byte[] bytes = "Hello!\n".getBytes(UTF_8);
        printStream.write(bytes);

        printStream.println("Print!");
    }
}
