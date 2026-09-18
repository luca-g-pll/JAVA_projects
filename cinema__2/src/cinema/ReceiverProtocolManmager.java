/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;
import  io.IMessageConsumer;

/**
 *
 * @author MULTI01
 */
public class ReceiverProtocolManmager implements IMessageConsumer{

    ICommandConsumer consumer;

    public ReceiverProtocolManmager(ICommandConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void consumeMessage(String s) {

        String[] cmd = s.split("%");
        String command = cmd[0];
        String[] parametri = null;
        if (cmd.length > 1) {
            parametri = cmd[1].split("!");
        }

        switch (command){
            case "Seats" : {
                if(parametri.length != 3 && parametri!= null ){//controllo dell'errore
                    consumer.error("missing parameters");
                    //break;
                }
                consumer.availableSeats(parametri[0],parametri[1],parametri[2]);
                break;
            }
            case "Booking" : {
                if(parametri.length != 4 && parametri!= null ){
                    consumer.error("missing parameters");
                    //break;
                }
                consumer.booking(parametri[0],parametri[1],parametri[2],parametri[3].split("#"));
                break;
            }
            case "Quit" : {
                this.close();
                break;
            }
            default : {
                consumer.error("unknown command");
                //break;
            }
        }
    }

    @Override
    public void close() {
        consumer.close();
    }
}
