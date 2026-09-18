/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempiominimale;

import io.Sender;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MULTI01
 */
public class SenderProtocolManager {
    
    private final Sender sender;
    private final Map<Integer, String> protocolErrors;
    private final Map<Integer, String> loginResult;
    
    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
        protocolErrors = new HashMap<>();
        protocolErrors.put(1, "Unknown command");
        protocolErrors.put(2, "Wrong parameter number");
        loginResult = new HashMap<>();
        loginResult.put(1, "username exists");
        loginResult.put(2, "You are logged");
    }
    
    void sendLogin(String username) {
        sender.send("Login#" + username);
    }
    
    void sendUserList(Set<String> users) {
        String message = "UserList#";
        for (String user : users) {
            message += user + "!";
        }
        message = message.substring(0, message.length() - 1);
        sender.send(message);
    }
    
    void sendMessage(String username, String message) {
        sender.send("Message#" + username + "#" + message);
    }
    
    void sendLogout(String username) {
        sender.send("Logout#" + username);
    }
    
    void close() {
        sender.close();
    }
    
    public void sendError(int code) {
        String message = "Error#" + protocolErrors.get(code);
        sender.send(message);
    }
    
    void sendLoginFailed(int code) {
        sender.send("LoginFailed#" + loginResult.get(code));
    }
}
