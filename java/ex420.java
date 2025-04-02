import java.util.*;

class ex420{
    public int strongPasswordChecker(String password) {

        int ans = 0;

        int nCharacters = password.length();
        int nLower = 0;
        int nUpper = 0;
        int nDigit = 0;

        // size of the sequences -> how many sequences with that size
        int[] sequences = new int[password.length()+1];
        int nSequences =0;
        int[] threePlus = new int[3];
        // size of the sequences that are multiple of 3 -> how many sequences with that size
        int[] multByThree = new int[(password.length()+1)/3+1];
        Character crrChar = null;
        int sizeSequence = 0;
        for (char ch : password.toCharArray()) {
            if (crrChar==null || ch==crrChar){
                sizeSequence++;
                crrChar = ch;
            }
            else{
                if (ch != crrChar){
                    if (sizeSequence >= 3){
                        nSequences++;
                        sequences[sizeSequence]++;
                        threePlus[sizeSequence%3]++;
                        if (sizeSequence % 3 == 0){
                            multByThree[sizeSequence/3]++;
                        }
                    }
                    crrChar = ch;
                    sizeSequence = 1;
                }
            }
            if (Character.isAlphabetic(ch)){
                if (Character.isLowerCase(ch)) nLower++;
                else nUpper++;
            }
            else if (Character.isDigit(ch)) nDigit++;
        }
        if (sizeSequence >= 3){
            nSequences++;
            sequences[sizeSequence]++;
            threePlus[sizeSequence%3]++;
            if (sizeSequence % 3 == 0){
                multByThree[sizeSequence/3]++;
            }
        }
        // first do the > 20
        // after that remove the characters from the sequences, if a sequence
        // gets to .size() < 3, remove it from the list

        // second iterate through the list to replace the characters
        // that still need to be altered

        // third check if we need to add characters
        int toEliminate = 0;
        if (nCharacters > 20) toEliminate = nCharacters - 20;
        while (toEliminate > 0 && nSequences > 0){
            int pos=-1;
            if (threePlus[0] >0){
                for (int i=0;i<multByThree.length;i++){
                    if (multByThree[i] > 0){
                        pos = i*3;
                        break;
                    }
                }
            }
            else {
                int startPoint = -1;
                if (threePlus[1]>0) startPoint=4;
                else startPoint = 5;
                for (int i=startPoint;i<sequences.length;i+=3){
                    if (sequences[i] > 0){
                        pos = i;
                        break;
                    }
                }
            }
            ans++;
            sequences[pos]--;
            threePlus[pos%3]--;
            toEliminate--;
            if (pos<=3) nSequences--;
            else {
                sequences[pos-1]++;
                threePlus[(pos-1)%3]++;
                if ((pos-1) % 3 == 0){
                    multByThree[(pos-1)/3]++;
                }
            }
            if (pos % 3 == 0){
                multByThree[pos/3]--;
            }
        }
        // in case there's still characters to eliminate
        ans+= toEliminate;
        // now we need to replace the characters
        while (nSequences > 0){
            int pos = -1;
            for (int i=3;i<sequences.length;i++){
                if (sequences[i] > 0){
                    pos = i;
                    break;
                }
            }
            if (pos == -1) break;
            int toChange = pos/3;
            ans += toChange;
            if (nCharacters < 6){
                nCharacters+= Math.min (toChange, 6 - nCharacters);
            }
            sequences[pos]--;
            if (pos <= 3) nSequences--;
            while (toChange > 0 && (nLower == 0 || nUpper == 0 || nDigit == 0)){
                if (nLower == 0) nLower++;
                else if (nUpper == 0) nUpper++;
                else if (nDigit == 0) nDigit++;
                toChange--;
            }
        }
        while (nCharacters < 6) {
            if (nLower == 0) nLower++;
            else if (nUpper == 0) nUpper++;
            else if (nDigit == 0) nDigit++;
            nCharacters++;
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
        String str = "QQQQQ";
        int p = myObj.strongPasswordChecker(str);
        System.out.println("The result is: " + p);
    }
}