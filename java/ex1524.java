class ex1524 {
    private static final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int count=0;
        int prefixSum =0;
        int[] odd = new int[2];
        odd[0]=1;
        for (int num : arr){
            prefixSum = (prefixSum+num)%2;
            count = (count + odd[1-prefixSum])%MOD;
            odd[prefixSum]++;
        }
        return count;
    }

    public static   void main(String[] args) {
        ex1524 myo = new ex1524();
        int[]arr = {1,2,3,4,5,6,7};
        System.out.println(myo.numOfSubarrays(arr));
    }
}