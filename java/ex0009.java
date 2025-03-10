public class ex0009 {

    //---------------------------------------//
    // first check if the number is negative or if its devisable by 10 and diff 0, after that we create a number thar will be the reversed number
    // while we eliminate the x%10 from the original we append it to the reversed and while doing it we multiply by ten when adding a new one,
    // so in the final we check if the numbers are equal, if they are not theres still a chance of the number be palindrome but with a even number
    // of numbers so we test it again but without the number on the middle

    public boolean isPalindrome(int x) {
        if (x<0 || (x%10==0 && x!=0)) return false;
        int reversed = 0;
        while (x > reversed){
            reversed = reversed * 10 + x % 10;
            x/= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    //---------------------------------------//

/*public boolean isPalindrome(int x) {
    if (x<0) return false;
    String str = String.valueOf(x);
    if (str.charAt(str.length()-1) == '-') return false;
    if (str.length() == 1) return true;
    int r=str.length()-1;
    int l=0;
    while (l < str.length() && r>=0 &&r >= l){
        if (str.charAt(l) != str.charAt(r)) return false;
        l++;
        r--;
    }
    return true;
}*/
    public static void main(String[] args) {
        ex0009 myo = new ex0009();
        myo.isPalindrome(121);
    }
}
