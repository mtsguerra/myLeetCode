import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ex0349 {

    public int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int biggest = nums1[nums1.length-1] > nums2[nums2.length-1] ? nums1[nums1.length-1] : nums2[nums2.length-1];
        Set<Integer> s1 = new HashSet<>();
        for (int n : nums1){
            if (n > biggest) break;
            s1.add(n);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int n : nums2){
            if (n > biggest) break;
            s2.add(n);
        }
        s1.retainAll(s2);
        int[] result = new int[s1.size()];
        int i=0;
        for (int n : s1){
            result[i] = n;
            i++;
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> preresult = new HashSet<>();
        int n1 =0;
        int n2=0;
        while (n1<nums1.length&&n2<nums2.length){
            if (nums1[n1]==nums2[n2]) {
                preresult.add(nums1[n1]);
                n1++;
                n2++;
            }
            else if (nums1[n1]>nums2[n2]) n2++;
            else n1++;
        }
        int[] result = new int[preresult.size()];
        int i=0;
        for (int n : preresult){
            result[i] = n;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        ex0349 myo = new ex0349();
        int [] s1 = {1,2,2,1};
        int [] s2 = {2,2};
        myo.intersection(s1, s2);
    }
}
