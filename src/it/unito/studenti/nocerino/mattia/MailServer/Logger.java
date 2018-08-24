/*
 * Copyright (c) 2018.
 * Written by Mattia Nocerino   - mnocerino[at]gmail[dot]com
 *
 */
//TODO: make new exception class!
//TODO: make this a singleton
package it.unito.studenti.nocerino.mattia.MailServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class Logger {
    private final static String fileName = "log.txt";
    private PrintWriter logWriter;
    private boolean open = false;
    private boolean debug = false;


    Logger() {
        try {
            logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"), true));
            open = true;
        }
        //TODO: write catches
        catch (FileNotFoundException e) {
            System.out.println("Error at Logger: " + e);
        }

    }

    Logger(boolean requestedDebug) {
        try {
            logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"), true));
            open = true;
            debug = requestedDebug;
        }
        //TODO: write catches
        catch (FileNotFoundException e) {
            System.out.println("Error at Logger: " + e);
        }

    }

    void writeToLog(String toWrite) throws Exception {
        if (!open) throw new Exception("File not opened.");
        logWriter.println(toWrite);
        if (debug) System.out.println("Written to log file: " + toWrite);
    }

    void closeLog() throws Exception {
        if (!open) throw new Exception("File not opened.");
        logWriter.close();
    }
}
