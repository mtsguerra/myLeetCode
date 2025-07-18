import java.util.Scanner;

public class ex0070 {

    public int totalSum;

    public int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 3) return n;
        return climbStairsRecursive(3,2,4,n);
    }
    private int climbStairsRecursive(int current, int last, int index, int n){
        if (index==n) return current+last;
        else{
            current += last;
            last = current - last;
            return climbStairsRecursive(current, last, index+1, n);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ex0070 myo = new ex0070();
        System.out.println(myo.climbStairs(n));
        in.close();
    }
}
