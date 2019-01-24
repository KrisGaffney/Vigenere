package ie.gmit.dip;

import java.io.*;
public class FileRunner {
    public static void main(String[] args){
        String key = "THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOGS";
        File f = new File("elegy.txt");
        
        try{
            Vigenere cipher = new Vigenere(key);
            cipher.ensureCapacity((int)f.length());
            
            FileWriter fw = new FileWriter ("out.txt");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            
            String line = null;
            
            while((line = br.readLine()) != null){
                String encrypted = cipher.encrypt(line.toUpperCase());
                fw.write(encrypted + "\n");
            }
        
            br.close();
            fw.flush();
            fw.close();
            
        }catch(Exception e){
            System.out.println("Yikes! Something nasty happened");
            e.printStackTrace();
        }    

        
    }
}

