public class ex2466 {

    public int countGoodStrings(int low, int high, int zero, int one){
        // mod so it doesnt overflow
        int mod = 1000000007;
        // counter
        int total=0;
        // array to count all the forms we can form form an i sized string
        int[] waysToForm = new int[high+1];
        // setting the 0 to 1 way, because i can form the empty string only one way
        waysToForm[0] = 1;
        // for loop to fill the array
        for (int i=1;i<waysToForm.length;i++){
            // int this i get if the number its greater or equal to the number
            // of zeros that i need to add to it, so i can use i-zero
            // on wtf[i] + wtf[i-zero] i will be getting the current number of
            // ways to form and add the number of ways the previous one could be formed
            // for example i have the zero = 2 and one = 1, i can only form starting
            // on size 4, but on size three the previous could be formed by or 11 or 00
            // on size 5, the previous could be formed by 111, 100, 001 and it goes on
            // so i will be using the previous ways to form to form the new ones
            // and in the end using %mod so it does not overflow
            if (i>=zero) waysToForm[i] = (waysToForm[i] + waysToForm[i-zero]) % mod;
            // same logic as the other
            if (i>=one) waysToForm[i] = (waysToForm[i] + waysToForm[i-one]) % mod;
        }
        // after filling the array i will be looping through from the low to the high
        for (int j=low;j<=high;j++){
            // and adding the number of ways in all the sizes on the range
            // using %mod again so it does not overflow
            total = (total + waysToForm[j]) % mod;
        }
        return total;
    }

    public static void main(String[] args) {
        ex2466 myo = new ex2466();
        System.out.println(myo.countGoodStrings(2, 3, 1, 2));
    }
}
