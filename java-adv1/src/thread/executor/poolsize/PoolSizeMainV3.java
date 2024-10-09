package thread.executor.poolsize;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import thread.executor.RunnableTask;

public class PoolSizeMainV3 {
    public static void main(String[] args) {

        // 고정 스레드 풀 전략은 서버 자원은 여유있는데 사요자만 점점 느려지는 문제가 발생할 수 있다
        // 반면 캐시 스레드 풀 전략은 서버 자원을 최대한 사용하지만, 서버가 감당할 수 있는 임계점을 넘는 순간 시스템 다운될 수 있다


//        final ExecutorService es = Executors.newCachedThreadPool();

        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                              3, TimeUnit.SECONDS,
                                              new SynchronousQueue<Runnable>());

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 4; i++) {
            final String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 == ");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
    }
}
