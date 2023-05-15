/*
4. Complete the previous exercise by creating objects to attach to the array of references.
*/
package Java_Assignment.assignment6;

class MyClass3 {
    MyClass3(String str) {
        System.out.println("Argument passed to constructor: " + str);
    }
}

public class Question4 {
    public static void main(String[] args) {
        MyClass3[] arr = new MyClass3[3];
        arr[0] = new MyClass3("Hello");
        arr[1] = new MyClass3("World");
        arr[2] = new MyClass3("Java");
    }
}
