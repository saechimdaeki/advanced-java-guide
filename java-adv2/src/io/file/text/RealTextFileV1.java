package io.file.text;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RealTextFileV1 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        final String writeString = "abc\n가나다";
        System.out.println("==== Write String ===");
        System.out.println(writeString);

        final Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);

        // 파일에서 읽기

        final String readString = Files.readString(path, UTF_8);

        System.out.println("==== Read String ===");
        System.out.println(readString);
    }
}
