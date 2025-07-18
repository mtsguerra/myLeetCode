public class ex0069 {
    public int mySqrt(int x) {
        if (x==0) return x;
        else if (x==1||x==2||x==3) return 1;
        long right = x / 2;
        long left = 2;
        while (right >= left){
            long middle = (right + left) / 2;
            long pot = middle * middle;
            if (pot==x) return (int) middle;
            else if (pot > x){
                right = middle-1;
            }
            else left = middle+1;
        }
        return (int) right;
    }
    public static void main(String[] args) {
        ex0069 myo = new ex0069();
        System.out.println(myo.mySqrt(2147395599));
    }
}
