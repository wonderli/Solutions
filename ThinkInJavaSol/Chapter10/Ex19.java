public class Ex19{
    public Ex19(){
        System.out.println("ex19");
    }
    public static class InnerClassOne{
        public InnerClassOne(){
            System.out.println("InnerClassOne");
        }
        public static class InnerClassTwo{
            public InnerClassTwo(){
                System.out.println("InnerClassTwo");
            }
        }
        public static InnerClassTwo made(){
            return new InnerClassTwo();
        }

    }
    public static InnerClassOne made(){
        return new InnerClassOne();
    }

    public static void main(String[] args){
        Ex19 e = new Ex19();
        InnerClassOne ix1 = e.made();
        InnerClassOne.InnerClassTwo ix2 = ix1.made();
    }
}
/*
 *
 * Ex19$InnerClassOne$InnerClassTwo.class
 * Ex19$InnerClassOne.class
 * Ex19.class
 *
 *
 */
