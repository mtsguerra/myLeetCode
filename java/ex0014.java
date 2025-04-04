import java.util.Arrays;
import java.util.Scanner;

public class ex0014 {

    /**
     * Given an array of strings, find the longest common prefix string
     *
     * Approach:
     * 1. Check if the array is empty or has only one string.
     * 2. Initialize a variable to keep track of the end index of the prefix.
     * 3. Use a loop to compare characters at the same index in all strings.
     * 4. If a mismatch is found, return the prefix up to that index.
     *
     * Time complexity: O(n*m) where n is the number of strings and m is the length of the longest string.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param strs the array of strings
     * @return the longest common prefix
     */
    public String longestCommonPrefix(String[] strs){
        if (strs.length==0) return "";
        if (strs.length==1) return strs[0];
        int end = 0;
        String prefix = strs[0];
        while (end < prefix.length()){
            for (int i=0;i<strs.length;i++){
                if (end >= strs[i].length() || strs[i].charAt(end) != prefix.charAt(end)){
                    if (end==0) return "";
                    else return prefix.substring(0, end);
                }
            }
            end++;
        }
        return prefix.substring(0, end);
    }
}
