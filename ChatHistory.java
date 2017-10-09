package Chat.ChatApp;

import javafx.collections.ObservableSet;

import java.io.PrintStream;
import java.util.*;

public class ChatHistory extends Observable{
    private ArrayList<ChatMessage> chatHistory = new ArrayList<ChatMessage>();
    private PrintStream output;

    private ChatHistory() {
    }
    private static final ChatHistory INSTANCE = new ChatHistory();
    public static ChatHistory getInstance() { return INSTANCE;}

    public void insert (ChatMessage message) {
        chatHistory.add(message);
        update(message);
    }

    public void update (ChatMessage message) {
        setChanged();
        notifyObservers(message);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(ChatMessage message : chatHistory) {
            builder.append(message.toString() + System.getProperty("line.separator"));
        }
        return builder.toString();
    }
}