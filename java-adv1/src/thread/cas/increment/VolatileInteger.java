package thread.cas.increment;

/**
 * 안전한 임계 영역이 없기에 멀티 스레드 상황에서 사용할 수 없음.
 * 단일 스레드가 사용하기에는 BingInteger보다 느리다. 멀티스레드 상황에도 안전하지 않다
 */
public class VolatileInteger implements IncrementInteger{

    private volatile int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
