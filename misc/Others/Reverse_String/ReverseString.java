public class ReverseString{
    public static String reverse(String str){
        int i = 0;
        int j = str.length() -1;
        char strChar[] = str.toCharArray();
        while(i <= j){
            char temp = strChar[i];
            strChar[i] = strChar[j];
            strChar[j] = temp;
            i++;
            j--;
        }
        String ret = new String(strChar);
        return ret;
    }
    public static void main(String args[]){
        String str = "hello world";
        String reverseStr = reverse(str);
        System.out.println(str);
        System.out.println(reverseStr);
    }
}
