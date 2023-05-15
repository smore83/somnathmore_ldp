package Java_Assignment.Assignment5.somnath.assignment.singleton;

public class B {
    String str;
    public B(String otherStr){
        str=otherStr;
    }

    public void B_method(String s) {
        //static methods can only access static variables;
        str=s;
        B sc = new B(s);
        System.out.println(sc);
//        return sc;
    }
    public void print() {
        System.out.println(str);
    }

    public static void main(String[] args)
    {
        String str = "ABCD";
        B obj = new B(str);
        obj.B_method(str);
        obj.print();
    }
}
