package server;

import io.IMessageConsumer;

public class ReceiverProtocolManager implements IMessageConsumer{
    private ICommandConsumer consumer;
    public ReceiverProtocolManager(ICommandConsumer consumer){
        this.consumer = consumer;
    }


    @Override
    public void consumeMessage(String s) {
        if(s.equals("quit")){
            consumer.close();
            return;
        }
        int i = 0;
        String operator = null;
        for (i = 0; i < s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) >= '='){break;}
        }
        int lenghtOp1 = i;
        consumer.calculate(s.substring(lenghtOp1, lenghtOp1 + 1)
                ,Integer.parseInt(s.substring(0, lenghtOp1))
                ,Integer.parseInt(s.substring(lenghtOp1 + 1, s.length())));

    }
}
