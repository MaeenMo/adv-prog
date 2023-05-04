package proggroup.advprogmt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.*;

public class fileRead {


//    public void read() throws IOException {
//
//
//    }
    public static void main (String [] args){
        BufferedReader br;
        BufferedReader brl;
        {
            try {
                br = new BufferedReader(new FileReader("src\\main\\resources\\proggroup\\advprogmt\\Users.txt"));
                brl = new BufferedReader(new FileReader("src\\main\\resources\\proggroup\\advprogmt\\Users.txt"));
                int lines =0;
                while (brl.readLine() != null){
                    lines++;
                }
                String[] data = new String[lines];
                for (int l =0 ; l < lines;l++){
                    data [l] = br.readLine();
                    System.out.println(data[l]);
                }
                br.close();
            }
            catch (Exception e) {
                return;
            }
        }
    }
}
