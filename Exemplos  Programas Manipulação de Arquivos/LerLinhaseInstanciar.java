import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LerLinhaseInstanciar {

    public void main(String data[]) {

        try {
            String nameNumberString;

            // Using file pointer creating the file.
            File file = new File(
                    "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");

            // Opening file in reading and write mode.

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            RandomAccessFile raf2 = new RandomAccessFile(file, "rw");

            int count = 0;
            int count2 = 0;
            String usuario, senha;
            boolean admin;
            String array[] = new String[3];

            
            while (raf2.getFilePointer() < raf2.length()) {
                count += 1;
                nameNumberString = raf2.readLine();
            }
            
            System.out.println(count);
            Usuario[] usuarios = new Usuario[count];

            
            // Usuario U1 = new Usuario("nome124","senha",true);
            // Usuario U2  = new Usuario("nome124","senha",true);
            // usuarios[0] = U1;
            // usuarios[1] = U2;

    

            while (raf.getFilePointer() < raf.length()) {
                // count += 1;

                // reading line from the file.
                nameNumberString = raf.readLine();
                array = nameNumberString.split(",");
                // usuarios[count2] = new Usuario(array[0], array[1], Boolean.parseBoolean(array[2]));
                System.out.println(nameNumberString);
                count2 += 1;
            }

            System.out.println(usuarios[1]);

        } catch (IOException ioe) {

            System.out.println(ioe);
        }
    }
}