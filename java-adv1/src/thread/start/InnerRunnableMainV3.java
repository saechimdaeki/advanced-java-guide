package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("main() start");
        new Thread(() -> log("run()")).start();

        log("main() end");
    }

}
