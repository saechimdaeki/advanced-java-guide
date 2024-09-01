package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV1 {
    public static void main(String[] args) {
        log("main() start");

        final HelloRunnable runnable = new HelloRunnable();
        final Thread thread1 = new Thread(runnable);
        thread1.start();
        final Thread thread2 = new Thread(runnable);
        thread2.start();
        final Thread thread3 = new Thread(runnable);
        thread3.start();
        log("main() end");

    }
}
