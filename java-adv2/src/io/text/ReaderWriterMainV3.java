package io.text;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        final String writerString = "abc";
        System.out.println("Write string: " + writerString);

        // 파일에 쓰기

        final FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        fw.write(writerString);
        fw.close();

        // 파일에서 읽기
        final StringBuilder content = new StringBuilder();
        final FileReader fr = new FileReader(FILE_NAME, UTF_8);
        int ch;
        while ((ch = fr.read()) != -1) {
            content.append((char) ch);
        }
        fr.close();

        System.out.println("Read string: " + content);
    }
}
