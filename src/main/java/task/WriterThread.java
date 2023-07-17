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

    @Override
    public void run() {
        synchronized (file) {
            while (true) {
                try {
                    Files.write(file.toPath(), List.of("Hello!", "Lera"));
                    System.out.println("Writer wrote down the text");
                    file.notifyAll();
                    file.wait();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
