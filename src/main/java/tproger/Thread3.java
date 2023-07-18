package tproger;

public class Thread3 extends Thread{
    @Override
    public void run() {
        throw new RuntimeException("Ошибка из Thread3 ");
    }
}
