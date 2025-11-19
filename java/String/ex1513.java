import java.util.*;

class ex1513 {
    private long gaussSum(int n) {
        return (long) n * (n + 1) / 2;
    }

    /**
     * Count the number of substrings with all characters '1'
     *
     * @param s binary string
     * @return number of substrings with all characters '1'
     */
    public int numSub(String s) {
        int currentStreak = 0;
        int mod = 1_000_000_007;
        long totalCases = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                currentStreak++;
            }
            else {
                if (currentStreak > 0) {
                    totalCases = (totalCases + gaussSum(currentStreak)) % mod;
                }
                currentStreak = 0;
            }
        }
        totalCases = (totalCases + gaussSum(currentStreak)) % mod;
        return (int) totalCases;
    }

    public static void main(String[] args) {
        ex1513 example = new ex1513();
        String s = "0110111";
        int result = example.numSub(s);
        System.out.println("Number of substrings: " + result);
    }
}