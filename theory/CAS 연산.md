

# CAS 연산

### 락 기반 방식의 문제점

synchronized, Lock(ReentrantLock)등은 특정 자원을 보호하기 위해 스레드가 해당 자원에 대한 접근하는 것을 제한한다

락이 걸려 있는 동안 다른 스레드들은 해당 자원에 접근할 수 없고 락이 해제될 때까지 대기해야한다.

예를 들어 락을 사용하는 연산이 있다고 가정하면 락을 사용하는 방식은 다음과 같이 작동한다

1. 락이 있는지 확인한다
2. 락을 획득하고 임계 영역에 들어간다
3. 작업을 수행한다
4. 락을 반납한다

ex) 여기서 락을 획득하고 반납하는 과정이 계속 반복된다. 10000번의 연산이 있다면 10000번의 연산 모두 같은 과정을 반복한다

## CAS

이런 문제를 해결하기 위해 락을 걸지 않고 원자적인 연산을 수행할 수 있는 방법이 있는데 이것을 CAS(compare-and-swap, compare-and-set) 이라고 한다


이 방법은 락을 사용하지 않기 때문에 락 프리 기법이라고 한다. cas연산은 락을 완전히 대체하는 것은 아니고 작은 단위의 일부 영역에 적용할 수 있다.

기본은 락을 사용하고, 특별한 경우에 CAS를 적용할 수 있다고 생각하면 된다

```java

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

```

#### compareANdSet(0,1)

atomicInteger 가 가지고 있는 값이 현재 0 이면 1로 변경

- 만약 atomicInteger의 값이 현재 0이라면 atomicInteger의 값은 1로 변경된다. 이 경우 true를 반환
- 만약 atomicInteger의 값이 현재 0이 아니라면 atomicInteger의 값은 변경되지 않는다. 이 경우 false를 반환

여기서 중요한건 이 메소드는 원자적으로 실행된다는 점이다.

왜 원자적 연산인가..? 

### cpu 하드웨어의 지원

CAS연산은 이렇게 원자적이지 않은 두 개의 연산을 cpu 하드웨어 차원에서 특별하게 하나의 원자적인 연산으로 묶어서 제공하는 기능이다

이것은 소프트웨어가 제공하는 기능이 아니라 하드웨어가 제공하는 기능. 

CPU는 다음 두 과정을 묶어서 하나의 원자적인 명령으로 만들어 버린다. 따라서 중간에 다른 스레드가 개입할 수 없다.

1. x001 (예시) 메모리 주소에 저장된 값을 읽어온다
2. 읽은 값이 0ㅇ면 1로 변경한다

cpu는 두 과정을 하나의 원자적인 명령으로 만들기 위해 1번과 2번 사이에 다른 스레드가 x001의 값을 변경하지 못하게 막음

참고로 1번과 2번 사이의 시간은 cpu 입장에서 보면 아주 잠깐 순간이라 성능에 큰 영향을 끼치지 않음


