public class Ex18 {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    void normal_dispose() throws NormalException {
        throw new NormalException();
    }
    public static void main(String args[]) {
        try{
            Ex18 lm = new Ex18();
            try{
                try {
                    lm.f();
                    lm.dispose();
                } finally {
                    lm.normal_dispose();
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
