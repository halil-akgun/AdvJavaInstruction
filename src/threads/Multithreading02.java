package threads;

//threadler aynı anda aynı kaynağa erişip değişiklik yapmak isterlerse ne olacak?
//multithreading programlamada birden fazla thread aynı kaynağa(critical section) aynı anda erişip değişiklik yapmaya çalışırsa
//istenmeyen sonuçlar olur. Bu durumda threadlere sırayla erişim verilir. Yani ortak kaynağı bir thread kullanırken diğer
//thread beklemelidir. Bu işlem syncronized keywordü ile gerçekleştirlir.
public class Multithreading02 {

    public static int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
            }
        });
        thread1.setName("Tom");
        thread1.start();

//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//tom un bütün işlemleri bitirmesi için jerrrynin beklemesine gerek yok, sadece count metodunu sırayla
//kullanmaları yeterli

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }
}

class Counter {
    public synchronized static void count() {
        // synchronized: metodu ayni anda sadece 1 thread kullanabilir
        for (int i = 1; i <= 1000; i++) {
            Multithreading02.counter++;
            System.out.println(Thread.currentThread().getName() + " --> counter: " + Multithreading02.counter);
        }
    }
}