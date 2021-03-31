public class Ex20 implements Ex20Interface{
    public void helper(){
        System.out.println("IN Ex20 helper");
    }
    public static void main(String[] args){
        Ex20 e = new Ex20();
        e.helper();
        Ex20InnerClass ei = new Ex20InnerClass();
        ei.helper();
    }
}
