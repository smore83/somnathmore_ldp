// First interface
package Java_Assignment.assignment7.Question3;
interface Interface1 {
    void method1();
    void method2();
}

// Second interface
interface Interface2 {
    void method3();
    void method4();
}

// Third interface
interface Interface3 {
    void method5();
    void method6();
}

// Combined interface
interface CombinedInterface extends Interface1, Interface2, Interface3 {
    void method7();
}

// Concrete class
class ConcreteClass {
    void method8() {
        System.out.println("Method8 from ConcreteClass");
    }
}

// Class implementing the CombinedInterface and inheriting from ConcreteClass
class MyClass extends ConcreteClass implements CombinedInterface {
    @Override
    public void method1() {
        System.out.println("Method1");
    }

    @Override
    public void method2() {
        System.out.println("Method2");
    }

    @Override
    public void method3() {
        System.out.println("Method3");
    }

    @Override
    public void method4() {
        System.out.println("Method4");
    }

    @Override
    public void method5() {
        System.out.println("Method5");
    }

    @Override
    public void method6() {
        System.out.println("Method6");
    }

    @Override
    public void method7() {
        System.out.println("Method7");
    }


    // Four methods taking one of the four interfaces as an argument
    static void methodWithInterface1(Interface1 obj) {
        obj.method1();
        obj.method2();
    }

    static void methodWithInterface2(Interface2 obj) {
        obj.method3();
        obj.method4();
    }

    static void methodWithInterface3(Interface3 obj) {
        obj.method5();
        obj.method6();
    }

    static void methodWithCombinedInterface(CombinedInterface obj) {
        obj.method1();
        obj.method2();
        obj.method3();
        obj.method4();
        obj.method5();
        obj.method6();
        obj.method7();
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();

        methodWithInterface1(obj);
        methodWithInterface2(obj);
        methodWithInterface3(obj);
        methodWithCombinedInterface(obj);
    }
}