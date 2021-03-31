//Exercise 4: (2) Create your own exception class using the extends keyword.
//Write a constructor for this class that takes a String argument and stores it inside the object with a String reference. 
//Write a method that displays the stored String. Create a try-catch clause to exercise your new exception.
public class Ex4Exception extends Exception{
    public String s;
    public Ex4Exception(String s){
        super(s);
        System.out.println("Ex4Exception4()");
        this.s = s;
    }
    public void show(){
        System.out.println("Msg: " + s);

    }
}
