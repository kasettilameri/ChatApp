package Chat.ChatApp;

public class Main {

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.serve();
    }
}