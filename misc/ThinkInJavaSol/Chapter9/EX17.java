class EX17 implements Months{
    public static void main(String[] args){
        /*Static*/
        System.out.println(Ex17.JANUARY);
        EX17 one = new EX17();
        /*Final*/
        one.JANUARY = 2;
        System.out.println(one.JANUARY);
    }

}
