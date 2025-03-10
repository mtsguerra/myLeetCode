public class ex0007 {

    //-----------------------------------------//
    // int this one i find the "size" of the initial int so i can iterate thru it until it ends, so i use the size that i found to get the power of
    // 10 that i will be using initially and while i iterate thru i will be getting x % 10 and multiplying with 10 to the power that i found and adding
    // to a new int that will serve to return in the end the reversed x, moving the power and the value of x while in the loop

    public int reverse(int x) {
        int finalInt = 0;
        int size = String.valueOf(Math.abs(x)).length(); 
        int power = size-1;
        for (int i=0;i<size;i++){
            finalInt+= (x % 10) * Math.pow(10, power);
            power--;
            x/= 10;
        }
        if (finalInt < Integer.MIN_VALUE || finalInt > Integer.MAX_VALUE-1) return 0;
        return finalInt;
    }   

    //-----------------------------------------//

    public static void main(String[] args) {
        ex0007 myo= new ex0007();
        System.out.println(myo.reverse(1534236469));
    }

}
