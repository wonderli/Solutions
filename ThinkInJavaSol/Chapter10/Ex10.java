public class Ex10{
    public Ex10Interface f(){
        class Ex10InnerClass implements Ex10Interface{
            public void m1(String s){
                System.out.println(s);
            }
        }
            return  new Ex10InnerClass();
    }
    public static void main(String[] args){
        Ex10 e = new Ex10();
        e.f().m1("This is Chapter10 Ex10");

    }
}
