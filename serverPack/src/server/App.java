package server;

public class App implements ICommandConsumer {
    SenderProtocolManager senderProtocolManager;
    int result;

    public App(SenderProtocolManager senderProtocolManager) {
        this.senderProtocolManager = senderProtocolManager;
        result = 0;
    }

    @Override
    public void calculate(String oper, int op1, int op2) {
        switch (oper) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
        }
        senderProtocolManager.prepareMessage(oper, op1, op2, result);
    }
    @Override
    public void close() {
        senderProtocolManager.close();
    }
}