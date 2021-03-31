import java.util.*;
public class Box implements Comparator{
    public int w;
    public int h;
    public int d;
    public Box(){
        w = 0;
        h = 0;
        d = 0;
    }
    public Box(int h, int w, int d){
        this.h = h;
        this.w = w;
        this.d = d;
    }
    public int getW(){
        return this.w;
    }
    public int getH(){
        return this.h;
    }
    public int getD(){
        return this.d;
    }

    public int compare(Object a, Object b){
        int val1 = ((Box)a).getH();
        int val2 = ((Box)b).getH();
        if(val1 < val2)
            return -1;
        else if (val1 > val2)
            return 1;
        else return 0;
    }

    public String toString(){
        return  h + " x " + w + " x " + d;
    }
   
}
