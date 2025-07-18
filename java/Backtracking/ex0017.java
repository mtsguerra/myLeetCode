import java.util.*;

class ex0017{
    /**
     * Generates all possible letter combinations that a given string of digits could represent
     * based on the mapping of digits to letters on a telephone keypad.
     *
     * Time Complexity: O(4^n * n) where n is the length of the input digits
     * Space Complexity: O(n) for the recursion stack
     *
     * @param digits The input string representing digits from 2 to 9
     * @return A list of all possible letter combinations. Returns an empty list if the input is null or empty.
     */
    public List<String> letterCombinations(String digits) {
        Map<Integer, char[]> map = Map.of(
                2, new char[]{'a', 'b', 'c'},
                3, new char[]{'d', 'e', 'f'},
                4, new char[]{'g', 'h', 'i'},
                5, new char[]{'j', 'k', 'l'},
                6, new char[]{'m', 'n', 'o'},
                7, new char[]{'p', 'q', 'r', 's'},
                8, new char[]{'t', 'u', 'v'},
                9, new char[]{'w', 'x', 'y', 'z'}
        );
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder current = new StringBuilder();
        backtrack(digits, 0, current, map, result);
        return result;
    }
    private void backtrack(String digits, int index, StringBuilder current,
                           Map<Integer, char[]> map, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        char[] letters = map.get(digit);
        for (char letter : letters) {
            current.append(letter);
            backtrack(digits, index + 1, current, map, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}