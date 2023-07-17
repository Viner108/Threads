package task;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

public class ReaderThread implements Runnable {
    private File file;

    public ReaderThread(File file) {
        this.file = file;
    }

    @Override
    public void run(){
        synchronized (file) {
            while (true) {
                try (Stream<String> lines = Files.lines(file.toPath())) {
                    lines.forEach(System.out::println);
//                    System.out.println("Reader read the text");
                    file.notifyAll();
                    file.wait();
                } catch (IOException | InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
