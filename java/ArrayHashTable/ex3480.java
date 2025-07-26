class ex3480 {

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long result = 0;
        int originalSubArrays = (n * (n + 1)) / 2; // Total subarrays from 1 to n
        int[][] conflicts = new int[n + 1][n + 1];
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            for (int i=b;i<=n;i++) {
                for (int j=a;j>=1;j--) {
                    if (conflicts[i][j] ==0) originalSubArrays--;
                    conflicts[i][j]++;
                }
            }
        }
        int maxSubArrays = originalSubArrays;
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            int temp = originalSubArrays;
            for (int i=b;i<=n;i++) {
                for (int j=a;j>=1;j--) {
                    if (conflicts[i][j] == 1) {
                        temp++;
                    }
                }
            }
            maxSubArrays = Math.max(temp, maxSubArrays);
        }
        return maxSubArrays;
    }

    /*public long maxSubarrays(int n, int[][] conflictingPairs) {
        long originalSubArrays = (n * (n + 1)) / 2; // Total subarrays from 1
        // the max X and Y axis that not himself
        long[][] conflicts = new long[conflictingPairs.length][2];
        long[][] subArrays = new long[n+1][n+1];
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            for (int i=b;i<=n;i++) {
                for (int j=a;j>=1;j--) {
                    if (subArrays[i][j] ==0) originalSubArrays--;
                    subArrays[i][j]++;
                }
            }
        }
        for (int i = 0; i < conflictingPairs.length; i++) {
            int[] pair = conflictingPairs[i];
            int a = n - Math.min(pair[0], pair[1])+1;
            int b = Math.max(pair[0], pair[1]);
        }
        long maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < conflictingPairs.length; i++) {
            int[] pair = conflictingPairs[i];
            long a = Math.min(pair[0], pair[1]);
            long b = Math.max(pair[0], pair[1]);
            long profit = (a*b) - (conflicts[i][0] * b) - (conflicts[i][1] * a);
            maxProfit  = Math.max(maxProfit, profit);
        }
        return originalSubArrays + maxProfit;
    }*/

    public static void main(String[] args) {
        ex3480 solution = new ex3480();
        int n = 5;
        int[][] conflictingPairs = {{1,2},{2,5},{3,5}};
        long result = solution.maxSubarrays(n, conflictingPairs);
        System.out.println("Maximum number of subarrays: " + result); // Example output
    }
}