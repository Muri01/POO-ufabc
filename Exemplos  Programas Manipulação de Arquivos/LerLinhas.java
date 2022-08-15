import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
 
class LerLinhas {
 
    public static void main(String data[])
    {
 
        try {
 
            String nameNumberString;
 
            // Using file pointer creating the file.
            File file = new File("/Users/humberto.t.marinho/OneDrive - Accenture/Desktop/ler arquivos no java/contatos.txt");

 
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
        }
            catch (IOException ioe)
            {
 
                System.out.println(ioe);
            }
    }
}