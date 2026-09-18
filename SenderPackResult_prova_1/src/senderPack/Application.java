package senderPack;

import io.Sender;

public class Application implements ICommandConsumer{


    private SenderProtocolManager protocolSender;

    public Application(SenderProtocolManager s){
        this.protocolSender = s;
    }

    @Override
    public void calculate(String operator, int op1, int op2) {
        int result = 0;
        switch (operator) {
            case "+" :   result = op1 + op2;
            break;
            case "-" :   result = op1 - op2;
            break;
            case "*" :   result = op1 * op2;
            break;
            case "/" :   result = op1 / op2;
        }

        protocolSender.prepareMessage(operator,op1,op2,result);
    }

    @Override
    public void close() {
        protocolSender.close();
    }
}
