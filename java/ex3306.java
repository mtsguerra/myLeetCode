/**
 * ex3306 : in this exercise the problem proposed is to count the number of substrings of a given string that have at
 * least 1 of each vowel and exactly k consonants.
 */
class ex3306 {

    // This array will be used to check if a character is a vowel or not, its size is 128 so i can cover all the
    // ASCII characters.
    private static final boolean[] IS_VOWEL = new boolean[128];

    static {
        for (char c : "aeiou".toCharArray()) {
            IS_VOWEL[c] = true;
        }
    }

    /**
     * The solution that I chose revolves around using the sliding window technique to count the number of substrings
     * that have at least k consonants and those that have least k+1 consonants, then by doing the difference
     * between them, I can find the exactly number of k consonants. In mathematical terms, subs>=k+1 - subs>=k =
     * subs==k.
     * @param word The original String.
     * @param k Number of consonants.
     * @return The number of substrings that have at least 1 of each vowel and exactly k consonants.
     */
    public long countOfSubstrings(String word, int k){
        if (word.length() < k+5) return 0;
        return atLeast(k, word)-atLeast(k+1, word);
    }

    /**
     * Using the sliding window technique to count the number of substrings that have at least k consonants.
     * @param k Number of consonants.
     * @param word The original String.
     * @return The number of substrings that have at least k consonants.
     */
    private long atLeast (int k, String word){
        // This array will be used to count the number of each vowel in the current window.
        int[] vowelCount = new int[5];
        int consonant = 0;
        long result = 0;
        int left=0;
        int vowelTypes = 0;
        for (int right =0; right<word.length(); right++){
            if (IS_VOWEL[word.charAt(right)]){
                if(vowelCount[vowelToIndex(word.charAt(right))]++==0){
                    vowelTypes++;
                }
            }
            else {
                consonant++;
            }
            while (vowelTypes==5 && consonant >= k) {
                result += word.length() - right;
                if (IS_VOWEL[word.charAt(left)]){
                    if (--vowelCount[vowelToIndex(word.charAt(left))]==0){
                        vowelTypes--;
                    }
                }
                else {
                    consonant--;
                }
                left++;
            }
        }
        return result;
    }

    /**
     * This method will return the index of a vowel in a zero-based indexes of "aeiou".
     * @param ch The vowel to be checked.
     * @return The index of the vowel in the zero-based indexes of "aeiou".
     */
    public static int vowelToIndex(char ch) {
        return switch (Character.toLowerCase(ch)) {
            case 'a' -> 0;
            case 'e' -> 1;
            case 'i' -> 2;
            case 'o' -> 3;
            case 'u' -> 4;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        ex3306 myo = new ex3306();
        System.out.println(myo.countOfSubstrings("ieaouqqieaouqq", 1));
    }
}