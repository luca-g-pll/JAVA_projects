package senderPack;

import io.IMessageConsumer;

public class ReceiverProtocolManager implements IMessageConsumer {

    private IMessageConsumer consumer;

    private ICommandConsumer iConsumer;
   // private Application app;

    public ReceiverProtocolManager(ICommandConsumer c){
        this.iConsumer = c;
       // this.app = app;
    }



    @Override
    public void consumeMessage(String s) {

         int i = -1;

         if(s.equals("quit")) {
             iConsumer.close();
         }else{
             boolean found = false;
             for(;!found;i++) {
                 if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                     found = true; // si ferma nel momentoin cui trova l aposizione dell'operatore
                     System.out.println(i);
                 }
             }
                 String oper = "" +s.charAt(i-1);
                 String op1 = s.substring(0,i-1);
                 String op2 = s.substring(i-1);
                 iConsumer.calculate(oper, Integer.parseInt(op1), Integer.parseInt(op2));


         }


    }


}
