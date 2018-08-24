/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailServer;

import java.io.*;
import java.util.ArrayList;

public class EmailManager implements Serializable {

    private static ArrayList<Email> emails;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private String emailManagerSerFile = "emailmanager.ser";
    //private boolean isInstantiated = false;

    public EmailManager() {
        synchronized (this) {
            try {
                inputStream = new ObjectInputStream(new FileInputStream(emailManagerSerFile));
                emails = (ArrayList<Email>) inputStream.readObject();
                inputStream.close();
            } catch (EOFException | FileNotFoundException e) {
                emails = new ArrayList<>();
            } catch (Exception e) {
                System.out.println("Errore durante la deserializzazione di emailmanager: " + e);
                System.exit(0);
            }
        }

    }

    public void addEmail(Email mail) {
        emails.add(mail);
    }

    public ArrayList<Email> getUserEmails(User utente) {
        ArrayList<Email> mails = new ArrayList<>();
        String userMail = utente.getUserName();
        for (Email mail : emails) {
            if (mail.getReceiver().equals(userMail)) {
                mails.add(mail);
            }
        }
        return mails;

    }

    //THIS IS SYNCHRONIZED TO PRESERVE THE FILE STATE.
    synchronized public void saveEmailState() {
        //TODO: check if this serialization works.

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(emailManagerSerFile));
            outputStream.reset();
            outputStream.writeObject(emails);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void deleteAllMails() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(emailManagerSerFile));
            outputStream.reset();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
