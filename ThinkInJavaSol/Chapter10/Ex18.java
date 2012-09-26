public class Ex18{
    public static class NestedClass{
        String b;
        public void readB(){
            System.out.println(b);
        }
    }
    public static NestedClass getNestedClass(){
        return new NestedClass();
    }
    public static void main(String[] args){
        Ex18 ex18 = new Ex18();
        NestedClass l = ex18.getNestedClass();
        l.b = new String("hello");
        l.readB();
        NestedClass li = ex18.getNestedClass();
        li.b = new String("World");
        li.readB();
    }
}

