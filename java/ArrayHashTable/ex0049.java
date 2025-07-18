import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ex0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] alph = new int[26];
            for (char ch : str.toCharArray()){
                alph[ch-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int count : alph) key.append('#').append(count);
            List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
            list.add(str);
            map.put(key.toString(), list);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> t : map.values()) ans.add(t);
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ex0049 myo = new ex0049();
        myo.groupAnagrams(strs);
    }
}