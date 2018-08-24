/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */

package it.unito.studenti.nocerino.mattia.MailServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Controller {
    @FXML
    public Button sayHello;
    @FXML
    public Button clearLog;
    private Logger myAppLogger = null;
    private EmailManager mailManager = null;
    private UserManager usrManager = null;
    @FXML
    private Button closeApp;
    @FXML
    private TextArea txtArea;

    public void deallocateAppAndClose() {
        writeToLogWindow("Chiusura applicazione");


        mailManager.saveEmailState();
        writeToLogWindow("Email state salvato");

        usrManager.saveUserState();
        writeToLogWindow("User state salvato");
        writeToLogWindow("Chiusura log.");
        try {
            myAppLogger.closeLog();
        } catch (Exception e) {
            System.out.println("Error while closing log");
        }
        System.exit(0);
    }

    public void chiudiApp(ActionEvent actionEvent) {
        //TODO: gracefully close all connections to the server and leave a goodbye message
        deallocateAppAndClose();

    }

    public void disconnectClients(ActionEvent actionEvent) {
        writeToLogWindow("Richiesta disconnessione dei client");
    }

    public void sayHello(ActionEvent actionEvent) {
        writeToLogWindow("Hello, World!");

    }

    public void clearLogWindow(ActionEvent actionEvent) {
        txtArea.clear();
        writeToLogWindow("Pulita la finestra di log");
    }


    public void writeToLogWindow(String text) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);

        String toWrite = reportDate + " | " + text;
        try {
            myAppLogger.writeToLog(toWrite);
        } catch (Exception e) {
            System.out.println("Error while writing to log");
        }
        txtArea.appendText(toWrite + "\n");

    }

    public void initialize() {
        myAppLogger = new Logger(true);
        mailManager = new EmailManager();
        usrManager = new UserManager();

        writeToLogWindow("Applicazione avviata");

        //TODO: make ClientResponder a threaded class complete with own interface for clients which will respond to requests made by other clients.
        //ClientResponder clientResponder = new ClientResponder(mailManager,usrManager);
    }

}
