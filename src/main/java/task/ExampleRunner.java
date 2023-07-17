package task;

import exception.MyThread;

import java.io.File;
import java.io.IOException;

public class ExampleRunner {

    public static void main(String[] args) throws InterruptedException, IOException {
        File file=new File("task/file.txt");
        System.out.println(file.createNewFile());
        Thread threadwrite=new Thread(new WriterThread(file));
        Thread threadread=new Thread(new ReaderThread(file));
        MyThread myThread=new MyThread();
//        myThread.setUncaughtExceptionHandler((t,e)-> System.out.println("Поймано исключение: "+ e.getMessage()));
        myThread.start();
        threadwrite.start();
        threadread.start();
        myThread.join();
        threadwrite.join();
        threadread.join();
    }
}
