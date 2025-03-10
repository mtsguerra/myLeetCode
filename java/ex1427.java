public class ex1427 {
    public String stringShift(String s, int[][] shift) {
        // initialize a variable to keep track of the balance between shift right and left
        int swapCount = 0;
        // iterate through the commands +rights and -lefts
        for (int [] swp : shift){
            if (swp[0] == 0) swapCount -= swp[1];
            else swapCount += swp[1];
        }
        // if the final balance equals to the x*length or 0 that means the result
        // its equal to s
        // also do it before hand to eliminates excessive shifts
        swapCount %= s.length();
        if (swapCount==0 || swapCount == 0) return s;
        // if its right just return the diff with swap count
        // else return the equivalent to the right shift
        int diff = s.length() - (swapCount>0?swapCount:s.length()-Math.abs(swapCount));
        // return the substring tail and the head
        return s.substring(diff) + s.substring(0, diff);
    }
        /* 
        // if the balance is positive that means it will rotate to the right
        if (swapCount > 0) return rotate(s,swapCount);
        // else we calc how many for the right i need to move to equals shift to left
        else return rotate(s,s.length()-swapCount * -1);
    }
    public String rotate (String s, int n){
        StringBuilder result = new StringBuilder();
        // starts the sb in the tail of the current divided string 
        for (int i=s.length()-n;i<s.length();i++){
            result.append(s.charAt(i));
        }
        // now append the head of the string
        for (int j=0;j<s.length()-n;j++){
            result.append(s.charAt(j));
        }
        return result.toString();
    }*/
}
