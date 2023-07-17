package exception;

public class MyThread extends Thread{
    @Override
    public void run() {
            throw new RuntimeException("Ошибка!");
    }
}
