import java.util.ArrayList;
import java.util.List;

public class ex2698 {
    public int punishmentNumber(int n) {
        int finalSum = 0;
        for (int i =0;i<=n;i++){
            // only these numbers are valid to be a possible solution
            if ((i%9==0||i%9==1) && (isValid(Integer.toString(i*i), i))) finalSum+=i*i;
        }
        return finalSum;
    }
    private boolean isValid(String num, int ref){
        // if the number is over, return if the sum is equal to the square root of num
        if (num.isEmpty()) return ref ==0;
        for (int i =0; i < num.length();i++){
            // creates a substring 
            String current = num.substring(0, i+1);
            int v = Integer.parseInt(current);
            // if the substring is greater than ref i need to find breaks the for, after this i all will be greater
            if (v > ref) break;
            // recursive with the remaining of the string without the substring and the ref minus the v found as possible
            if (isValid(num.substring(i+1), ref-v)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ex2698 myo= new ex2698();
        myo.punishmentNumber(10);
    }
}