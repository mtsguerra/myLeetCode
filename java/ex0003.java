import java.util.HashSet;

public class ex0003 {

    //--------------------------------------------------------------------//
    // in this one i will be using one pointer to point to the beginning of the current sequence
    // and the other to accompany the loop, and the most important a hashset to store, the
    // characters, so while in the looping we will be adding the characters until one character
    // its already on the hashset, in that case we will be getting the size of the hashset to get
    // the size of the current seq and compare it to the biggest seq, after that we will be
    // removing the a_pointer elements of the hashset until the character that its equal to the 
    // current character is removed, so we can start a new seq

    public int lengthOfLongestSubstring(String s){
        int a_pointer = 0;
        int b_pointer =0;
        int biggestSeq =0;

        HashSet<Character> hashSet = new HashSet<>();

        while (b_pointer < s.length()){
            if (!hashSet.contains(s.charAt(b_pointer))){
                hashSet.add(s.charAt(b_pointer));
                b_pointer++;
                biggestSeq = Math.max(hashSet.size(), biggestSeq);
            }
            else{
                hashSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return biggestSeq;
    }

    //--------------------------------------------------------------------//

    /* 
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> currentMap = new HashMap<>();
        int biggestSeq=0;
        int firstIndexOfTheSeq = 0;
        StringBuilder currentSeq = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (currentMap.size() == 0){
                firstIndexOfTheSeq = i;
                currentMap.put(s.charAt(i), 1);
                currentSeq = new StringBuilder();
                currentSeq.append(s.charAt(i));
                continue;
            }
            if (currentMap.containsKey(s.charAt(i))){
                if (currentSeq.length() > biggestSeq){
                    biggestSeq = currentSeq.length();
                }
                currentMap = new HashMap<>();
                i = firstIndexOfTheSeq;
            }
            else {
                currentMap.put(s.charAt(i), 1);
                currentSeq.append(s.charAt(i));
            }
        }
        if (currentSeq.length() > biggestSeq){
            biggestSeq = currentSeq.length();
        } 
        return biggestSeq;
    }*/

    public static void main(String[] args) {
        ex0003 myo = new ex0003();
        System.out.println(myo.lengthOfLongestSubstring("dvdf"));    
    }
}
