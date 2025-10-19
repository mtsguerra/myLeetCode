import java.util.*;

class ex1625 {
    /**
     * Given a string s consisting of digits, and two integers a and b,
     * this method finds the lexicographically smallest string that can be obtained
     * by testing all the possible rotations and additions to the digits at odd and even indices.
     *
     * Time Complexity: O(n^2), where n is the length of the string s.
     * Space Complexity: O(1), as we are using a constant amount of extra space.
     *
     * @param s the input string consisting of digits
     * @param a the integer to add to digits at odd indices
     * @param b the number of positions to rotate the string
     * @return the lexicographically smallest string obtainable
     */
    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;
        a %= 10;
        b %= s.length();

        int timesToRotate = (b == 0) ? 1 : s.length() / gcd(s.length(), b);
        int timesToAdd = (a == 0) ? 1 : 10 / gcd(10, a);

        for (int i = 0; i < timesToRotate; i++) {
            String rotated = rotateRight(s, (i * b) % s.length());
            for (int j = 0; j < timesToAdd; j++) {
                String temp = add(rotated, (j*a)%10, true);
                if ((b&1) == 1) {
                    for (int k = 0; k < timesToAdd; k++) {
                        String t = add(temp, (k * a) % 10, false);
                        if (t.compareTo(smallest) < 0) smallest = t;
                    }
                }
                else {
                    if (temp.compareTo(smallest) < 0) smallest = temp;
                }
            }
        }
        return smallest;
    }

    private String rotateRight(String s, int shift) {
        int n = s.length();
        shift %= n;
        if (shift == 0) return s;
        return s.substring(n - shift) + s.substring(0, n - shift);
    }

    private String add(String s, int a, boolean oddIndexes){
        char[] chars = s.toCharArray();
        int start = oddIndexes ? 1 : 0;
        for (int i = start; i < chars.length; i += 2) {
            int digit = (chars[i] - '0' + a) % 10;
            chars[i] = (char) (digit + '0');
        }
        return new String(chars);
    }

    private int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (y == 0) return x == 0 ? 1 : x;
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }
}