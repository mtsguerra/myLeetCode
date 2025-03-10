public class ex0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // all same length
        int lastCol = matrix[0].length-1;
        // iterate through all the lines
        for (int[] currentMatrix : matrix){
            // if the start of a line is greater than the target that means
            // all the subsequent lines will have a greater start so it is not on the matrix
            if (currentMatrix[0] > target) return false;
            else if (currentMatrix[0] <= target && currentMatrix[lastCol] >= target){
                // initialize the variable to keep track of the lines
                int left=0;
                int right=lastCol;
                // perform standard binary search  
                while (left<=right){
                    int mid = left + (right-left) / 2;
                    if (currentMatrix[mid] == target) return true;
                    else if (currentMatrix[mid] > target) right=mid-1;
                    else left=mid+1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] s = {{5},{6}};
        ex0240 myo = new ex0240();
        myo.searchMatrix(s, 6);
    }
}
