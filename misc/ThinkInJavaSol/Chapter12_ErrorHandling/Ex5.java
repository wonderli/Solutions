//Exercise 5: (3) Create your own resumption-like behavior using a while loop that repeats until an exception is no longer thrown.
public class Ex5{
    public static int x = 10;
    public static int[] array = new int[5];
    public static void main(String args[]){
        while(true){
            try{
                array[x] = x;
                System.out.println("Inside try " + array[x]);
                break;
            }catch(ArrayIndexOutOfBoundsException e){
                System.err.println("Caught ArrayIndexOutOfBoundsException");
                e.printStackTrace();
                x--;
            }finally{
                System.out.println("Finish?");
            }
        }
        System.out.println("Yes.");
    }
}
