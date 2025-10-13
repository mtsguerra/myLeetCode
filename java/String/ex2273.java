import java.util.*;

class ex2273 {
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