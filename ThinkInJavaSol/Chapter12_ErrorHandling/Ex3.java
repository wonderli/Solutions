//Write code to generate and catch an ArraylndexOutOfBoundsException.
public class Ex3{
    public static void main(String[] args){
        try{
            int size = 10;
            int array[] = new int[size];
            for(int i = 0; i < (size + 1); i ++){
                array[i] = i;
            }
        }catch(Exception e) {
            System.err.println("Catch it!");
            e.printStackTrace();
        }

    }
}
