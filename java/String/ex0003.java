import java.util.HashSet;

public class ex0003 {

    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window approach with a HashSet to track characters in the current window.
     *
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(min(m,n)) where m is the size of the character set
     *
     * @param s The input string to be processed
     * @return The length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s){
        int leftPointer = 0;
        int rightPointer =0;
        int biggestSeq =0;

        HashSet<Character> hashSet = new HashSet<>();

        while (rightPointer < s.length()){
            if (!hashSet.contains(s.charAt(rightPointer))){
                hashSet.add(s.charAt(rightPointer));
                rightPointer++;
                biggestSeq = Math.max(hashSet.size(), biggestSeq);
            }
            else{
                hashSet.remove(s.charAt(leftPointer));
                leftPointer++;
            }
        }
        return biggestSeq;
    }
}
