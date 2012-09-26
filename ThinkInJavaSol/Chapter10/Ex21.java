public class Ex21 implements Ex21Interface{
    public String f(){
        return "In f() ";
    }
    public String g(){
        return "In g() ";
    }

    public static void main(String[] args){
        Ex21 e = new Ex21();
        Ex21Interface.Ex21InnerClass.staticFunction(e);
        
    }
}
