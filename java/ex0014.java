import java.util.Arrays;
import java.util.Scanner;

public class ex0014 {

    //--------------------------------------------------------------------//
    // first of all we use it a sort command to that the array can be sorted, so if they
    // are sorted and have the same beginning and we are analyzing all the strings, so we
    // can compare only the first one and the last one on the sorted list, creating a stringbuilder
    // so we can store the common prefix, so while the prefixes are equals we will be appending 
    // to the stringbuilder and returning it in the final

    static Scanner input = new Scanner(System.in);

    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        if (strs.length==1) return strs[0];
        Arrays.sort(strs);
        String base = strs[0];
        String lst = strs[strs.length-1];
        StringBuilder fin = new StringBuilder();
        for (int i=0;i<Math.min(base.length(), lst.length());i++){
            if (base.charAt(i) != lst.charAt(i)) return fin.toString();
            fin.append(base.charAt(i));
        }
        return fin.toString();
    }

    public void read(){
        String [] cm = new String[3];
        for (int i=0;i<3;i++){
            String s = input.nextLine();
            cm[i] = s;
        }
        String [] pp = new String[1];
        String v = "";
        pp[0] = v;
        String f = longestCommonPrefix(pp);
        System.out.println(f);
    }

    //--------------------------------------------------------------------//
    public static void main(String[] args) {
        ex0014 myo = new ex0014();
        myo.read();
    }
}
