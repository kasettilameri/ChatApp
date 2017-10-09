package Chat.ChatApp;
import java.io.PrintStream;
import java.util.HashSet;

public class UserNameList {
    private String userName;
    private HashSet<String> userNameListHashSet = new HashSet<String>();
    private PrintStream output;

    private UserNameList() {
        this.output = output;
    }

    public static UserNameList getInstance() {
        return INSTANCE;
    }
    private static final UserNameList INSTANCE = new UserNameList();

    public void addUser(String userName) {
        this.userName = userName;
        if (userNameListHashSet.contains(this.userName)) {
            throw new java.lang.UnsupportedOperationException("error");
        } else {
            userNameListHashSet.add(this.userName);
        }
    }

    public String listUsers() {
        return userNameListHashSet.toString();
    }
}