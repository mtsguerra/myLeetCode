import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ex0916 {
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
    public static void main(String[] args) {
        String[]s1={"bcedecccdb","daeeddecbc","ecceededdc","edadadccea","ebacdedcea","eddabdacec","cddbecbeca","eeababedcc","bcaddcdbad","aeeeeabeea"};
        String[]s2={"cb","aae","ccc","ab","adc"};
        ex0916 myo = new ex0916();
        myo.wordSubsets(s1, s2);
    }
}
