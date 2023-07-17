package exception;

public class Main {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler= (t, e) -> System.out.println("Поймано исключение: "+ e.getMessage());
        MyThread myThread=new MyThread();
        myThread.setUncaughtExceptionHandler(handler);
        myThread.start();

    }
}
