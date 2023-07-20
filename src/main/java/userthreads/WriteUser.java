package userthreads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteUser extends Thread {
    private File file;
    private ArrayList<User> userArrayList;

    public WriteUser(File file,ArrayList<User> userArrayList) {
        this.userArrayList =userArrayList;
        this.file=file;
    }

    @Override
    public void run() {
        synchronized (file) {
            write(userArrayList, false);
        }
    }

    private void write(ArrayList<User> allUser, boolean append) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, append))) {
            oos.writeObject(allUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
