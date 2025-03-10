public class ex0008 {


    //--------------------------------------------------------------------//
    // we basically iterate through the string ignoring the initial subsequent of spaces,
    // until we found a different character, if this character its not a digit we only add
    // him in the case of + and -, if not we will return 0, so after finding the first char
    // we will be adding all the subsequent digits until one !digit is found, and return this string
    // now on the other we will use a try to the case of the string not being able to be
    // converted into a integer through Integer.valueOf, now on the catch we will try the 3 cases,
    // one which the string its not null and the first char its a negative sign returning int.minv
    // the other one being the opposite 

    public int myAtoi(String s) {
        try {
            return Integer.valueOf(filter(s));
        } catch (Exception e) {
            if (filter(s).length() >= 1 && filter(s).charAt(0) == '-') return Integer.MIN_VALUE;
            else if (filter(s).length() >= 1) return Integer.MAX_VALUE;
            else return 0;
        }
    }

    public String filter(String s){
        if (s.length() == 0) return "0";
        if (s.length()==1){
            if (!Character.isDigit(s.charAt(0))) return "0";
            else return s;
        } 

        boolean spaces=true;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch==' ' && spaces) continue;
            if (ch!= ' ') spaces=false;
            if (!Character.isDigit(ch)){
                if (sb.length()!= 0){
                    if (sb.length()==1 && (sb.charAt(0) == '-' || sb.charAt(0)=='+')) return "0";
                    else return sb.toString();
                } 
                else if (ch!='-' && ch!='+') return "0";
                else{
                    sb.append(ch);
                    continue;
                } 
            } 
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ex0008 myo = new ex0008();
        System.out.println(myo.myAtoi("   -042"));
    }
}
