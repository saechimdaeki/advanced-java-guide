package io.text;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        final String writeString = "ABC";
        System.out.println("Write string: " + writeString);

        // 파일에 쓰기
        final FileOutputStream fos = new FileOutputStream(FILE_NAME);
        final OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);

        osw.write(writeString);
        osw.close();

        // 파일에서 읽기

        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = isr.read()) != -1) {
            content.append((char) ch);
        }
        isr.close();

        System.out.println("read String = " + content);
    }
}
