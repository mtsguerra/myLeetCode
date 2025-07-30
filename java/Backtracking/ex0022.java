import java.util.*;

class ex0022{
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Time Complexity: O(4^n / sqrt(n)) where n is the number of pairs of parentheses.
     * Space Complexity: O(n) for the recursion stack and result storage.
     *
     * @param n Number of pairs of parentheses
     * @return List of all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open,
                           int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        else {
            if (open < max) {
                current.append('(');
                backtrack(result, current, open + 1, close, max);
                current.deleteCharAt(current.length() - 1);
            }
            if (close < open) {
                current.append(')');
                backtrack(result, current, open, close + 1, max);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}