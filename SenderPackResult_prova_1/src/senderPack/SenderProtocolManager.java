package senderPack;

import io.Sender;

public class SenderProtocolManager {
    private Sender sender;

    public SenderProtocolManager(Sender s){
        this.sender = s;
    }

    public void prepareMessage(String operator, int op1, int op2, int result){

        String message = op1 + " " + operator + " " + op2 + " = "+ result;
        sender.send(message);
    }

    public void close(){
        sender.close();
    }

}
