package threadmeeting;

import java.util.concurrent.CountDownLatch;

public class CountDownMeetingJava {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        int count = 50;
        for (int i = 0; i < count; i++) {
            String threadName = "Thread" + i;
            new Thread(new RunnableDemo(threadName, latch)).start();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        latch.countDown();
    }
}

class RunnableDemo implements Runnable {
    private String threadName;
    CountDownLatch latch;

    RunnableDemo(String name, CountDownLatch latch) {
        threadName = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            this.latch.await();
        System.out.println("Running " + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

