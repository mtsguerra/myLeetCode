import java.util.*;

class ex2264 {
    public String largestGoodInteger(String num) {
        if (num == null || num.length() < 3) {
            return "";
        }
        int maxValue = Integer.MIN_VALUE;
        String maxString = "";
        char lastOne = num.charAt(0);
        int seq = 1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == lastOne) {
                seq++;
                if (seq == 3) {
                    int currentValue = lastOne*100 + lastOne*10 + lastOne;
                    if (currentValue > maxValue) {
                        maxValue = currentValue;
                        maxString = String.valueOf(lastOne).repeat(3);
                    }
                }
            }
            else {
                lastOne = num.charAt(i);
                seq = 1;
            }
        }
        /*for (int i = 0; i < num.length()-2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                int currentValue = num.charAt(i) - '0';
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    maxString = num.substring(i, i + 3);
                }
            }
        }*/
        return maxString;
    }

    public static void main(String[] args) {
        ex2264 solution = new ex2264();
        String num = "6777133339";
        String result = solution.largestGoodInteger(num);
        System.out.println(result); // Output: "777"
    }
}