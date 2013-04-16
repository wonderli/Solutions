
public class Main {

    public static void main (String[] args) {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lineArray = line.split("\s");
            if (lineArray.length > 0) {
                //Process line of input Here
            }
        }
    }
}

