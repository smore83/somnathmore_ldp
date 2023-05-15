/*1. A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits
 and not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order.
 Write a java program to print first 100 vampire numbers.*/

package Java_Assignment.assignment6;

import java.util.*;


public class VampireNumbers {

    // Function to check if a given number is a vampire number
    public static boolean isVampire(int num) {
        String str = Integer.toString(num);
        int len = str.length();

        // If number of digits is odd or less than 4, it cannot be a vampire number
        if (len % 2 != 0 || len < 4) {
            return false;
        }

        // Loop to find possible factors of the number
        for (int i = (int)Math.pow(10, len/2 - 1); i < (int)Math.pow(10, len/2); i++) {
            if (num % i == 0) {
                int j = num/i;
                if ((i % 10 != 0 || j % 10 != 0) && isContainSameDigits(str, Integer.toString(i) + Integer.toString(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to check if two strings contain the same digits
    public static boolean isContainSameDigits(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public static void main(String[] args) {
        int count = 0;
        int num = 10;
        System.out.println("First 100 vampire numbers:");
        while (count < 100) {
            if (isVampire(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }
}
