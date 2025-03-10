public class ex0259 {

    // standard mergeSort
    public void mergeSort (int[] nums){
        if (nums==null || nums.length <= 1) return;
        int mid = nums.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[nums.length-mid];
        for (int i=0;i<mid;i++){
            leftHalf[i] = nums[i];
        }
        for (int j=mid;j<nums.length;j++){
            rightHalf[j-mid] = nums[j];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(nums, leftHalf, rightHalf);
    }

    public void merge(int[] original, int[] left, int[] right){
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length && j<right.length){
            if (left[i] <= right[j]){
                original[k] = left[i];
                i++;
            }
            else{
                original[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<left.length){
            original[k] = left[i];
            i++;
            k++;
        }
        while (j<right.length){
            original[k] = right[j];
            j++;
            k++;
        }
    }

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        else if (nums.length == 3) return (nums[0]+nums[1]+nums[2] < target ? 1 : 0);
        mergeSort(nums);
        // keep track of the possible solutions
        int result =0;
        // iterate until the last trio is possible to form
        for (int i=0;i<nums.length-2;i++){
            // set the first two num of the currentSum fix
            for (int j=i+1;j<nums.length-1;j++){
                // if the min sum possible to find is greater or equal than the target
                // all the sequent sums will be equal or greater than, so i do not need
                // to search anymore
                // two time because the next number is at least equal to j, if not greater than
                if (nums[i] + 2*nums[j] >= target) break;
                int currentSum = nums[i]+nums[j];
                int left = j+1;
                int right = nums.length-1;
                // iterate until find the last possible int we can to the currentSum
                while (left <= right){
                    int mid = left + (right-left) / 2;
                    if (currentSum+nums[mid] < target) left = mid + 1;
                    else right = mid -1;
                }
                // the total numbers we find is right - j
                result += right-j;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[]s={-1,1,-1,-1};
        ex0259 myo = new ex0259();
        System.out.println(myo.threeSumSmaller(s, -1));
    }
}
