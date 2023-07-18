package tproger;

import java.util.concurrent.atomic.AtomicReference;

public class Thread2 extends Thread{
    @Override
    public void run() {
        AtomicReference<RuntimeException> exception1 = new AtomicReference<>();
        Thread thread3=new Thread3();
        thread3.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Поймана ошибка во втором потоке - " + e.getMessage());exception1.set(new RuntimeException(e.getMessage() + "Ошибка из Thread2 ", e));
        });
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException |RuntimeException e) {
            e.printStackTrace();
        }
        throw exception1.get();
    }
}
