//Create a class with a main( ) that throws an object of class Exception inside a try block. 
//Give the constructor for Exception a String argument.
//Catch the exception inside a catch clause and print the String argument. 
//Add a finally clause and print a message to prove you were there.
public class Ex1{
    public static void f() throws MyException{
        System.out.println("Throw exception from f()");
        throw new MyException("From f()");
    }
    public static void main(String[] args){
        try{
            f();
        }catch(MyException e){
            System.err.println("Catch Exception");
            e.printStackTrace();
        }finally {
            System.out.println("Finally");
        }
    }
}
