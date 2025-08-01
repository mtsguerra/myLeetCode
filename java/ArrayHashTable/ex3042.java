import java.util.Arrays;
import java.util.Comparator;

public class ex3042 {
    /**
     * Given an array of strings words, return the number of pairs (i, j)
     * such that i < j and words[i] is a prefix of words[j] and
     * words[i] is a suffix of words[j].
     *
     * Time Complexity: O(n^2 * m) where n is nWords and m is the avg len(words)
     * Space Complexity: O(1) for the result variable.
     *
     * @param words Array of strings
     * @return Number of prefix-suffix pairs
     */
    public int countPrefixSuffixPairs(String[] words) {
        int result=0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i=0;i<words.length;i++){
            for (int j=i+1;j<words.length;j++){
                if (isPrefixSuffix(words[i], words[j])) result++;
            }
        }
        return result;
    }
    private boolean isPrefixSuffix(String str1, String str2){
        if (str1.length()>str2.length()) return false;
        if (str2.startsWith(str1) && str2.endsWith(str1)) return true;
        return false;
    }
}
