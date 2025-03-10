public class ex0689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int size = nums.length;
        int[] sums = new int[size - k + 1];
        int[] leftIndex = new int[size - k + 1];
        int[] rightIndex = new int[size - k + 1];
        int[] finalIndexes = new int[3];
    
        // Calculate sums of subarrays of length k
        int currentSum = 0;
        for (int i = 0; i < size; i++) {
            currentSum += nums[i];
            if (i >= k) currentSum -= nums[i - k];
            if (i >= k - 1) sums[i - k + 1] = currentSum;
        }
    
        // Fill leftIndex array with the best indices from the left
        int maxIndex = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[maxIndex]) maxIndex = i;
            leftIndex[i] = maxIndex;
        }
    
        // Fill rightIndex array with the best indices from the right
        maxIndex = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[maxIndex]) maxIndex = i;
            rightIndex[i] = maxIndex;
        }
    
        // Find the best middle subarray with its corresponding left and right subarrays
        int maxSum = 0;
        for (int mid = k; mid <= sums.length - k - 1; mid++) { // Ensure mid + k is in bounds
            int l = leftIndex[mid - k];
            int r = rightIndex[mid + k];
            int total = sums[l] + sums[mid] + sums[r];
            if (total > maxSum) {
                maxSum = total;
                finalIndexes[0] = l;
                finalIndexes[1] = mid;
                finalIndexes[2] = r;
            }
        }
    
        return finalIndexes;
    }
    
    /*public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> numsIndex = new HashMap<>();

        int[] indexes = new int[nums.length / k - 1];
        int currentSmallest = Integer.MAX_VALUE;
        int currentSmallestIndex = -1;

        for (int i=0; i<nums.length-k;i++){
            int currentSum = 0;
            for (int j=i;j<i+k;j++){
                currentSum += nums[j];
            }
            if (numsIndex.size() >= indexes.length){
                if (!numsIndex.containsValue(currentSum)){
                    int mapSum =0;
                    int mapSumWithOutSubSeq =0;
                    int possibleIndex=-1;
                    boolean subsequent = false;
                    for (Map.Entry<Integer, Integer> entry : numsIndex.entrySet()){
                        mapSum+=entry.getValue();
                        if (i > entry.getKey() && i < entry.getKey() + k){
                            subsequent = true;
                            possibleIndex=entry.getKey();
                        } 
                        else mapSumWithOutSubSeq += entry.getValue();
                    }
                    if (subsequent){
                        mapSumWithOutSubSeq += currentSum;
                        if (mapSumWithOutSubSeq <= mapSum) continue;
                        currentSmallest = Integer.MIN_VALUE;
                        currentSmallestIndex = possibleIndex;
                    }
                    if (currentSum > currentSmallest){
                        numsIndex.remove(currentSmallestIndex);
                        numsIndex.put(i, currentSum);
                        currentSmallest = Integer.MAX_VALUE;
                        currentSmallestIndex = -1;
                        for (Map.Entry<Integer, Integer> entry : numsIndex.entrySet()){
                            int v = entry.getValue();
                            if (v < currentSmallest){
                                currentSmallest = v;
                                currentSmallestIndex = entry.getKey();
                            }
                            else if (v==currentSmallest){
                                if (entry.getKey() > currentSmallestIndex){
                                    currentSmallestIndex = entry.getKey();
                                }
                            }
                        }
                    }
                }
            }
             
            else{
                if (currentSum <= currentSmallest){
                    currentSmallest = currentSum;
                    currentSmallestIndex = i;
                }
                numsIndex.put(i, currentSum);
            } 
        }
        int p=0;
        for (int key : numsIndex.keySet()){
            indexes[p] = key;
            p++;
        }
        return indexes;
    }/* */

    public static void main(String[] args) {
        int[] ind = {1,2,1,2,6,7,5,1};
        ex0689 myo = new ex0689();
        int[] pr = myo.maxSumOfThreeSubarrays(ind, 2);
        for (int n : pr){
            System.out.println(n);
        }
    }

}
