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
                try (BufferedReader reader=new BufferedReader(new FileReader(file))){
                    String s;
                    while((s=reader.readLine())!=null){
                        System.out.println(s);
                    }
//                    System.out.println("Reader read the text");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
