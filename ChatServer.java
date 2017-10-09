package Chat.ChatApp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public void serve() {
        try {
            ServerSocket ss = new ServerSocket(16520, 2);
            System.out.println("I have socket " + ss.getLocalPort());

            while(true) {
                Socket s = ss.accept();
                System.out.println("Accepted new connection");
                CommandInterpreter ci = new CommandInterpreter(s.getInputStream(), new PrintStream(s.getOutputStream(), true));
                ChatConsole cc = new ChatConsole();
                Thread t = new Thread(ci);
                Thread t2 = new Thread(cc);
                t.start();
                t2.start();
                //ci.run();
                //s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}