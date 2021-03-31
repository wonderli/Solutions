//Reference Link: http://www.geeksforgeeks.org/archives/13178
public class EditDistance{
    public static int minimum(int a, int b, int c){
        int min = c;
        if(a < b){
            if(a < c)
                min = a;
        }
        else{
            if(b < c)
                min = b;
        }
        return min;
    }
    public static int edit_distance(String a, String b, int i, int j){
        int ret = 0;
        if(i == 0 && j == 0)
            return 0;
        if(i == 0)
            return j;
        if(j == 0)
            return i;
        int delete_ch = edit_distance(a, b, i - 1, j) + 1;
        int insert_ch = edit_distance(a, b, i, j - 1) + 1;
        int substitude_ch = 0;
        if(a.charAt(i - 1) != b.charAt(j - 1)){
            substitude_ch = edit_distance(a, b, i - 1, j - 1) + 1;
        }else{
            substitude_ch = edit_distance(a, b, i - 1, j - 1) + 0;
        }
        ret = minimum(delete_ch, insert_ch, substitude_ch);
        return ret;

    }
    public static void main(String args[]){
        String a = new String("hello");
        String b = new String("hellooooo");
        EditDistance o = new EditDistance();
        int ret = o.edit_distance(a, b, a.length(), b.length());
        System.out.println(ret);

    }
}
