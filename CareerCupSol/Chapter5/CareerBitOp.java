class CareerBitOp{
    public int setBit(int num, int i) {
        return num|(1 << i);
    }
    public boolean getBit(int num, int i){
        return ((num&(1 << i)) != 0);
    }
    public int clearBit(int num, int i){
        int mask = ~(1<<i);
        return num & mask;
    }
    public int clearMSBtoI(int num, int i) {
        int mask = ~(~0 << (i + 1));
        return num & mask;
    }
    public int CareerClearMSBtoI(int num, int i) {
        int mask = (1 << (i + 1)) - 1;
        return num & mask;
    }
    public int clearIthrough0(int num, int i) {
        int mask = (~0 << (i + 1));
        return num & mask;
    }
    public int CareerClearIthrough0(int num, int i){
        int mask = ~((1<< (i + 1)) - 1);
        return num & mask;
    }
    public int updateBit(int num, int i, int v) {
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }
    public static void main(String[] argv) {
        int num = 11;//00001011
        int ret = 0;
        CareerBitOp b = new CareerBitOp();
        for(int i = 0; i < 8; i++) {
        System.out.println(b.getBit(num, i));
        }
        ret = b.setBit(num, 2);
        System.out.println(ret);
        ret = b.clearBit(ret, 2);
        System.out.println(ret);
        ret = b.clearIthrough0(ret, 3);
        System.out.println(ret);
        num = 65535;
        num = b.clearMSBtoI(num, 3);
        System.out.println(num);
        num = 65535;
        num = b.CareerClearMSBtoI(num, 3);
        System.out.println(num);
        ret = 611;
        ret = b.clearIthrough0(ret, 3);
        System.out.println(ret);
        ret = 611;
        ret = b.CareerClearIthrough0(ret, 3);
        System.out.println(ret);
        ret = 11;
        ret = b.updateBit(ret, 2, 1);
        System.out.println(ret);
        ret = b.updateBit(ret, 2, 0);
        System.out.println(ret);

    }

}
