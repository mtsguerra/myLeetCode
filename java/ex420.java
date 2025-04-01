import java.util.*;

class ex420{
    public int strongPasswordChecker(String password) {

        int ans = 0;

        int nCharacters = password.length();
        int nLower = 0;
        int nUpper = 0;
        int nDigit = 0;

        List<String> sequences = new ArrayList<>();
        StringBuilder crrSequence = new StringBuilder();
        for (char ch : password.toCharArray()) {
            if (crrSequence.isEmpty() || crrSequence.charAt(0)==ch) crrSequence.append(ch);
            else{
                if (crrSequence.charAt(0) != ch){
                    if (crrSequence.length() >= 3) sequences.add(crrSequence.toString());
                    crrSequence = new StringBuilder();
                    crrSequence.append(ch);
                }
            }
            if (Character.isAlphabetic(ch)){
                if (Character.isLowerCase(ch)) nLower++;
                else nUpper++;
            }
            else if (Character.isDigit(ch)) nDigit++;
        }
        if (crrSequence.length() >= 3) sequences.add(crrSequence.toString());
        // first do the > 20
        // after that remove the characters from the sequences, if a sequence
        // gets to .size() < 3, remove it from the list

        // second iterate through the list to replace the characters
        // that still need to be altered

        // third check if we need to add characters
        Collections.sort(sequences, Collections.reverseOrder());
        int replaced = 0;
        for (String str : sequences){
            int toAlter= str.length() / 3;
            ans+= toAlter;
            if (nCharacters < 6) {
                nCharacters += Math.min(toAlter, 6-nCharacters);
                toAlter -= Math.min(toAlter, 6-nCharacters);
            }
            replaced += toAlter;
            while (toAlter > 0 && (nLower == 0 || nUpper == 0 || nDigit == 0)){
                if (nLower == 0) nLower++;
                else if (nUpper == 0) nUpper++;
                else if (nDigit == 0) nDigit++;
                toAlter--;
            }
        }
        while (nCharacters < 6) {
            if (nLower == 0) nLower++;
            else if (nUpper == 0) nUpper++;
            else if (nDigit == 0) nDigit++;
            nCharacters++;
            ans++;
        }
        while (nCharacters > 20){
            nCharacters--;
            ans++;
        }
        while (nLower == 0 || nUpper == 0 || nDigit == 0) {
            if (nLower == 0) nLower++;
            else if (nUpper == 0) nUpper++;
            else if (nDigit == 0) nDigit++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ex420 myObj = new ex420();
        String str = "bbaaaaaaaaaaaaaaacccccc";
        int p = myObj.strongPasswordChecker(str);
        System.out.println("The result is: " + p);
    }
}