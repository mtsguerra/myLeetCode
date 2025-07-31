import java.util.*;

class ex0898 {

    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for (int i=arr.length-1; i>=0; i--) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int j : prev) {
                tmp.add(j | arr[i]);
            }
            prev = tmp;
            set.addAll(prev);
        }
        return set.size();
    }
}