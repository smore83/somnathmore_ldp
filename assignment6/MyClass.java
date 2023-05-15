/*
2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
* */
package Java_Assignment.assignment6;

public class MyClass {
    int var1, var2;

    // First constructor with one parameter
    MyClass(int v1) {
        this(v1, 0);  // calling second constructor with default value of var2
    }

    // Second constructor with two parameters
    MyClass(int v1, int v2) {
        var1 = v1;
        var2 = v2;
    }
}
