import java.util.*;

class ex3136{

    /**
     * Checks if a word is valid based on the following criteria:
     * 1. The word must be at least 3 characters long.
     * 2. It must contain at least one vowel and one consonant.
     * 3. It can only contain letters and digits (no special characters).
     *
     * Time Complexity: O(n) where n is the length of the word.
     * Space Complexity: O(1) since we are using a fixed amount of space for counters.
     *
     * @param word The word to be checked.
     * @return true if the word is valid, false otherwise.
     */
    public boolean isValid(String word) {
        if (word == null || word.length() <= 2) return false;
        int countVowels = 0;
        int countConsonants = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    countVowels++;
                } else {
                    countConsonants++;
                }
            }
            else if (Character.isDigit(ch)) {
                continue;
            }
            else return false;
        }
        return countVowels >= 1 && countConsonants >= 1;
    }

    public static void main(String[] args) {

    }
}