import java.util.Arrays;

public class ex1769 {
    // TIME COMPLEXITY : O (n)
    public int[] minOperations(String boxes){
        // create an array to store the result
        int[] result = new int[boxes.length()];
        // two variables one keep count of the number of 1s and other to keep
        // track of the total distance to do
        int acum =0;
        int count = 0;
        // iterate through the boxes from left to right, and calculates how many
        // balls are on the right + the distances
        for (int i=0;i<boxes.length();i++){
            result[i] += acum;
            count += boxes.charAt(i) - '0';
            acum += count;
        }
        // restart the variables to count now the balls on the left
        acum =0;
        count=0;
        // iterate through the boxes from the right to left, and ''''''''
        for (int i=boxes.length()-1;i>=0;i--){
            result[i] += acum;
            count += boxes.charAt(i) - '0';
            acum += count;
        }
        return result;
    }
    // TIME COMPLEXITY : O (n^2) BRUTE FORCE
    public int[] minOperations2(String boxes) {
        int[] result = new int[boxes.length()];
        Arrays.fill(result, 0);
        for (int i=0;i<boxes.length();i++){
            int left = i-1;
            int right = i+1;
            while (left >=0 && right <boxes.length()){
                if (boxes.charAt(left) == '1'){
                    result[i] += i-left;
                }
                if (boxes.charAt(right) == '1'){
                    result[i] += right-i;
                }
                left--;
                right++;
            }
            while (left >= 0){
                if (boxes.charAt(left) == '1'){
                    result[i] += i-left;
                }
                left--;
            }
            while (right < boxes.length()){
                if (boxes.charAt(right) == '1'){
                    result[i] += right-i;
                }
                right++;
            }
        }
        return result;
    } 
    public static void main(String[] args) {
        String s = "110";
        ex1769 myo = new ex1769();
        myo.minOperations(s);
    }
}
