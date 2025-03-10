import java.util.HashMap;

public class ex2116 {
    public boolean canBeValid(String s, String locked) {
        if (s.length()%2!=0) return false;
        int balance =0;
        for (int i=0;i<s.length();i++){
            if (locked.charAt(i)=='0') balance++;
            else{
                balance += s.charAt(i) == '(' ? 1 : -1;
            }
            if (balance < 0) return false;
        }
        balance =0;
        for (int i=s.length()-1; i>=0;i--){
            if (locked.charAt(i)=='0') balance++;
            else{
                balance += s.charAt(i) == ')' ? 1 : -1;
            }
            if (balance < 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "((()))";
        String s2 = "101011";
        ex2116 myo = new ex2116();
        myo.canBeValid(s1,s2);
    }
}
