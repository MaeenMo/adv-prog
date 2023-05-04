package proggroup.advprogmt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Book {
    String title;
    public Book(String title){
        this.title=title;
    }
    public void addBook(){
        BufferedWriter bw;
        {
            try {
                bw = new BufferedWriter(new FileWriter("src/main/resources/proggroup/advprogmt/Books.txt",true));
                bw.write(title);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void removeBook(){

    }
}
