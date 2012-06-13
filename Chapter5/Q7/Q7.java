import java.util.*;
class Q7{
    public static int getColumn(int num, int column){
        int i = num >> (31 - column);
        if((i & 1) == 1)
            return 1;
        else return 0;
    }
    public static int findMissing(ArrayList<Integer> list, int column){
        if(column < 0)
            return 0;
        ArrayList<Integer> one = new ArrayList<Integer>(list.size()/2);
        ArrayList<Integer> zero = new ArrayList<Integer>(list.size()/2);
        for(int t : list){
            if(Q7.getColumn(t, column) == 1)
                one.add(t);
            else if(Q7.getColumn(t, column) == 0)
                zero.add(t);
        }
        if(one.size() < zero.size()){
            int v = findMissing(one, column - 1);
            return (v << 1) | 1;
        }
        else {
            int v = findMissing(zero, column - 1);
            return (v << 1) | 0;
        }

    }
    public static void main(String[] args){
        int size = 10;
        ArrayList<Integer> array = new ArrayList<Integer>(size);
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(4);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        int v = Q7.findMissing(array, 31);
        System.out.println(v);

    }
}
