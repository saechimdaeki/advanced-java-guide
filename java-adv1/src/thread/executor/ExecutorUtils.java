package thread.executor;

import static util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            final int poolSize = poolExecutor.getPoolSize();
            final int active = poolExecutor.getActiveCount();
            final int queued = poolExecutor.getQueue().size();
            final long completedTask = poolExecutor.getCompletedTaskCount();
            log("[pool = " + poolSize + ", active = " + active + ", queuedTasks = " + queued + ", completedTask = " + completedTask + ']');
        } else {
            log(executorService);
        }
    }
}
