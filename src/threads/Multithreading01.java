package threads;

public class Multithreading01 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        CounterWithOutMultiThread counter1 = new CounterWithOutMultiThread("Ebubekir");
        CounterWithOutMultiThread counter2 = new CounterWithOutMultiThread("Akin");
        System.out.println("-------------------------");
        counter1.countMe();
        System.out.println("-------------------------");
        counter2.countMe();

        long finish = System.currentTimeMillis();
        System.out.println("WithOutMultiThread ile gecen sure: " + (finish - start));

        long start2 = System.currentTimeMillis();

        CounterWithMultiThread counter3 = new CounterWithMultiThread("Ilker");
        CounterWithMultiThread counter4 = new CounterWithMultiThread("Abdullah");
        System.out.println("-------------------------");
        counter3.start();
        counter3.setName("Ilker");
        System.out.println("-------------------------");
        counter4.start();
        counter4.setName("Ilker");

        try {
            counter3.join();// main threade counter3 threadinin işlemi bitene kadar bekle
            counter4.join();// main threade counter3 threadinin işlemi bitene kadar bekle
                            // sonra tekrar main thread devam etsin
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish2 = System.currentTimeMillis();
        System.out.println("WithMultiThread ile gecen sure: " + (finish2 - start2));
    }
}

class CounterWithOutMultiThread {
    public String name;

    public CounterWithOutMultiThread(String name) {
        this.name = name;
    }

    //thread kullanmadan 1 den 10 a kadar yazdıran metod
    public void countMe() {
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i: " + i + " - " + name);
        }
    }
}

class CounterWithMultiThread extends Thread {
    public String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    //thread ile ekrana 1 den 10 a kadar yazdırma
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " calismaya basladi.");
        countMe();
    }

    public void countMe() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : " + i + " - " + name);
        }
    }
}
