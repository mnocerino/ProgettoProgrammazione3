/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailServer;

import java.io.*;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private static ArrayList<User> users;
    private String userMangerFileName = "userManagerSerFile.ser";

    public UserManager() {
        synchronized (this) {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(userMangerFileName));
                users = (ArrayList<User>) inputStream.readObject();
                inputStream.close();
            }
            catch (EOFException | FileNotFoundException e) {
                users = new ArrayList<>();
            } catch (Exception e) {
                System.out.println("Errore durante la deserializzazione di usermanager: " + e);
                System.exit(0);
            }
        }
    }

    public int getUserId(String mailName) {
        for (int i = 0; i < users.size(); i++) {
            User userSearch = users.get(i);
            if (userSearch.getUserName().equals(mailName)) return i;
        }
        return -1;
    }

    @SuppressWarnings("Duplicates")
    public void saveUserState() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(userMangerFileName));
            outputStream.reset();
            outputStream.writeObject(users);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
