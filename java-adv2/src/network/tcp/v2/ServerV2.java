package network.tcp.v2;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        final ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        final Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        final DataInputStream input = new DataInputStream(socket.getInputStream());
        final DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        while (true) {
            // 클라이언트로부터 문자 받기
            final String received = input.readUTF();
            log("client -> server: " + received);

            if ("exit".equals(received)) {
                break;
            }

            // 클라이언트에게 문자 보내기
            final String toSend = received + " World";
            output.writeUTF(toSend);
            log("client <- server: " + toSend);

        }
        // 자원 정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
