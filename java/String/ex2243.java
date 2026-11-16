import java.io.*;

class ex2243 {
    public String digitSum(String s, int k) {
        StringBuilder temp = new StringBuilder();
        while (s.length() > k){
            int current = 0;
            int p = s.length()%k==0?s.length() / k:s.length()/k+1;
            for (int i = 0; i < p; i++){
                int currentSum = 0;
                for (int z = 0; z<k && current < s.length(); current++, z++){
                    currentSum += s.charAt(current) - '0';
                }
                temp.append(currentSum);
            }
            s = temp.toString();
            temp = new StringBuilder();
        }
        return s;
    }

    public static void main(String[] args) {
        ex2243 ex = new ex2243();
        System.out.println(ex.digitSum("01234567890", 2));
    }
}