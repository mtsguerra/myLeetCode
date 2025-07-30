import java.util.*;

public class ex0916 {

    /**
     * You are given two string arrays words1 and words2.
     * A string b is universal if for every string a in words2, a is a subset of b.
     * A string a is a subset of b if every letter in a occurs in b including multiplicity.
     * Return an array of all the universal strings in words1. You may return the answer in any order.
     *
     * Time Complexity: O(n * m), where n is the length of words1 and m is the maximum length of a word in words2.
     * Space Complexity: O(1) for the needsToHave array since it has a fixed size of 26.
     *
     * @param words1 Array of strings to check for universality
     * @param words2 Array of strings that must be subsets
     * @return List of universal strings from words1
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] needsToHave = new int[26];
        for (String word : words2) {
            int[] currentWordCount = new int[26];
            for (char ch : word.toCharArray()) {
                currentWordCount[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                needsToHave[i] = Math.max(needsToHave[i], currentWordCount[i]);
            }
        }
        for (String word : words1) {
            int[] currentWordCount = new int[26];
            for (char ch : word.toCharArray()) {
                currentWordCount[ch - 'a']++;
            }
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (currentWordCount[i] < needsToHave[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        return list;
    }

    /*
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new LinkedList<>();
        HashMap<Character, Integer> table = new HashMap<>();
        for (String w : words2){
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char ch : w.toCharArray()){
                temp.put(ch, temp.containsKey(ch) ? temp.get(ch)+1 : 1);
            }
            for (Map.Entry<Character,Integer> t : temp.entrySet()){
                table.put(t.getKey(), table.containsKey(t.getKey()) ? Math.max(table.get(t.getKey()), t.getValue()) : t.getValue());
            }
        }
        for (String current : words1){
            boolean subse = true;
            for (char ch : table.keySet()){
                if (current.indexOf(ch)==-1){
                    subse=false;
                    break;
                }
                int size = current.length();
                int newsize = current.replace(String.valueOf(ch), "").length();
                if (size-newsize<table.get(ch)){
                    subse=false;
                    break;
                }
            }
            if (subse) result.add(current);
        }
        return result;
    }
    */
    public static void main(String[] args) {
        String[]s1={"bcedecccdb","daeeddecbc","ecceededdc","edadadccea","ebacdedcea","eddabdacec","cddbecbeca","eeababedcc","bcaddcdbad","aeeeeabeea"};
        String[]s2={"cb","aae","ccc","ab","adc"};
        ex0916 myo = new ex0916();
        myo.wordSubsets(s1, s2);
    }
}
