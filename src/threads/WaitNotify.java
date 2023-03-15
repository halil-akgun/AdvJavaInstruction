package threads;

/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.
*/
public class WaitNotify {
    public static int balance = 0;

    public static void main(String[] args) {

        WaitNotify waitNotify = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.withdraw(1000);
            }
        });
        thread1.setName("ogrenci");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.deposit(1000);
            }
        });
        thread2.setName("baba");
        thread2.start();
    }

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " para cekmek istiyor");
        if (balance < amount || balance < 0) {
            System.out.println("bakiye yetersiz. mevcut bakiye: " + balance);
            System.out.println("bakiyenin artmasini bekliyor");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("para cekme basarili. mevcut bakiye: " + balance);
        } else System.out.println("daha sonra gel");
    }

    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " para yatirmak istiyor");
        balance += amount;
        System.out.println("para yatirildi");
        notify();
        System.out.println();
        System.out.println("notify metodu cagrilinca hemen kilidi serbest birakmiyor metodun tamamlanmasini bekler");
    }
}
