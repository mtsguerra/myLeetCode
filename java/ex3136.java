import java.util.*;

class ex3136{

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