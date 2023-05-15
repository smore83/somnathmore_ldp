/*
String and Type Information

Using the documentation for java.util.regex.Pattern as a resource,
write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
 */
package Java_Assignment.assignment9;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Assignment9
{
    public void Check(String s1) {
        String regexPattern="[A-Z].*[.]";
        boolean flag=Pattern.matches(regexPattern, s1);//matching pattern using regex.matched
        if(flag){
            System.out.println("Yes the given pattern matches the regex: "+flag);
        }
        else{
            System.out.println("No the given pattern does not matches the regex: "+flag);
        }
    }

    public static void main(String[] args)
    {
        String s1;
        Scanner in = new Scanner(System.in);
        System.out.println(" Enter the string: ");
        s1 = in.nextLine();
        Assignment9 obj = new Assignment9();
        obj.Check(s1);
    }
}