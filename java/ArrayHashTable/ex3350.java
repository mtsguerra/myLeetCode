import java.util.*;

class ex3350{
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int maxK = 0;
        if (nums.size()>=2) maxK = 1;
        int start = 0;
        for (int end=1;end<nums.size();end++){
            if (nums.get(end)<=nums.get(end-1)){
                int currentK = end - start;
                start = end;
                if (currentK>=2){
                    if (currentK>maxK) maxK = Math.max(maxK, currentK / 2);
                    else continue;
                }
                else continue;
                int maxNext = 1;
                for (int j=end;j<end+currentK-1;j++){
                    if (j+1<nums.size() && nums.get(j+1)>nums.get(j)) maxNext++;
                    else break;
                }
                maxK = Math.max(maxK,maxNext);
            }
        }
        return Math.max(maxK, (nums.size()-start)/2);
    }

    public static void main(String[] args) {
        ex3350 myo = new ex3350();
        List<Integer> n = Arrays.asList(-8,7,-16,-7,18);
        System.out.println(myo.maxIncreasingSubarrays(n));
    }
}