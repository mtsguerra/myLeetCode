public class ex2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // create a accumulative int[] to store how many vowel words
        // there are until that index, including itself
        int [] totalUntil = new int[words.length];
        // set the first one before starting the loop
        totalUntil[0] = isVowel(words[0].charAt(0)) &&
            isVowel(words[0].charAt(words[0].length()-1)) ? 1 : 0;
        // loop to fill the array
        for (int i = 1;i <words.length;i++){
            String currentWord = words[i];
            // test if the current word is a vowel word
            boolean isVowel = isVowel(currentWord.charAt(0)) &&
                isVowel(currentWord.charAt(currentWord.length()-1));
            // accumulate the last number + current
            totalUntil[i] = totalUntil[i-1] + (isVowel ? 1 : 0);
        }
        // array to return
        int[] result = new int[queries.length];
        for (int i=0;i<queries.length;i++){
            // start of the range
            int left = queries[i][0];
            // end of the range
            int right = queries[i][1];
            // if left == 0 just return the end of the range otherwise do the diff  
            result [i] = left == 0? totalUntil[right]: totalUntil[right] 
                - totalUntil[left-1];
        }
        return result;
    }
    // check if its vowel
    public boolean isVowel (char ch){
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        
            default:
                return false;
        }
    }
}
