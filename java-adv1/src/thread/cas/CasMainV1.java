package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        final boolean result1 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result 1 = " + result1 + ", value = " + atomicInteger.get());

        final boolean result2 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result 2 = " + result2 + ", value = " + atomicInteger.get());
    }
}
