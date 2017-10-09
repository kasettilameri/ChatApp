package Chat.ChatApp;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

public class ChatConsole implements Runnable, Observer {
    @Override
    public void update(Observable observable, Object arg) {
        try {
            System.out.println((ChatMessage) arg);
        }   catch (Exception e) {}
    }

    @Override
    public void run() {
    }
}