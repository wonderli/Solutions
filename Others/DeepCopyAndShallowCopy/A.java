public class A implements Cloneable{
    public B sub;
    public String name;
    public A(){
       this.sub = new B();
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public A deepCopy(A a){
        A ret = new A();
        ret.sub = new B();
        ret.sub.name = new String(a.sub.name);
        ret.name = new String(a.name);
        return ret;
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
        System.out.println();
        System.out.println("Now DeepCopy");
        A obj3 = new A();
        obj3.name = "A3";
        obj3.sub.name = "A3-sub-name";
        System.out.println(obj3.name);
        System.out.println(obj3.sub.name);
        A obj4 = obj3.deepCopy(obj3);
        System.out.println(obj4.name);
        System.out.println(obj4.sub.name);
        obj3.sub.name = "Changed again";
        System.out.println(obj3.sub.name);
        System.out.println(obj4.sub.name);
    }

}
class B {
    public String name;
}
