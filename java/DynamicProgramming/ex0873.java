import java.util.HashMap;

class ex0873 {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        if (arr == null || n < 3) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++){
            map.put(arr[i],i);
            for (int j=i+1;j<n;j++){
                dp[i][j] = 2;
            }
        }
        int highest = 0;
        for (int m=0;m<n;m++){
            for (int k=m+1;k<n;k++){
                int previous = arr[m];
                int current = arr[k];
                int diff = current-previous;
                if (map.containsKey(diff)){
                    int i=map.get(diff);
                    if (i < m){
                        dp[m][k] = dp[i][m] + 1;
                        highest = Math.max(highest,dp[m][k]);
                    }
                }
            }
        }
        return highest >= 3 ? highest : 0;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,7,8,9,10,14,15,18,23,32,50};
        ex0873 myo = new ex0873();
        System.out.println(myo.lenLongestFibSubseq(arr));
    }
}