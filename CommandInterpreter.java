package Chat.ChatApp;

import java.io.*;
import java.util.*;

public class CommandInterpreter implements Observer, Runnable{
    private InputStream inputStream;
    private PrintStream outputStream;
    HashSet<String> c = new HashSet<String>();
    String newName = "";

    public CommandInterpreter(InputStream inputStream, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;

        //adds the commands to the HashSet
        c.add("$user");
        c.add("$users");
        c.add("$messages");
        c.add("$quit");

        //registers the CI as an observer
        ChatHistory.getInstance().addObserver(this);
    }
    //command interpreting
    protected void interpret() {
        /*inputStream = (System.in);
        outputStream = (System.out);*/
        Scanner in = new Scanner(inputStream);
        String lineQuit = "$quit";
        boolean stop = false;
        outputStream.println("Enter command: ");
        do
        { if(!in.hasNext()) continue;
            String command = in.nextLine();
            stop = command.equals(lineQuit);
            try {
                if (command.startsWith("$") && command.contains("$help")) {
                    outputStream.println(c);
                }
                if (command.startsWith("$user ")) {
                    newName = command.substring(command.lastIndexOf(" ") +1);
                    if(command.length() == 6) {
                        outputStream.println("Invalid username");
                    } else {
                        outputStream.println("Your username is now: " + newName);
                        UserNameList.getInstance().addUser(newName);
                    }
                }
                if (command.startsWith("$users")) {
                    outputStream.println(UserNameList.getInstance().listUsers());
                }
                if (!(command.startsWith("$")) && (!(newName.isEmpty()))) {
                    ChatMessage message = new ChatMessage(this.newName, command);
                    ChatHistory.getInstance().insert(message);

                }
                if (command.startsWith("$messages")) {
                    outputStream.println(ChatHistory.getInstance().toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            outputStream.println("Enter command: ");
        } while(!stop);
        ChatHistory.getInstance().deleteObserver(this);
        outputStream.println("Bai!");

    }

    //run in a thread
    public void run() {
        interpret();
    }

    @Override
    public void update(Observable observable, Object arg) {
        try {
            outputStream.println((ChatMessage) arg);
        }   catch (Exception e) {}
    }
}