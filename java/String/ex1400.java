public class ex1400 {
    public boolean canConstruct(String s, int k) {
        int size = s.length();
        if (k>size) return false;
        int [] freq = new int[26];
        for (char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int countOdd = 0;
        for (int count : freq){
            if (count%2!=0) countOdd++;
        }
        return countOdd<=k;
    }
}
