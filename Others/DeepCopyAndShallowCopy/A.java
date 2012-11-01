public class A implements Cloneable{
    public B sub;
    public String name;
    public A(){
       this.sub = new B();
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static void main(String args[]){
        A obj1 = new A();
        obj1.name = "A1";
        obj1.sub.name = "A1-sub-name";
        System.out.println(obj1.name);
        System.out.println(obj1.sub.name);
        try{
            A obj2 = (A)obj1.clone();
            System.out.println(obj2.name);
            System.out.println(obj2.sub.name);
            obj1.sub.name = "Changed";
            System.out.println(obj2.sub.name);
        }catch(CloneNotSupportedException e){
            System.err.println("Error");
        }
    }

}
class B {
    public String name;
}
