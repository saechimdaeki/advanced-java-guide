package thread.start.test;

import static util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        final PrintWork printWork1 = new PrintWork("A", 1000);
        final PrintWork printWork2 = new PrintWork("B", 500);

        new Thread(printWork1, "Thread-A").start();
        new Thread(printWork2, "Thread-B").start();
    }

    static class PrintWork implements Runnable {
        private final String content;
        private final int sleepMs;

        PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
