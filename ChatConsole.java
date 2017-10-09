package Chat.ChatApp;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

public class ChatConsole implements Runnable, Observer {
    public ChatConsole() {
        ChatHistory.getInstance().addObserver(this);
    }
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