import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class LerLinhas {

    public static void main(String data[]) {

        try {
            String nameNumberString;

            // Using file pointer creating the file.
            File file = new File(
                    "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");

            // Opening file in reading and write mode.

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // utilo String[] lineSplit = nameNumberString.split("!");

                // Print the contact data
                System.out.println(nameNumberString);
            }
        } catch (IOException ioe) {

            System.out.println(ioe);
        }
    }
}