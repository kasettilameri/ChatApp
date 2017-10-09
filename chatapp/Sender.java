package com.example.kasettilameri.chatapp;

import java.io.PrintStream;

/**
 * Created by kasettilameri on 9.10.2017.
 */

public class Sender implements Runnable{
    private MainActivity mainActivity;
    private PrintStream printStream;
    private boolean stop = false;
    public Sender(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void run() {
        do {
            printStream.println();
        } while(!stop);
    }
}
