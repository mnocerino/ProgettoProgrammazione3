/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailServer;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Email newMail = new Email(1, "mnocerino", "ohanna", "Saluti", "Ciao Olivia", "TODAY");
        EmailManager mailManager = new EmailManager();
        ArrayList<Email> emails = mailManager.getEmails();
        for (Email mail : emails) {
            System.out.println(mail.getSubject());

        }
        System.out.println("Ho stampato tutte le mail");
        mailManager.addEmail(newMail);
        mailManager.addEmail(newMail);
        mailManager.addEmail(newMail);
        mailManager.addEmail(newMail);
        mailManager.addEmail(newMail);

        mailManager.saveEmailState();
        //endregion
        emails = mailManager.getEmails();
        for (Email mail : emails) {
            System.out.println(mail.getSubject());

        }
        //mailManager.deleteAllMails();
        UserManager usrManager = new UserManager();
        usrManager.saveUserState();
    }

}
