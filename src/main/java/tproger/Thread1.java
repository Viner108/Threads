package tproger;

import java.util.concurrent.atomic.AtomicReference;

public class Thread1 extends Thread{
    @Override
    public void run() {
        AtomicReference<RuntimeException> exception2 = new AtomicReference<>();
        Thread thread2=new Thread2();
        thread2.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Поймана ошибка в первом потоке - " + e.getMessage()); exception2.set(new RuntimeException(e.getMessage() + "Ошибка из Thread1 ", e));
        });
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException |RuntimeException e) {
            e.printStackTrace();
        }
        throw exception2.get();
    }
}
