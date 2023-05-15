package Java_Assignment.assignment7.Question4;


interface Cycle{
    void code();
    void factories();

}
class Unicycle implements Cycle{
    public void code(){
        factories();
    }
    public void factories(){
        System.out.println("Code of Unicycle is U_cyc.");
    }

};
class Bicycle implements Cycle{
    public void code(){
        factories();
    }
    public void factories(){
        System.out.println("Code of Bicycle is B_cyc.");
    }
};
class Tricycle implements Cycle{
    public void code(){
        factories();
    }
    public void factories(){
        System.out.println("Code of tricycle is T_cyc.");
    }
};
class MainClass {
    public static void main(String[] args){
        Unicycle obj = new Unicycle();
        obj.code();
        Bicycle obj1 = new Bicycle();
        obj1.code();
        Tricycle obj2 = new Tricycle();
        obj2.code();
    }
}