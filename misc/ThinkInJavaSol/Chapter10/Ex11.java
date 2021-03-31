public class Ex11{
    private class Inner implements Ex11Interface {
        public void m1(String s) {
            System.out.println(s); 
        }
    }
        Ex11Interface func(){
            return new Inner();
        }
}
