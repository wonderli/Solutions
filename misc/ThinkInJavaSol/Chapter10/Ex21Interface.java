public interface Ex21Interface{
    String f();
    String g();
    class Ex21InnerClass{
        public Ex21InnerClass(){
            System.out.println("Ex21InnerClass Constructor");
        }
        public static void staticFunction(Ex21Interface in){
            System.out.println(in.f() + " " + in.g());

        }
    }
}
