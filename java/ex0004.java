public class ex0004 {

    //--------------------------------------------------------------------//
    // need to search a more efficient way later
    //--------------------------------------------------------------------//
    // now on this one to find the median i will iterate both n1 and n2 until k is equal
    // to the median, on the case of the number being even i will iterate until k < median-1,
    // so after doing that, in the case of the number being not even, i just need to find the
    // minimum value between n1 and n2, ignoring the other in the case of one of them being empty,
    // on the other hand in the case of the number being even i need to iterate two times,
    // verifying the case of one of them running out of numbers on the first number and in the
    // second one, and after getting the right and left of the median i just need to get the
    // half of their sum

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        boolean isEven = true;
        if ((nums1.length + nums2.length) % 2 != 0){
            isEven = false;
        }
        int median = (nums1.length + nums2.length) / 2;
        if (isEven) median--;
        while (i <nums1.length && j <nums2.length && k < median){
            if (nums1[i] <= nums2[j]) i++;
            else j++;
            k++;
        }
        
        while (i<nums1.length && k < median) {
            i++;
            k++;
        }

        while (j<nums2.length && k < median) {
            j++;
            k++;
        }
        
        if (isEven){
            int right;
            int left;

            if (i == nums1.length){
                right = nums2[j];
                j++;
                left = nums2[j];
                return (double) (right+left) / 2;
            }
            if (j == nums2.length){
                right = nums1[i];
                i++;
                left = nums1[i];
                return (double) (right+left) / 2;
            }

            if (nums1[i] <= nums2[j]){
                    right = nums1[i];
                    i++;
                }
                else{
                    right = nums2[j];
                    j++;
                }

            if (i==nums1.length){
                left = nums2[j];
                return (double) (right+left) / 2;
            }
            if (j==nums2.length){
                left = nums1[i];
                return (double) (right+left) / 2;
            }

            if (nums1[i] <= nums2[j]){
                left = nums1[i];
                i++;
            }
            else{
                left = nums2[j];
                j++;
            }

            return (double) (right+left) / 2;

        }     
        
        else{
            if (i == nums1.length) return nums2[j];
            else if (j == nums2.length) return nums1[i];
            else return Math.min(nums1[i], nums2[j]);
        } 
    }
    public static void main(String[] args) {
        ex0004 myo = new ex0004();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        //System.out.println(myo.findMedianSortedArrays(nums1, nums2));
    }
}
