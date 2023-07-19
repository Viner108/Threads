package task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriterThread implements Runnable {
    private File file;

    public WriterThread(File file) {
        this.file = file;
    }

    public void run(){
        synchronized (file) {
                try (BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
                    writer.write("Hello, Lera!");
                } catch ( IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
