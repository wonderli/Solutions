public class MyException extends Exception{
    public MyException(String s) {
        super(s);
        System.out.println("MyException(String s)");
    }
}
