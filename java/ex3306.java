class ex3306 {
    public long countOfSubstrings(String word, int k){
        if (word.length() < k+5) return 0;
        return atLeast(k, word)-atLeast(k+1, word);
    }

    private long atLeast (int k, String word){
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

    private static final boolean[] IS_VOWEL = new boolean[128];

    static {
        for (char c : "aeiou".toCharArray()) {
            IS_VOWEL[c] = true;
        }
    }

    public static void main(String[] args) {
        ex3306 myo = new ex3306();
        System.out.println(myo.countOfSubstrings("ieaouqqieaouqq", 1));
    }
}