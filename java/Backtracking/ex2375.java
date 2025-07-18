public class ex2375 {
    public String smallestNumber(String pattern) {
        boolean [] used = new boolean[10];
        if (pattern.charAt(0)=='I') pattern = "I" + pattern;
        else pattern = 'D' + pattern;
        return find(pattern, used, 0, "");
    }
    private String find (String pattern, boolean[] used, int pos, String current){
        if (current.length() == pattern.length()) return current;
        int last = current.equals("") ? (pattern.charAt(0)=='I' ? 0 : 9) : Character.getNumericValue(current.charAt(current.length()-1));
        boolean increasing = pos < pattern.length() && pattern.charAt(pos)=='I';
        if (increasing){
            for (int i=last+1;i<=9;i++){
                if (!used[i]){
                    used[i]=true;
                    String possible = find(pattern, used, pos+1, current+i);
                    if (possible.length()==pattern.length()) return possible;
                    used[i] = false;
                }
            }
        }
        else{
            for (int i=1;i<=last;i++){
                if (!used[i]){
                    used[i] = true;
                    String possible = find(pattern, used, pos+1, current+i);
                    if (possible.length()==pattern.length()) return possible;
                    used[i] = false;
                }
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String s = "DDDDDDDD";
        ex2375 myo = new ex2375();
        System.out.println(myo.smallestNumber(s));
    }
}
