import java.util.ArrayList;
import java.util.Arrays;

public class ex0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList <Integer> arr = new ArrayList<>();
        int n1=0;
        int n2=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (n1<nums1.length&&n2<nums2.length){
            if (nums1[n1]==nums2[n2]){
                arr.add(nums1[n1]);
                n1++;
                n2++;
            }
            else if (nums1[n1] > nums2[n2]) n2++;
            else n1++;
        }
        int[] result = new int[arr.size()];
        for (int i=0;i<arr.size();i++){
            result[i] = arr.get(i);
        }
        return result;
    }
}
