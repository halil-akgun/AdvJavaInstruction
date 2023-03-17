package threads;

/*
Birden fazla thread aynı değişkende değişiklik yaparken
CPU üzerinde farklı çekirdeklerde çalışabilir.
Değişkenin bilgisi hız kazanmak için main memory yerine çekirdeğin cacheinde
tutulursa bir threadin yaptığı güncellemeden diğer threadlerin haberi olmayabilir.
Değişken bilgisinin cache yerine main memorye yazılıp oradan çağrılmasını sağlamak için
Volatile keywordü kullanılır. Dolayısıyla her threadin güncellemeleri görmesi garanti altına alınır.
 */
public class Volatile {

    public volatile static int flag = 0; // degisken bilgisinin main memoryde tutulmasini garantilemis oluyoruz
                                        // cpu cache ine kaydedilmez

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag == 0) System.out.println("thread1 calisiyor");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag = 1;
                System.out.println("flag: 1 oldu");
            }
        });
        thread2.start();

        // 2 ayri cekirdegin cachinde flag degeri tutulursa threasler guncel degeri goremeyebilirler
    }
}
