/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailServer;

import java.io.Serializable;

public class Email implements Serializable {
   /*
   I messaggi di posta elettronica sono istanze di una classe Email che specifica
   ID, mittente, destinatario, argomento, testo e data di spedizione del messaggio. -
   */

    private int emailId;
    private String sender;
    private String receiver;
    private String subject;
    private String text;
    private String dateTime;

    public Email(int emailId, String sender, String receiver, String subject, String text, String dateTime) {
        this.emailId = emailId;
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.text = text;
        this.dateTime = dateTime;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
