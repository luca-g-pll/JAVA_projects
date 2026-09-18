package ClientEsercizio2C;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MULTI01
 */
public class Application2 implements ICommandConsumer{
     SenderProtocolManager sender;
     
     public Application2(SenderProtocolManager sender){
         this.sender=sender;
         input();
     }

     
    private void input() {
        String menu="Maiuscolo\nMinuscolo\nInversione\nEliminaSpazi\nEliminaVocali\nEliminaConsonanti\nQuit";
        String scelta=JOptionPane.showInputDialog(menu);
        String stringa="";
        if(!scelta.equals("Quit")){
            stringa=JOptionPane.showInputDialog("Inserire la stringa");
        }
        sender.send(scelta, stringa);
    }

    @Override
    public void visualize(String cmd, String string) {
        JOptionPane.showMessageDialog(null,cmd+" : "+string);
        input();
    }

    
}
