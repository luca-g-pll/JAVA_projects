
package ClientEsercizio2C;

import io.IMessageConsumer;

/**
 *
 * @author MULTI01
 */
public class ReceiverProtocolManager implements IMessageConsumer{
    ICommandConsumer consumer;

    public ReceiverProtocolManager(ICommandConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void consumeMessage(String message) {
        String [] array=message.split("##");
        if(!array[0].equals("Quit")){
            consumer.visualize(array[0], array[1]);
        }
    }   

    @Override
    public void close() {
       
    }
}
