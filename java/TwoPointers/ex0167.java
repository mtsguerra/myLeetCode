public class ex0167 {
    public int[] twoSum(int[] numbers, int target) {
        // initialize the return int[]
        int[] f = {-1,-1};
        // initialize the pointers
        int right=numbers.length-1;
        int left=0;
        // iterate through the numbers until target sum found or else
        while (left <= right){
            // get the current sum of the pointers
            int sum = numbers[right] + numbers[left];
            if (sum == target){
                f[0] = numbers[left];
                f[1] = numbers[right];
                return f;
            }
            // if it is greater than the target i need to decrease the bigger
            // number of the sum
            if (sum > target) right--;
            // else just increase the lower number of the sum
            else left++;
        }
        return f;
    }
    public static void main(String[] args) {
        ex0167 myo = new ex0167();
        int[] numbers = {3,24,50,79,88,150,345};
        for (int n : myo.twoSum(numbers,  200)){
            System.out.println(n);
        }
    }
}
