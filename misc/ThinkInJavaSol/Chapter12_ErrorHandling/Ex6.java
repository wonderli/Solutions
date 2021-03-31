public class Ex6{
    public static void f() throws Ex6Exception1{
        throw new Ex6Exception1();
    }
    public static void g() throws Ex6Exception2 {
        throw new Ex6Exception2();
    }
    public static void main(String args[]){
        try{
            f();
        }catch(Exception e){
        }
        try{
            g();
        }catch(Exception e){
        }
    }
}
