package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {
        //ilk çalışan thread main threaddir, görelim:
        System.out.println("Current thread: " + Thread.currentThread().getName());

        //Thread classını extend ederek
        MyThread thread1 = new MyThread();
        thread1.start();
        //start metodu thread oluşturur, override edilen run metodunu çağırır ve içerisindeki işlemleri
        //gerçekleştirir.
        //doğrudan run metodu çağrıldığında içindeki işlemler yapılır ancak thread oluşmaz. Yani run metodu main
        //thread içinde çalışmış olur.

        // Runnable interfaceini implement ederek
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        //annonymous(isimsiz) class ile thread oluşturma
        //Runnable interfaceini implement eden isimsiz bir class
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//5 sn threadi duraklattık
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current thread3:" + Thread.currentThread().getName());
                System.out.println("Bu thread3 isimsiz class ile oluşturuldu.");
            }
        });
        thread3.setName("threadcik");
        thread3.start();

        //annonymous(isimsiz) class ile thread oluşturma:2
        //lambda exp kullanarak
        Thread thread4 = new Thread(() -> {
            Thread.currentThread().setName("harika");
            System.out.println("Current thread4:" + Thread.currentThread().getName());
            System.out.println("Bu thread4 lambda ile oluşturuldu.");
        }
        );
        thread4.start();


        Thread thread5 = new Thread(() -> {
            System.out.println("Current thread5:" + Thread.currentThread().getName());
            System.out.println("Bu thread5 lambda ile oluşturuldu.");
        });
        thread5.start();

        System.out.println("main metodun işlemi burada bitti");


    }

}

//Thread oluşturma:
//1.yol : Thread Classını extend ederek
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread threadi çalışıyor. ");
    }
}

//2.yol : Runnable interfaceini implement ederek
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable ile oluşturduğumuz thread çalışıyor.");
    }
}