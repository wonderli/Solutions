public class Ex9{
    public Ex9Interface f(){
        class Ex9InnerClass implements Ex9Interface{
            public void m1(String s){
                System.out.println(s);
            }
        }
        return  new Ex9InnerClass();
    }
    public static void main(String[] args){
        Ex9 e = new Ex9();
        e.f().m1("hello");

    }
}
