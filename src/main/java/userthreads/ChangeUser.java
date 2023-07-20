package userthreads;

import java.io.*;
import java.util.ArrayList;

public class ChangeUser extends Thread {
    private File file;

    public ChangeUser(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        synchronized (file) {
            if (file.length() != 0) {
                ArrayList<User> users = null;
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    users = ((ArrayList<User>) ois.readObject());
                    for (int i = 0; i < users.size(); i++) {
                        User user = users.get(i);
                        if (user.getId() % 2 == 0) {
                            users.remove(user);
                            users.add(new User(user.getId() + 1000, user.getName() + " изменено"));
                        }
                    }
                    write(users, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
