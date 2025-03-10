public class ex2185 {
    public int prefixCount(String[] words, String pref) {
        int result =0;
        for (String w : words){
            if (w.length()>=pref.length()&&w.startsWith(pref)) result++;
        }
        return result;
    }
}
