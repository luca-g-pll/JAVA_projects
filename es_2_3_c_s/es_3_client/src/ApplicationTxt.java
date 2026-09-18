import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApplicationTxt implements ICommandConsumer {

    SenderProtocol senderProtocol;

    public ApplicationTxt(SenderProtocol  sender ){

        senderProtocol=sender;
        inputMenu();
    }
    private void menu(){
        System.out.println("\nMENU comandi");
        System.out.println("1. maiuscolo");
        System.out.println("2. minuscolo");
        System.out.println("3. inversione");
        System.out.println("4. eliminaConsonanti");
        System.out.println("5. eliminaVocali");
        System.out.println("6. eliminaSpazi");
        System.out.println("8. quit --> chiusura connessione");

    }

    private String cmd() {
        String userInput = null;
        try {
            System.out.print("Inserisci 'cmd stringa' : ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            userInput = in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    public void inputMenu(){
        this.menu();
        String cmd = this.cmd();
        String stringa="";
        //da qui devo controllare la stringa
        if(!cmd.equals("quit")){
            stringa = "Inserisci il 'cmd##stringa' : ";
            //senderProtocol.buildMessage();
            //mandare la stringa al server
            senderProtocol.buildMessage(cmd,stringa);
        }else{
            this.close();
        }


    }
    //implementazine dei diversi comandi da richiamare

    @Override
    public void close() {
        senderProtocol.close("quit"); //entrambe le parti dovranno inviarsi il quit
    }

    @Override
    public void show(String command, String string) {
        System.out.println(command+" : "+string);
        inputMenu();
    }
}
