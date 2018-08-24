/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailServer;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private ArrayList<Email> sentMails;
    private ArrayList<Email> receivedMails;

    public User(String userName) {
        this.userName = userName;
        sentMails = new ArrayList<>();
        receivedMails = new ArrayList<>();

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Email> getSentMails() {
        return sentMails;
    }

    public ArrayList<Email> getReceivedMails() {
        return receivedMails;
    }
    public void newReceivedMail (Email mail){
        receivedMails.add(mail);
    }

    public void newSentMail (Email mail){
        sentMails.add(mail);
    }

}
