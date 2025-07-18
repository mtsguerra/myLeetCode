public class ex0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // initialize the pointers to get the boundaries
        int right =matrix.length-1;
        int left = 0;
        // the int to get the number of columns
        int lastIndex = matrix[0].length-1;

        while (left<=right) {
            // to try not to overflow
            int middle = left+(right-left) / 2;
            // last number of the middle line
            int lastOfTheLine = matrix[middle][lastIndex];
            // possible line where the target could be
            if (lastOfTheLine >= target){
                // now i have the line where the target will or will not be in it
                if (matrix[middle][0] <= target){
                    // with this two pointers i can keep track of the boundaries
                    int insideLeft = 0;
                    int insideRight = lastIndex;
                    // now i will bs search until found or other
                    while (insideLeft <= insideRight){
                        // the middle keeps always the same because i already have the line that i want which is middle index
                        // the rest is just standard bs
                        int insideMiddle = insideLeft+(insideRight-insideLeft) / 2;
                        int insideCurrent = matrix[middle][insideMiddle];
                        if (insideCurrent == target) return true;
                        else if (insideCurrent > target) insideRight = insideMiddle-1;
                        else insideLeft = insideMiddle + 1;
                    }
                    // because the lines do not repeat sequences neither numbers 
                    // i can admit that if the target is not in this line it wont be
                    // in any other lines
                    return false;
                }
                else{
                    right = middle -1;
                }    
            }
            // because i have the restriction where the first of the next line
            // will always be greater than the last of the current, and the lines
            // are sorted i can admit this
            else{
                left = middle + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ex0074 myo = new ex0074();
        int[][] mymatrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(myo.searchMatrix(mymatrix, 13));
    }
}
