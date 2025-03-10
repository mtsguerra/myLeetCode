import java.util.Arrays;

public class ex2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] indxs = new int[s.length()];
                // Apply shifts using difference array technique
        for (int[] shft : shifts) {
            int start = shft[0];
            int end = shft[1];
            int direction = shft[2] == 1 ? 1 : -1;

            // Mark the start and end of the range
            indxs[start] += direction;
            if (end + 1 < s.length()) {
                indxs[end + 1] -= direction;
            }
        }

        // Calculate prefix sum to get the total shift for each character
        for (int i = 1; i < s.length(); i++) {
            indxs[i] += indxs[i - 1];
        }
        StringBuilder result = new StringBuilder();
        for (int i=0;i<s.length();i++){
            char current = (char) (s.charAt(i) + indxs[i]%26);
            result.append(current <= 'z' && current >= 'a' ? current : 
            (current > 'z') ? (char) ('a' + current - 'z'-1) :
            (char) ('z' + current - 'a'+1));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        int[][] sh = {
            {4, 8, 0},
            {4, 4, 0},
            {2, 4, 0},
            {2, 4, 0},
            {6, 7, 1},
            {2, 2, 1},
            {0, 2, 1},
            {8, 8, 0},
            {1, 3, 1}
        };
        String s = "xuwdbdqik";
        ex2381 myo = new ex2381();
        System.out.println(myo.shiftingLetters(s, sh));
    }
}
