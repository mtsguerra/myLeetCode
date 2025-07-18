public class ex0275 {
    public int hIndex(int[] citations) {
        // initialize the boundaries variables
        int left =0;
        int right =citations.length-1;
        while (left<=right){
            int mid = left + (right-left) / 2;
            // if the current citation have at least ct[mid]-1 papers after that
            // it means theres at least one smaller index with the same properties
            // or its the smallest index and in the end of the loop the left pointer
            // will come back to this mid
            if (citations[mid] >= citations.length-mid) right = mid-1;
            else left = mid+1;
        }
        return citations.length-left;
    }
}