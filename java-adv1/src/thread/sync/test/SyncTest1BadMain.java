package thread.sync.test;

public class SyncTest1BadMain {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        final Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        final Thread thread1 = new Thread(task);
        final Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("결과: " + counter.getCount());
    }

    static class Counter {
        private int count;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
