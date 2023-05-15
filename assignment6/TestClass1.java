/*
*
3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.

* */

package Java_Assignment.assignment6;

class MyClass1 {
    MyClass1(String str) {
        System.out.println("Argument passed to constructor: " + str);
    }
}

public class TestClass1 {
    public static void main(String[] args) {
        MyClass1[] arr = new MyClass1[3];
    }
}
