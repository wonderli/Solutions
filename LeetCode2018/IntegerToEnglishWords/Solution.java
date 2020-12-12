import java.util.*;
class Solution {
    Map<Integer, String> tens = new HashMap<>();

    {
        tens.put(1, "One");
        tens.put(2, "Two");
        tens.put(3, "Three");
        tens.put(4, "Four");
        tens.put(5, "Five");
        tens.put(6, "Six");
        tens.put(7, "Seven");
        tens.put(8, "Eight");
        tens.put(9, "Nine");
        tens.put(10, "Ten");
    }

    Map<Integer, String> undertwenties = new HashMap<>();

    {
        undertwenties.put(11, "Eleven");
        undertwenties.put(12, "Twelve");
        undertwenties.put(13, "Thirteen");
        undertwenties.put(14, "Fourteen");
        undertwenties.put(15, "Fifteen");
        undertwenties.put(16, "Sixteen");
        undertwenties.put(17, "Seventeen");
        undertwenties.put(18, "Eighteen");
        undertwenties.put(19, "Nineteen");
    }

    Map<Integer, String> above20 = new HashMap<>();

    {
        above20.put(2, "Twenty");
        above20.put(3, "Thirty");
        above20.put(4, "Forty");
        above20.put(5, "Fifty");
        above20.put(6, "Sixty");
        above20.put(7, "Seventy");
        above20.put(8, "Eighty");
        above20.put(9, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        int hundred = 100;
        StringBuilder sb = new StringBuilder();
        if (num / billion != 0) {
            sb.append(helper(num / billion));
            sb.append(" Billion ");
            num = num % billion;
        }
        if (num / million != 0) {
            sb.append(helper(num / million));
            sb.append(" Million ");
            num = num % million;
        }
        if (num / thousand != 0) {
            sb.append(helper(num / thousand));
            sb.append(" Thousand ");
            num = num % thousand;
        }
        if (num / hundred != 0) {
            sb.append(helper(num / hundred));
            sb.append(" Hundred ");
            num = num % 100;
        }

        if (0 < num && num <= 10) {
            sb.append(tens.get(num));
        }

        if (10 < num && num < 20) {
            sb.append(undertwenties.get(num));
        }

        if (20 <= num && num < 100) {
            sb.append(above20.get(num / 10));
            sb.append(" ");
            sb.append(helper(num % 10));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}