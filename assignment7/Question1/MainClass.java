package Java_Assignment.assignment7.Question1;

abstract class Rodent{
    Rodent(){
        System.out.println("Constructor of Rodent is running.");
    }
    public abstract void game();
    public abstract void disp();

} ;
class Mouse extends Rodent{
    Mouse(){
        System.out.println("Constructor of Mouse is running.");
    }
    public void game(){
        System.out.println("Mouse is playing cricket.");
    }
    public void disp(){
        System.out.println("I am Mouse... ");
    }
};
class Gerbil extends Rodent{
    Gerbil(){
        System.out.println("Constructor of Gerbil is running");
    }
    public void game(){
        System.out.println("Gerbil is playing Badminton");
    }
    public void disp(){
        System.out.println("I am Gerbil... ");
    }
};
class Hamster extends Rodent{
    Hamster(){
        System.out.println("Constructor of Hamster is running");
    }
    public void game(){
        System.out.println("Hamster is playing Badminton");
    }
    public void disp(){
        System.out.println("I am Hamster... ");
    }
};
public class MainClass {
    public static void main(String[] args) {
        Rodent[] rodent = new Rodent[3];
        rodent[0] = new Mouse();
        rodent[0].disp();
        rodent[0].game();
        rodent[1] = new Gerbil();
        rodent[1].disp();
        rodent[1].game();
        rodent[2] = new Hamster();
        rodent[2].disp();
        rodent[2].game();
    }
}