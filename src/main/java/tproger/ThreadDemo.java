package tproger;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread thread2 = new Thread(() -> {
                    try {
                        Thread thread3 = new Thread(() -> {
                            throw new RuntimeException("Ошибка из Thread3");
                        });
                        thread3.setUncaughtExceptionHandler((t, e) -> {
                            System.out.println("Поймана ошибка во втором потоке - " + e.getMessage());
                        });
                        thread3.start();
                        thread3.join();
                        throw new RuntimeException("Ошибка из Thread2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread2.setUncaughtExceptionHandler((t, e) -> {
                    System.out.println("Поймана ошибка в первом потоке - " + e.getMessage());
                });
                thread2.start();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            }
        });
//        thread1.setUncaughtExceptionHandler((t, e) -> {
//            System.out.println("Поймана ошибка в первом потоке "+ e.getMessage());
//        });
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
