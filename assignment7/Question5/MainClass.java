package Java_Assignment.assignment7.Question5;
class Outer{
    Outer(){
        System.out.println("outer class constructor is running.");
    }

    //it should be executed na??
    class Inner{
        Inner( int a,int b){
            System.out.println("The value of a is " +a);
            System.out.println("Ainner class constructor is running.");
        }
    }
};

class Bout extends Outer{
    Bout(){
        System.out.println("Bouter class constructor is running.");
    }
    class Binner{
        Binner(int a){
            System.out.println("The value of a in Binner is " +a);
            System.out.println("Binner class constructor is running.");
        }
    }
};

public class MainClass {
    public static void main(String[] args) {
        Bout.Binner in = new Bout().new Binner(4);
    }
}
