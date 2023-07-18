package tproger;

import java.util.concurrent.atomic.AtomicReference;

public class ThreadDemo2 {
    public static void main (String[] args) throws InterruptedException {
        AtomicReference<RuntimeException> exception3 = new AtomicReference<>();
        Thread thread1 = new Thread1();
        thread1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Поймана ошибка в основном потоке " + e.getMessage());
            exception3.set(new RuntimeException(e.getMessage() + "Ошибка из Thread1 ", e));
        });
        thread1.start();

        thread1.join();
        throw exception3.get();

    }
}
