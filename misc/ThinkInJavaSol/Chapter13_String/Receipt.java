//Ex4
import java.util.*;
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int W1 = 15;
    private int W2 = 5;
    private int W3 = 10;
    private String s1 = "%-" + W1 + "s %" + W2 + "s %" + W3 + "s\n";
    private String s2 = "%-" + W1 + ".15s %" + W2 + "d %" + W3 + ".2f\n";
    private String s3 = "%-" + W1 + "s %" + W2 + "s %" + W3 + ".2f\n";


    public void printTitle() {
        //f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format(s1, "Item", "Qty", "Price");
        //f.format("%-15s %5s %10s\n", "----", "---", "-----");
        f.format(s1, "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        //f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        f.format(s2, name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format(s3, "Tax", "", total*0.06);
        f.format(s1, "", "", "-----");
        f.format(s3,"Total", "",total * 1.06);
        //f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        //f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        //f.format("%-15s %5s %10s\n", "", "", "-----");
        //f.format("%-15s %5s %10.2f\n", "Total", "",total * 1.06);
    }
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
} 
