/*
Error Handling

Create three new types of exceptions. Write a class with a method that throws all three.
In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.
Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.

 */
package Java_Assignment.assignment8;
class invalidcvv extends Exception{
    public invalidcvv(String str){
        super(str);
    }
};

class invalidATM extends Exception{
    public invalidATM(String str){
        super(str);
    }
};

class invalidOTP extends Exception{
    public invalidOTP(String str){
        super(str);
    }
};


class verify extends Exception{

    public void CheckDetails(String cvv,String atm,String otp)throws invalidcvv,invalidATM,invalidOTP {

        if(atm.length()!=16){
            throw new invalidATM("Wrong ATM Number Inserted");
        }
        if(cvv.length()!=3)
        {
            throw new invalidcvv("Wrong cvv Inserted");
        }
        if(otp.length()!=4){
            throw new invalidOTP("Wrong OTP Number Inserted");
        }
    }
};

class MainClass {

    public static void main(String[] args) {

        try {
            verify obj = new verify();
            obj.CheckDetails("440","10054978045540456","45650");
        }
        catch(invalidcvv | invalidATM | invalidOTP e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Exception not caught.");
        }

    }

}