// Define an object reference and initialize it to null. 
// Try to call a method through this reference. 
// Now wrap the code in a try-catch clause to catch the exception.
public class Ex2{
    public static Integer x = null;
    public static void main(String[] args){
        try{
            System.out.println(x.toString());
        }catch(Exception e){
            System.err.println("Catch it!");
            e.printStackTrace();
        }finally {
            System.out.println("Finally!");
        }

    }
}
