import java.util.*;
public class Q10{
    public static int T(Box[] box){
        int msh[] = new int[box.length];//i on top stack;
        for(int i = 0; i < box.length; i++) {
            msh[i] = box[i].h;
        }
        //System.out.println("MSH " + Arrays.toString(msh));
        for(int i = 1; i < box.length; i++) {
            for(int j = 0; j < i; j++) {
                if(check(i, j, box) && msh[i] < msh[j] + box[i].h){
                    msh[i] = msh[j] + box[i].h;
                }
            }
        }
        int max = -1;
        for ( int i = 0; i < box.length; i++ ){
            if ( max < msh[i] ){
                max = msh[i];
            }
        }
        return max;
    }
    public static boolean check(int i, int j, Box[] box){
        if((box[i].w < box[j].w) && (box[i].d < box[j].d)) return true;
        else return false;
    }
    public static void main(String args[]) {
        int size = 4;
        Box[] box = new Box[size];
        box[0] = new Box(4,6,7);
        box[1] = new Box(1,2,3);
        box[2] = new Box(4,5,6);
        box[3] = new Box(10,12,32);
        Arrays.sort(box, new BoxComparator());
        for(int i = 0; i < box.length; i++){
            System.out.println(box[i]);
        }
        System.out.println(T(box));
    }
}
