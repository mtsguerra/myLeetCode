public class ex3174 {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        int siz = 0;
        for (int i =0;i<s.length();i++){
            if (!Character.isDigit(s.charAt(i))){
                ans.append(s.charAt(i));
                siz++;
            }
            else if (siz >= 1) {
                ans.deleteCharAt(siz-1);
                siz--;
            }
        }
        return ans.toString();
    }
}
