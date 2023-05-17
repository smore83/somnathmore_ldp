/*
*Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
* Write time and space complexity of your solution as comments in the source file.
* */
package Java_Assignment.assignment2;

import java.util.Scanner;
import java.lang.String;
public class Assignment2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str1=input.nextLine();
        //logic time
        //make all small
        str1.toLowerCase();
        int count=0;
        for (int i=0;i<str1.length();i++){
            //logic time
            if(str1.charAt(i)>='a' && str1.charAt(i)<='z'){
                count++;

            }
        }
        System.out.print("String: " + str1);
        if(count==str1.length()){
            System.out.print("\nThe above string is valid string.\n ");
        }else{
            System.out.print("\nThe above string is not a valid a string.\n ");
        }

    }
}
