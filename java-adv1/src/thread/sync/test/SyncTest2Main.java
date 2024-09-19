package thread.sync.test;

import static util.MyLogger.log;

public class SyncTest2Main {
    public static void main(String[] args) {
        final MyCounter myCounter = new MyCounter();

        final Runnable task = () -> {
            myCounter.count();
        };

        final Thread thread1 = new Thread(task, "Thread-1");
        final Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

    }

    static class MyCounter {
        public void count() {
            int localValue = 0;
            for (int i = 0; i< 1000; i++) {
                localValue++;
            }
            log("결과: " + localValue);
        }
    }
}
