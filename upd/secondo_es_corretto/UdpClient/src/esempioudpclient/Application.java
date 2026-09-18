/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpclient;

import java.net.InetAddress;

/**
 *
 * @author MULTI01
 */
public class Application implements ICommandConsumer {


    
    View view;
    public Application( View view) {
        this.view=view;
    }

    //metodo stampa +
    @Override
    public void printSum(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4) {
        System.out.println("\noperazione : "+(0xFF & aByte1) +" + "+(0xFF & aByte2));
        this.printEndresult(aByte3,aByte4);
    }

    //metodo stampa -
    @Override
    public void printSub(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4) {
        System.out.println("\noperazione : "+(0xFF & aByte1) +" - "+(0xFF & aByte2));
        this.printEndresult(aByte3,aByte4);

    }

    //metodo stampa *
    @Override
    public void printMul(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4) {
        System.out.println("\noperazione : "+(0xFF & aByte1) +" * "+(0xFF & aByte2));
        this.printEndresult(aByte3,aByte4);

    }

    //metodo stampa /
    @Override
    public void printDiv(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4) {
        System.out.println("\noperazione : "+(0xFF & aByte1) +" / "+(0xFF & aByte2));
        this.printEndresult(aByte3,aByte4);

    }

/*
quando ho trasformato in array byte all'inizio nel server=
il primo  è il secondo da madnare(meno significativo) il secondo è il più significativo
es. 280 -->  su due byte = 1 - 24 , nel array è disposto 24-1
 */
    private static int byteArrayToInt(byte[] byteArray) {
        int value = (byteArray[1] & 0xFF)*256 + byteArray[0];
        return value;
    }

    //metodo per la stampa finale del risultato che è uguale per tutti i metodi
    private void printEndresult(byte aByte3, byte aByte4){        
        int result = (0xFF & aByte3)+(0xff & aByte4)*256;
        view.updateResult(result);
    }

}
