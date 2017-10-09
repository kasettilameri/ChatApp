package Chat.ChatApp;

public class ChatMessage {
    private String user;
    private String message;

    public ChatMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }
    @Override
    public String toString() {
        return this.user + ": " + this.message;
    }
}