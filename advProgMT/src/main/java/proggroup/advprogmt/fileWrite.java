package proggroup.advprogmt;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

public class fileWrite {
        BufferedWriter bw;
    {
        try {
            bw = new BufferedWriter(new FileWriter("src\\main\\resources\\proggroup\\advprogmt\\Users.txt",true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void write(TextField data1, PasswordField data2) throws IOException{
            String ID = data1.getText().toString();
            String Pass = data2.getText().toString();

            bw.write(ID +","+ Pass);
            bw.newLine();
            bw.flush();


//            pw.println(ID + "," + Pass );

//            pw.close();
        }
//        pw.println("Line 2");
//        pw.println("Line 3");
//        pw.println("Line 4");


}
