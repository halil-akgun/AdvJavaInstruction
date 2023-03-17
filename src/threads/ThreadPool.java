package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        ThreadCreator thread1 = new ThreadCreator("A");
        ThreadCreator thread2 = new ThreadCreator("B");
        ThreadCreator thread3 = new ThreadCreator("C");
        ThreadCreator thread4 = new ThreadCreator("D");
        ThreadCreator thread5 = new ThreadCreator("E");
        ThreadCreator thread6 = new ThreadCreator("F");

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);

        service.shutdown();  // shutdown olmazsa program bitmez
    }
}

class ThreadCreator extends Thread {
    private String name;

    public ThreadCreator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " basladi");
        System.out.println(threadName + " - " + name + " islerini yapiyor");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + " islerini bitirdi");
    }
}