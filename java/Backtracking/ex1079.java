import java.util.HashSet;

public class ex1079 {
    public int numTilePossibilities(String tiles){
        int[] alpha = new int[26];
        for (char ch : tiles.toCharArray()){
            alpha[ch-'A']++;
        }
        return backtracking(alpha);
    }
    private int backtracking (int[] alpha){
        int count =0;
        for (int i=0;i<26;i++){
            if (alpha[i] > 0){
                alpha[i]--;
                count+=1 + backtracking(alpha);
                alpha[i]++;
            }
        }
        return count;
    }

    public int numTilePossibilities1(String tiles) {
        int[] alpha = new int[26];
        for (char ch : tiles.toCharArray()){
            alpha[Character.isUpperCase(ch) ? ch-'A' : ch-'a'] += 1;
        }
        long totl = 1;
        for (int n : alpha) {
            if (n>1){
                totl*=fac(n);
            }
        }
        long up = fac(tiles.length());
        int ff = (int) (up/totl);
        HashSet<String> f = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        backT(tiles, "", visited, f);
        
        return f.size()-1+ff;
    }
    private long fac(int n){
        if (n==1) return 1;
        return n * fac(n-1);
    }
    private void backT (String original, String current, boolean[] visited,
     HashSet<String> f){
        if (current.length() >= original.length() || f.contains(current)) return;
        if (!f.contains(current)) f.add(current);
        for (int i=0;i<original.length();i++){
            if (!visited[i] ){
                current += original.charAt(i);
                visited[i] = true;
                backT(original, current, visited, f);
                visited[i] = false;
                current = current.substring(0,current.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        ex1079 myo = new ex1079();
        System.out.println(myo.numTilePossibilities("AAABBC"));
    }
}
