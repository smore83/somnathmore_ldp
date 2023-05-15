/*
I/O

Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument
and counts the occurrence of all the different characters. Save the results in a text file.
 */

package Java_Assignment.assignment11;

import java.util.HashMap;
        import java.io.*;

class FileReadWrite {
    HashMap<Character, Integer> Map=new HashMap<Character, Integer>();

    public void charCount(){
        try {
            FileReader fread=new FileReader("myFile.txt");
            int index;
            while((index=fread.read())!=-1) {
                if(!Character.isWhitespace((char)index)) {
                    if(Map.containsKey((char)index)) {
                        Map.put((char)index, Map.get((char)index)+1);
                    }
                    else {
                        Map.put((char)index, 1);
                    }
                }
            }
            writeData();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeData() {
        try {
            File file =new File("count.txt");
            FileWriter fwrite=new FileWriter(file);
            fwrite.write(Map.toString());
            fwrite.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
};


public class FileWriteClass {

    public static void main(String[] args) {
        FileReadWrite frw = new FileReadWrite();
        frw.charCount();

    }

}