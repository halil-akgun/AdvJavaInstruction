package threads;

/*
Ölümcül kilitlenme; iki veya daha fazla thread'in işlemlerini tamamlamak için birbirinin
kilitlemiş olduğu kaynaklara erişmek istemesi gibi durumlarda oluşur.
Bu da uygulamayı olumsuz etkiler, sunucu cevap veremez hale gelir.
 */
public class DeadlockDemo {
    public static void main(String[] args) {
        String obj1 = "kahve";
        String obj2 = "seker";

        // kullanim sirasi ayni olursa deadlock olmaz

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + " " + obj1 + " kullaniyor");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + obj2 + " bekliyor");
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + " " + obj2 + " kullaniyor");
                    }
                }
            }
        });
        thread1.setName("A");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + " " + obj1 + " kullaniyor");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + obj1 + " bekliyor");
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + " " + obj2 + " kullaniyor");
                    }
                }
            }
        });
        thread2.setName("B");
        thread2.start();
    }
}
