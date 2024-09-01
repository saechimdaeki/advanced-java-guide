package thread.start;

public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        final HelloRunnable runnable = new HelloRunnable();
        final Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");

    }
}
