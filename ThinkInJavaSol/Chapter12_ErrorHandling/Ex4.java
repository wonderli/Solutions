public class Ex4{
    public static void f() throws Ex4Exception{
        System.out.println("In f()");
        throw new Ex4Exception("From f()");
    }
    public static void main(String args[]){
        try{
            f();
        }catch(Ex4Exception e){
            System.err.println("Caught Ex4Exception");
            e.printStackTrace();
            e.show();
        }
    }
}
