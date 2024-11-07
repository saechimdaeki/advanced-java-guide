package network.tcp.v3;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        final Socket socket = new Socket("localhost", PORT);
        final DataInputStream input = new DataInputStream(socket.getInputStream());
        final DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결: " + socket);

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("전송 문자 : ");
            final String toSend = scanner.nextLine();
            output.writeUTF(toSend);
            log("client -> server: " + toSend);

            if ("exit".equals(toSend)) {
                break;
            }

            // 서버로부터 문자 받기
            final String received = input.readUTF();
            log("client <- server: " + received);

        }
        // 자원 정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
