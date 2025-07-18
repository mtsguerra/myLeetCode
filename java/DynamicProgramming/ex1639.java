import java.util.ArrayList;
import java.util.HashMap;

public class ex1639 {

    //You are given a list of strings of the same length words and a string target.

    // Your task is to form target using the given words under the following rules:

    // target should be formed from left to right.
    // To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
    // Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. 
    // In other words, all characters to the left of or at index k become unusuable for every string.
    // Repeat the process until you form the string target.
    // Notice that you can use multiple characters from the same string in words provided the conditions above are met.

    // Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

    //--------------------------------------------------------------------------------------------//

    // in this problem i need to find all the possible combinations given the instructions, i will create a hashMap with key being the characters
    // of the target and the value being a arraylist containing the frequency of this character in all indexes of the words available 
    // after this i will iterate through the map in a recursive way to accumulate the possibles ways to get that combinations, the for looping
    // that begins on the current index will not go until the end of size, because if i == size-1-wordIndex that means that theres no way anymore 
    // to complete that word because it will be still be remaining at least one character in the end so theres no need to continue the search
    // the "total = (total +((long) indxTotal * getTotal(map, target, wordIndex + 1, i + 1)) % MOD) % MOD;" line represents the accumulated total
    // but first i will be assuring that the mult result is in % MOD and after adding to the total i will be checking again 


    // Modulo constant to handle large numbers as per problem requirement
    private static final int MOD = 1_000_000_007;  

    // Memoization array: memo[i][j] stores number of ways to form target[i:] starting from position j
    private Long[][] memo; 

    public int numWays(String[] words, String target) {

        // Step 1: Build frequency map 
        // Key: character from target
        // Value: ArrayList where index i contains the frequency of the respective character in that index
        // in all the words (same length)

        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();

        // Initialize frequency lists for each unique character in target
        // Skip if character already in the map to avoid extra steps

        for (char ch : target.toCharArray()){
            if (map.containsKey(ch)) continue;
            ArrayList<Integer> indxs = new ArrayList<>();
            for (int o=0;o<words[0].length();o++){
                indxs.add(0); // Initialize all the indexes possible with 0 frequency, to be filled
            }
            map.put(ch, indxs);
        }

        // In this loop it will count the frequency of all the
        // characters that are present in the map

        for (String w : words){
            for (int i = 0; i < w.length();i++){
                if (map.containsKey(w.charAt(i))){
                    ArrayList<Integer> toAlt = map.get(w.charAt(i));
                    int newCount = (toAlt.get(i) + 1);
                    toAlt.set(i, newCount);
                }
            }
        }

        // Initialize memoization array for dynamic programming 

        memo = new Long[target.length()][words[0].length()];
        return (int) getTotal(map, target, 0, 0);
    }

    public long getTotal (HashMap<Character,ArrayList<Integer>> map, String target, int wordIndex, int currentIndex){

        // Base cases:
        // Case 1: successfully formed the target
        if (wordIndex == target.length()) return 1;
        // Case 2: ran out of positions to check
        if (currentIndex >= map.get(target.charAt(wordIndex)).size()) return 0;
        // Check memoization array for previously calculated result
        if (memo[wordIndex][currentIndex] != null) return memo[wordIndex][currentIndex];

        char currentLetter = target.charAt(wordIndex);
        ArrayList<Integer> indxs = map.get(currentLetter);
        long total =0;

        // In this loop to optimized it i used a sentence that will result in the number of letters needed
        // So i do not need to check all the positions, only the positions that have enough remaining letters
        for (int i=currentIndex;i<indxs.size()-(target.length()-1-wordIndex);i++){
            int indxTotal = indxs.get(i);
            if (indxTotal > 0){
                // Calculate combinations using current position:
                // 1. Multiply by the current frequency found
                // 2. Recursively calculates all the others possible ways
                // 3. Apply modulo at each step to prevent overflow
                total = (total +((long) indxTotal * getTotal(map, target, wordIndex + 1, i + 1)) % MOD) % MOD;
            }
        }

        // Store result in memoization array before returning to check it later on
        memo[wordIndex][currentIndex] = total;
        return (int) total;
    }

    

    public static void main(String[] args) {

        String [] words = {"cabbaacaaaccaabbbbaccacbabbbcb","bbcabcbcccbcacbbbaacacaaabbbac",
        "cbabcaacbcaaabbcbaabaababbacbc","aacabbbcaaccaabbaccacabccaacca",
        "bbabbaabcaabccbbabccaaccbabcab","bcaccbbaaccaabcbabbacaccbbcbbb",
        "cbbcbcaaaacacabbbabacbaabbabaa","cbbbbbbcccbabbacacacacccbbccca",
        "bcbccbccacccacaababcbcbbacbbbc","ccacaabaaabbbacacbacbaaacbcaca",
        "bacaaaabaabccbcbbaacacccabbbcb","bcbcbcabbccabacbcbcaccacbcaaab",
        "babbbcccbbbbbaabbbacbbaabaabcc","baaaacaaacbbaacccababbaacccbcb",
        "babbaaabaaccaabacbbbacbcbababa","cbacacbacaaacbaaaabacbbccccaca",
        "bcbcaccaabacaacaaaccaabbcacaaa","cccbabccaabbcbccbbabaaacbacaaa",
        "bbbcabacbbcabcbcaaccbcacacccca","ccccbbaababacbabcaacabaccbabaa",
        "caaabccbcaaccabbcbcaacccbcacba","cccbcaacbabaacbaaabbbbcbbbbcbb",
        "cababbcacbabcbaababcbcabbaabba","aaaacacaaccbacacbbbbccaabcccca",
        "cbcaaaaabacbacaccbcbcbccaabaac","bcbbccbabaccabcccacbbaacbbcbba",
        "cccbabbbcbbabccbbabbbbcaaccaab","acccacccaabbcaccbcaaccbababacc",
        "bcacabaacccbbcbbacabbbbbcaaaab","cacccaacbcbccbabccabbcbabbcacc",
        "aacabbabcaacbaaacaabcabcaccaab","cccacabacbabccbccaaaaabbcacbcc",
        "cabaacacacaaabaacaabababccbaaa","caabaccaacccbaabcacbcbbabccabc",
        "bcbbccbbaaacbaacbccbcbababcacb","bbabbcabcbbcababbbbccabaaccbca",
        "cacbbbccabaaaaccacbcbabaabbcba","ccbcacbabababbbcbcabbcccaccbca",
        "acccabcacbcbbcbccaccaacbabcaab","ccacaabcbbaabaaccbabcbacaaabaa",
        "cbabbbbcabbbbcbccabaabccaccaca","acbbbbbccabacabcbbabcaacbbaacc",
        "baaababbcabcacbbcbabacbcbaaabc","cabbcabcbbacaaaaacbcbbcacaccac"};

        String target = "acbaccacbbaaabbbabac";
        ex1639 myo = new ex1639();
        System.out.println(myo.numWays(words, target));
    }
}
