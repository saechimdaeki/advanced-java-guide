package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        final DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true);
        demonThread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");

    }

    static class DemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");

        }
    }
}
