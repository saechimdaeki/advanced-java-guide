package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        log("main() start");

        final HelloRunnable runnable = new HelloRunnable();

        for (int i = 0; i < 100; i++) {
            final Thread thread = new Thread(runnable);
            thread.start();
        }

        log("main() end");

    }
}
