package com.example.kasettilameri.chatapp;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kasettilameri on 9.10.2017.
 */

public class Receiver implements Runnable {
    String ip = "192.168.43.107";
    int port = 16520;
    private Socket ss;
    private MainActivity mainActivity;
    private Sender sender;
    private InputStream inputStream;
    private PrintStream printStream;
    private Scanner scanner;
    private boolean stop = false;
    private String message = "";

    public Receiver(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void run() {
        try {
            this.ss = new Socket(ip, port);
            this.inputStream = ss.getInputStream();
            this.printStream = new PrintStream(ss.getOutputStream());

            Sender sender = new Sender(this.printStream);
            Thread senderThread = new Thread(sender);
            senderThread.start();

            this.scanner = new Scanner(inputStream);
            do {
                message = this.scanner.nextLine();
                passMsg(message);
            } while(!stop);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void passMsg(final String msg) {
        this.mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.appendMsg(msg);
            }
        });
    }



}

