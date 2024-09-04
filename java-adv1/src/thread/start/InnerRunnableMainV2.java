package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main() start");
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };

        new Thread(runnable).start();

        log("main() end");
    }

}