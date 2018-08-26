//------------------------------Chuong trinh duoc xay dung nhu sau : -------------------------------------
// An so 1 : Chuong trinh se quet 1 thu muc chi dinh
//AN so 2 : Chuong trinh se tim kiem noi dung(o day la tu khoa "123" trong tat ca cac file cua thu muc da chi dinh
//  VD o day la thu muc F:/DEMO - Neu noi  dung file nao co tu khoa 123 thi se hien ra ten file do
package baitapsearchstring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author admin
 */
public class ScanTimKiem {
    public static final String DEMO_FOLDER = "F:\\DEMO";
private final ArrayList<String> listFile;
private final ArrayList<String> listChecked;

 public ScanTimKiem() {
listFile = new ArrayList<>();
listChecked = new ArrayList<>();
}

 private void listFileTxt() {
File folder = new File(DEMO_FOLDER);
File[] allFile = folder.listFiles();
for (File x : allFile) {
if (x.toString().endsWith(".txt")) {
listFile.add(x.toString());
}
}
}

 private void filterFile(String byString) {
try {
for (String x : listFile) {
BufferedReader br = new BufferedReader(new FileReader(x));
String content;
while ((content = br.readLine()) != null) {
if (content.contains(byString)) {
listChecked.add(x);
}
}
br.close();
}
} catch (FileNotFoundException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}
}

 private void displayAllTxt() {
for (String x : listChecked) {
System.out.println(x);
}
}
     public static void printLine() 
    { 
        System.out.println(); 
         
        for(int i = 1; i <= 100; i++) 
        { 
            if(i == 1 || i == 100) 
            { 
                System.out.print("+"); 
            } 
            else 
            { 
                System.out.print("-"); 
            } 
        } 
    } 

    public static void main(String[] args) throws IOException {  
         printLine(); 
        System.out.printf("\n| %-90s %7s", "Menu: ", "|"); 
        System.out.printf("\n| %-90s %7s", "1. Quet thu muc.", "|"); 
        System.out.printf("\n| %-90s %7s", "2. Tim kiem String trong file thu muc", "|"); 
        System.out.printf("\n| %-90s %7s", "3. Ket thuc", "|"); 
        printLine(); 
        int chon=0;
         
       
        while(chon!=3){
            System.out.print("\nBạn nhập vào chức năng: ");
             chon = new Scanner(System.in).nextInt();
        switch(chon) 
                { 
                    case 1: 
                    { 
                      System.out.println("Nhap duong dan folder ban muon scan ( Vi du : F:/DEMO) : "); // Vi DU : ( C:/ , F:/)
      Scanner s1 = new Scanner(System.in);
      String folderPath = s1.next();
      File folder = new File(folderPath);
      
      if (folder.isDirectory()) {
         File[] listOfFiles = folder.listFiles();
         if (listOfFiles.length < 1)System.out.println(
            "Khong co File nao trong folder");
         else System.out.println("Danh sach cac file va Folder");
         for (File file : listOfFiles) {
            if(!file.isDirectory())System.out.println(
               file.getCanonicalPath().toString());
         } 
       
      }
      else System.out .println("Duong dan sai :" + folderPath);
        
                break;
                    } 
                    case 2: // Neu file nao co noi dung ben trong la "123" thi in ra ten file
                    { 
                        ScanTimKiem main = new ScanTimKiem();
                        main.listFileTxt();
                        main.filterFile("123"); //tim ky tu string co noi dung 123 trong   cac filefile
                        main.displayAllTxt();

                        break; 
                    } 
        
                    case 3 :
                    {
                        return;
                    }
    

        }   
    }
    }
}