import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ex1408 {
    
    public List<String> stringMatching(String[] words) {
        List<String> result = new LinkedList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i=0;i<words.length;i++){
            for (int j=i+1;j<words.length;j++){
                boolean found = false;
                if (i!=j&&words[j].length()>words[i].length()){
                    int left=0;
                    int right=words[i].length();
                    while (right<=words[j].length()){
                        String sub = words[j].substring(left,right);
                        if (sub.equals(words[i])){
                            result.add(words[i]);
                            found=true;
                            break;
                        } 
                        left++;
                        right++;
                    }
                }
                if (found) break;
            }
        }
        return result;
    }
    
    public HashSet<String> set = new HashSet<>();

    public List<String> stringMatching3(String[] words) {
        List<String> result = new LinkedList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        for (String current : words){
            addAllSub(current);
        }
        for (String current : words){
            if (set.contains(current)) result.add(current);
        }
        return result;
    }

    private void addAllSub(String word){
        boolean toRemove = false;
        if (!set.contains(word)) toRemove = true;
        for (int i=0;i<word.length();i++){
            for (int j=word.length();j>i;j--){
                set.add(word.substring(i, j));
            }
        }
        if (toRemove) set.remove(word);
    }

    public List<String> stringMatching2(String[] words) {
        List<String> result = new LinkedList<>();
        for (int i=0;i<words.length;i++){
            String currentS = words[i];
            for (int j = 0;j<words.length;j++){
                if (words[j].length() > currentS.length()){
                    int ind = 0;
                    boolean found = false;
                    while (words[j].length()-ind>=currentS.length()){
                        if (words[j].charAt(ind) == currentS.charAt(0)){
                            found=true;
                            for (char ch : currentS.toCharArray()){
                                if (words[j].charAt(ind)!=ch){
                                    found=false;
                                    break;
                                } 
                                ind++;
                            }
                            if (found){
                                result.add(currentS);
                                break;
                            } 
                        }
                        else ind++;
                    }
                    if (found) break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ex1408 myo = new ex1408();
        String[] ss = {"mass", "as", "hero", "superhero"};
        myo.stringMatching(ss);
    }
}
