package esempioudpserver;

import java.sql.SQLOutput;

public class btye {
    public static void main(String[] args) {
        int originalValue = 280; // Replace with your desired int value

        // Convert int to byte array
        byte[] byteArray = intToByteArray(originalValue);

        // Print the original int value
        System.out.println("Original int value: " + originalValue);

        // Print the byte array
        System.out.print("Byte array: ");
        for (byte b : byteArray) { //il primo  è il secondo da madnare(meno significativo) il secondo è il più significativo
            //es. 280 -->  su due byte = 1 - 24 , nel array è disposto 24-1
            System.out.print(b + " ");
        }
        System.out.println();

        // Convert byte array back to int
        int reversedValue = byteArrayToInt(byteArray);

        // Print the reversed int value
        System.out.println("Reversed int value: " + reversedValue);




        System.out.println("\n divisione inetra : "+(33/5));
    }

    public static byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[2];
        for (int i = 0; i < 2; i++) {
            byteArray[i] = (byte) (value >> (i * 8));
        }
        return byteArray;
    }

    public static int byteArrayToInt(byte[] byteArray) {
        int value = 0;
        for (int i = 0; i < 2; i++) {
            value += (byteArray[i] & 0xFF) << (i * 8);
        }
        return value;
    }



}

