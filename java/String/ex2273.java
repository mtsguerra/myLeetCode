import java.util.*;

class ex2273 {
    /**
     * Given an array of strings words, remove the consecutive strings that are anagrams of each other and return the remaining array.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     * Time Complexity: O(n * m), where n is the number of words and m is the average length of the words.
     * Space Complexity: O(n), for storing the result list and frequency arrays.
     *
     * @param words an array of strings
     * @return the array after removing consecutive anagrams
     */
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int[] lastCount = new int[26];
        for (char c : words[0].toCharArray()) {
            lastCount[c - 'a']++;
        }
        for (int i=1;i<words.length;i++){
            int[] newCount = new int[26];
            for (char c : words[i].toCharArray()) {
                newCount[c - 'a']++;
            }
            if (!Arrays.equals(lastCount, newCount)){
                res.add(words[i]);
                lastCount = newCount;
                continue;
            }
        }
        return res;
    }
}