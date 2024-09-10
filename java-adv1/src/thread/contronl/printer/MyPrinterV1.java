package thread.contronl.printer;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV1 {
    public static void main(String[] args) {
        final Printer printer = new Printer();
        final Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        final Scanner userInput = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력하세요 종료 (q): ");
            final String input = userInput.nextLine();
            if ("q".equals(input)) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        volatile boolean work = true;

        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {

            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                final String job = jobQueue.poll();
                log("출력 시작 : " + job + ", 대기 문서: " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }
            log("프린터 종료");
        }

        public void addJob(String input ){
            jobQueue.add(input);
        }
    }
}
