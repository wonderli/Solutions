import java.util.*;
public class Main{
    public static double TDtoH(double T, double D){
        double e = 6.11 * Math.pow(2.718281828,(5417.7530 * ((1/273.16) - (1/(D+273.16)))));
        double h = 0.5555 * (e - 10.0);
        return T + h;
    }
    public static double THtoD(double T, double H){
        double h = H - T;  
        double e = h / 0.5555 + 10.0;  
        return 1/(Math.log(e/6.11)/((-1)*5417.7530) + 1/273.16) - 273.16;  
    }
    public static double DHtoT(double D, double H){
        double Exp = 2.718281828;
        double e = 6.11 * Math.pow(Exp, 5417.7530 * ((1/273.16) - (1/(D+273.16))));  
        double h = 0.5555 * (e - 10.0);  
        return H - h;
    }
    public static void main(String args[]){
        Main sol = new Main();
        Scanner sc = new Scanner(System.in);
        double T = 0;
        double D = 0;
        double H = 0;
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()){
            String input = sc.nextLine();
            if(input.equals("E"))
                break;
            StringTokenizer st = new StringTokenizer(input);
            String first = st.nextToken();
            if(first.equals("T")){
                String t = st.nextToken();
                T = Double.valueOf(t);
                String second = st.nextToken();
                if(second.equals("D")){
                    String d = st.nextToken();
                    D = Double.valueOf(d);
                    H = TDtoH(T, D);
                    String r = String.format("T %.1f D %.1f H %.1f\n", T, D, H);
                    sb.append(r);
                    continue;
                }else if(second.equals("H")){
                    String h = st.nextToken();
                    H = Double.valueOf(h);
                    D = THtoD(T, H);
                    String r = String.format("T %.1f D %.1f H %.1f\n", T, D, H);
                    sb.append(r);
                    continue;
                }
            }else if(first.equals("D")){
                String d = st.nextToken();
                D = Double.valueOf(d);
                String second = st.nextToken();
                if(second.equals("T")){
                    String t = st.nextToken();
                    T = Double.valueOf(t);
                    H = TDtoH(T, D);
                    String r = String.format("T %.1f D %.1f H %.1f\n", T, D, H);
                    sb.append(r);
                    continue;
                }else if(second.equals("H")){
                    String h = st.nextToken();
                    H = Double.valueOf(h);
                    T = DHtoT(D, H);
                    String r = String.format("T %.1f D %.1f H %.1f\n", T, D, H);
                    sb.append(r);
                    continue;
                }
            }else if(first.equals("H")){
                String h = st.nextToken();
                H = Double.valueOf(h);
                String second = st.nextToken();
                if(second.equals("T")){
                    String t = st.nextToken();
                    T = Double.valueOf(t);
                    D = THtoD(T, H);
                    String r = String.format("T %.1f D %.1f H %.1f\n", T, D, H);
                    sb.append(r);
                    continue;
                }else if(second.equals("D")){
                    String d = st.nextToken();
                    D = Double.valueOf(d);
                    T = DHtoT(D, H);
                    String r = String.format("T %.1f D %.1f H %.1f\n", T, D, H);
                    sb.append(r);
                    continue;
                }
            }

        }
        System.out.println(sb.toString());
    }
}
