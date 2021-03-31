import java.util.*;
public class BoxComparator implements Comparator{
    public int compare(Object a, Object b){
        int val1 = ((Box)a).getH();
        int val2 = ((Box)b).getH();
        if(val1 < val2)
            return 1;
        else if (val1 > val2)
            return -1;
        else return 0;
    }
}
