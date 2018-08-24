/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailClient;

import it.unito.studenti.nocerino.mattia.MailServer.Email;
import it.unito.studenti.nocerino.mattia.MailServer.User;

import java.rmi.Remote;
import java.util.ArrayList;

interface ClientResponderInterface extends Remote {
    Email getEmail(int id);

    User getUser(int id);

    void sendMail(Email mail);

    ArrayList<Email> getUserMails(User user);

}
