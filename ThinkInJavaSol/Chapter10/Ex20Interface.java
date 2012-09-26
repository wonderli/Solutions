public interface Ex20Interface{
    void helper();
    class Ex20InnerClass implements Ex20Interface{
        public Ex20InnerClass(){
            System.out.println("Ex20InnerClass Constructor");
        }
        public void helper(){
            System.out.println("Ex20InnerClass helper prints");
        }
    }
}
