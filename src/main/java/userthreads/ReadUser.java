package userthreads;

import java.io.*;
import java.util.ArrayList;

public class ReadUser extends Thread {
    private File file;

    public ReadUser(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (file) {
                for (User user : readfile()) {
                    System.out.println(user.toString());
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private ArrayList<User> readfile() {
        synchronized (file) {
            ArrayList<User> users = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = ((ArrayList<User>) ois.readObject());
            } catch (EOFException e) {
                e.printStackTrace();
                return users;
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            return users;

        }
    }
}
