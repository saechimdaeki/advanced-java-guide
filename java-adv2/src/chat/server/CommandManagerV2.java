package chat.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    private final SessionManager sessionManager;
    private static final String DELIMITED = "\\|";


    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        // /join|seong
        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITED);
            String username = split[1];
            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장했습니다.");
        } else if (totalMessage.startsWith("/message")) {
            // 클라이언트 전체에게 문자 보내기
            String[] split = totalMessage.split(DELIMITED);
            String message = split[1];
            // [seong] hello
            sessionManager.sendAll("[" + session.getUsername() + "] " + message);
        } else if (totalMessage.startsWith("/change")) {
            // /change|seong2
            String[] split = totalMessage.split(DELIMITED);
            String changeName = split[1];
            sessionManager.sendAll(session.getUsername() + "님이" + changeName + "로 이름을 변경했습니다.");
            session.setUsername(changeName);
        } else if (totalMessage.startsWith("/users")) {
            List<String> userNames = sessionManager.getAllUsername();
            StringBuilder sb = new StringBuilder();
            sb.append("전체 접속자 : ").append(userNames.size()).append("\n");
            for (String userName : userNames) {
                sb.append(" - ").append(userName).append("\n");
            }
            session.send(sb.toString());
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
        }

        if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        }

        sessionManager.sendAll(totalMessage);
    }
}
