package id.ng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileAccess {

	public static void main(String[] args) {
		try {
			// String yang akan ditulis kedalam file
			String write = "Mengisi file dengan menggunakan Java";
			
			// Mengisi file dengan FileWriter
			FileWriter fw = new FileWriter("testfw.txt");
			fw.write(write);
			fw.flush();
			fw.close();
			// Membaca file dengan FileReader		
			FileReader fr = new FileReader("testfw.txt");
            int i;  
            while ((i = fr.read()) != -1) {  
                System.out.print((char) i);  
            }  
            fr.close();
			
			// Mengisi file dengan RandomAccessFile
            RandomAccessFile rnd = new RandomAccessFile("testrnd.txt", "rw");
            rnd.write(write.getBytes());
			// Membaca file dengan RandomAccessFIle
            System.out.println("");
            rnd.seek(13);
            while ((i = rnd.read()) != -1) {  
                System.out.print((char) i);  
            }  
            rnd.close();
            
			// Mengisi file dengan FileOutputStream
            FileOutputStream fos = new FileOutputStream("testfos.txt");
            fos.write(write.getBytes());
            fos.flush();
            fos.close();
			// Membaca file dengan FileInputStream
            System.out.println("");
            FileInputStream fis = new FileInputStream("testfos.txt");
            int length = fis.available();
            byte[] bread = new byte[length];
            fis.read(bread);
            String read = new String(bread);
            System.out.println(read);
            fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
