package userthreads;

import tproger.Thread1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserThreads {
    volatile private static File file = new File("task/Users.java");

    public static void main(String[] args) throws IOException {
        User user1=new User(1,"Link");
        User user2=new User(2,"Java");
        User user3=new User(3,"The");
        ArrayList arrayList=new ArrayList();
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        Thread threadwrite=new WriteUser(file,arrayList);
        Thread threadread=new ReadUser(file);
        Thread threadchange=new ChangeUser(file);
        threadwrite.start();
        threadchange.start();
        threadread.start();
        try {
            threadwrite.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
