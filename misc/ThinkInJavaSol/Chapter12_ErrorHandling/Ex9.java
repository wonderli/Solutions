//Exercise 9: (2) Create three new types of exceptions. Write a class with a method that throws all three. In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.

public class Ex9{
    public static void f(int x) throws Ex9Exception1, Ex9Exception2, Ex9Exception3{
        if(x == 0) throw new Ex9Exception1("x = 0");
        if(x < 0) throw new Ex9Exception2("x < 0");
        if(x > 0) throw new Ex9Exception3("x > 0");
    }
    public static void main(String args[]){
        try{
            f(0);
            f(-1);
            f(1);
        }catch(Exception e){
            System.out.println("Caught!");
            e.printStackTrace();
        }
    }
}
