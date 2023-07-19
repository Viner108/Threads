package task;

import java.io.*;

public class ReadAndWriteThread extends Thread{
    private File file;

    public ReadAndWriteThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        synchronized (file){
            try (RandomAccessFile file1=new RandomAccessFile(file,"rw")){
                file1.seek(file.length());
                file1.write("From Java".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
