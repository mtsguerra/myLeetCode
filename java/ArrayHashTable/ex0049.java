import java.util.*;

class ex0049 {
    /**
     * Given an array of strings strs, group the anagrams together.
     *
     * * Time Complexity: O(n * k), where n is the number of strings and k is the maximum length of a string.
     * * Space Complexity: O(n * k), where n is the number of strings and k is the maximum length of a string.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ex0049 myo = new ex0049();
        myo.groupAnagrams(strs);
    }
}