public class ex0008 {

    /**
     * Converts a string to a 32-bit signed integer, following the rules similar
     * to those of the `atoi` function in C.
     *
     * Rules:
     * - Discards all leading whitespace characters.
     * - Considers an optional initial '+' or '-' for the sign.
     * - Parses the subsequent numerical characters, stopping at the first
     *   non-numerical character.
     * - If the resulting integer is out of the 32-bit range, clamps the value
     *   to Integer.MIN_VALUE or Integer.MAX_VALUE.
     * - If no numerical characters are present, returns 0.
     *
     * Time complexity: O(n) where n is the length of the string.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param s The input string to be converted to an integer.
     * @return The integer representation of the string, clamped to 32-bit signed
     *         integer range if necessary, or 0 if no valid conversion exists.
     */
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
