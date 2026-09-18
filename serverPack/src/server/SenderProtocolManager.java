package server;

import io.Sender;
public class SenderProtocolManager {
    private Sender sender;

    public SenderProtocolManager(Sender sender){
        this.sender = sender;
    }

    public void prepareMessage(String operator, int op1, int op2, int res){
        String message = op1 + operator + op2 + '=' + res;
        sender.send(message);
    }

    public void close(){
        sender.close();
    }
}