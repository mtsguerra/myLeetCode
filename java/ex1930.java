import java.util.HashMap;
import java.util.HashSet;

public class ex1930 {
    public int countPalindromicSubsequence(String s){
        int result = 0;
        for (char ch ='a';ch<='z';ch++){
            int firstIndex = s.indexOf(ch);
            int lastIndex = s.lastIndexOf(ch);
            if (firstIndex != -1 && lastIndex != -1 && firstIndex < lastIndex){
                HashSet<Character> middleCharacters = new HashSet<>();
                for (int i=firstIndex+1;i<lastIndex;i++){
                    middleCharacters.add(s.charAt(i));
                }
                result+=middleCharacters.size();
            }
        }
        return result;
    }
    /*public HashSet<String> allCom;
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            if (map.containsKey(ch)) map.put(ch, map.get(ch)+1);
            else map.put(ch, 1);
        }
        allCom = new HashSet<>();
        for (int i =0;i<s.length()-2;i++){
            char currentChar = s.charAt(i);
            if (map.get(currentChar) > 1){
                countRecursive(s.substring(i+1), 0, currentChar, map.get(currentChar)-1);
            }
            int newCount = map.get(currentChar) - 1;
            if (newCount <= 0) map.remove(currentChar);
            else map.put(currentChar, newCount);
        }
        return allCom.size();
    }
    public void countRecursive (String s, int currentIndex, char ch, int remainingCH){
        if (currentIndex >= s.length() || remainingCH <= 0) return;
        String currentTry = "";
        currentTry+=ch;
        currentTry+=s.charAt(currentIndex);
        if (s.charAt(currentIndex)==ch) remainingCH--;
        if (remainingCH >= 1 && !allCom.contains(currentTry)) allCom.add(currentTry);
        countRecursive(s, currentIndex+1, ch, remainingCH);
    }*/

    public static void main(String[] args) {
        String s = "abaabc";
        ex1930 myo = new ex1930();
        myo.countPalindromicSubsequence(s);
    }
}
