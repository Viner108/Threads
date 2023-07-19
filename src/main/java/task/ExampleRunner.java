package task;

import exception.MyThread;
import tproger.Thread1;

import java.io.File;
import java.io.IOException;

public class ExampleRunner {
    volatile static  File file=new File("task/file.txt");

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread threadwrite=new Thread(new WriterThread(file));
        Thread threadRaW=new Thread(new ReadAndWriteThread(file));
        Thread threadread=new Thread(new ReaderThread(file));
        threadwrite.start();
        threadRaW.start();
        threadwrite.join();
        threadRaW.join();
        threadread.start();
    }
}
