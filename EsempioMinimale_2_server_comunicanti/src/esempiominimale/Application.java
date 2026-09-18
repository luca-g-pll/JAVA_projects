/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempiominimale;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author MULTI01
 */
public class Application implements ICommandConsumer {

    private final SenderProtocolManager sender;
    private final Map<String, SenderProtocolManager> senders;
    private String username;

    public Application(Map<String, SenderProtocolManager> senders, SenderProtocolManager sender) {
        this.senders = senders;
        this.sender = sender;
    }

    @Override
    public void logout() {
        senders.remove(username);
        Set<String> keys = senders.keySet();
        for (String key : keys) {
            senders.get(key).sendLogout(username);
        }
    }

    @Override
    public void login(String username) {
        if (!senders.containsKey(username)) {
            if (this.username == null) {
                this.username = username;
                senders.put(username, sender);
                Set<String> keys = senders.keySet();
                for (String key : keys) {
                    senders.get(key).sendLogin(username);
                }
                sender.sendUserList(keys);
            } else {
                sender.sendLoginFailed(2);
            }
        } else {
            sender.sendLoginFailed(1);
        }
    }

    @Override
    public void message(String message) {
        Set<String> keys = senders.keySet();
        for (String key : keys) {
            senders.get(key).sendMessage(username, message);
        }
    }

    @Override
    public void error(int code) {
        sender.sendError(code);
    }

    @Override
    public void close() {
        sender.close();
    }
}
