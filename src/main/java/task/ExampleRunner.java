package task;

import java.io.File;
import java.io.IOException;

public class ExampleRunner {

    public static void main(String[] args) throws InterruptedException, IOException {
        File file=new File("task/file.txt");
        System.out.println(file.createNewFile());
        Thread threadwrite=new Thread(new WriterThread(file));
        Thread threadread=new Thread(new ReaderThread(file));
        threadwrite.start();
        threadread.start();
        threadwrite.join();
        threadread.join();
    }
}
