package proggroup.advprogmt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Search{
    BufferedReader brs;
    BufferedReader brl;
    String temp = "" ;
    String result = null;
    static String [] booksArr = null;
    static String [] usersArr = null;
    Alert alert = new Alert();
    int lines;
    int i = 0;
    public void searchfor(String searchbar, String type){
            if (searchbar.isEmpty()){
                alert.display("Error","Nothing to search!", "red");
            } else if (type.equals("Users")){
                try {
                    brs = new BufferedReader(new FileReader("src/main/java/proggroup/advprogmt/Database/Users.txt"));
                    brl = new BufferedReader(new FileReader("src/main/java/proggroup/advprogmt/Database/Users.txt"));
                    lines = 0;
                    while (brl.readLine()!= null){
                        lines++;
                    }
                    usersArr = new String[lines-1];
                    temp = brs.readLine();
                    System.out.println(temp + " fisrt line");
                    for (int i = 0; i < lines-1; i++) {
                        temp = brs.readLine();
                        System.out.println(temp + "line number"+(i+2));
                        if (temp.split(",")[0].contains(searchbar.toLowerCase()) || temp.split(",")[0].contains(searchbar.toUpperCase()) || searchbar.equals(temp.split(",")[0]) || searchbar.equals(temp.split(",")[0].toLowerCase()) || temp.split(",")[0].toLowerCase().contains(searchbar.toLowerCase())){
//                            System.out.println(temp);
                            usersArr[i]=temp.split(",")[0];
                            System.out.println(usersArr[i]);
//                            break;
                        }
                    }
//                        if (searchbar.equals(temp.split(",")[0])){
//                           result = temp.split(",")[0];
//                           break;
//                        }else {
//                            result = "User " + "\"" + searchbar + "\"" + " Was Not Found!";
//                        }
                    System.out.println(Arrays.toString(usersArr));
                    for (String e: usersArr) {
                        if (e != null) {
                            i = 0;
                            break;
                        }
                        else i = -1;
                    }
                    if(i == -1){
                        System.out.println("User " + "\"" + searchbar + "\"" + " Was Not Found!"+"from search");
//                        System.out.println(result);
                        result = "User " + "\"" + searchbar + "\"" + " Was Not Found!";
                    }
                    brs.close();
                    brl.close();
                }catch (IOException e){
                }
            }else if (type.equals("Books")) {
                try {
                    brs = new BufferedReader(new FileReader("src/main/java/proggroup/advprogmt/Database/Books.txt"));
                    brl = new BufferedReader(new FileReader("src/main/java/proggroup/advprogmt/Database/Books.txt"));
                    lines = 0;
                    while (brl.readLine()!= null){
                        lines++;
                    }
                    booksArr = new String[lines];
                    for (int i =0;i < lines ;i++)
                    {
                        temp = brs.readLine();
                        System.out.println(temp);
                        if (temp.contains(searchbar.toLowerCase()) || temp.contains(searchbar.toUpperCase()) || searchbar.equals(temp) || searchbar.equals(temp.toLowerCase()) || temp.toLowerCase().contains(searchbar.toLowerCase())){
                            System.out.println(temp);
                            booksArr[i]=temp;
                            System.out.println(booksArr[i]);
//                            break;
                        }
                    }System.out.println(Arrays.toString(booksArr));
                    for (String e: booksArr) {
                        if (e != null) {
                            i = 0;
                            break;
                        }
                        else i = -1;
                    }
                    if(i == -1){
                        System.out.println("Book " + "\"" + searchbar + "\"" + " Was Not Found!"+"from search");
//                        System.out.println(result);
                        result = "Book " + "\"" + searchbar + "\"" + " Was Not Found!";
                    }
                    brs.close();
                    brl.close();
                }catch (IOException e){
                }
            }
    }

}
