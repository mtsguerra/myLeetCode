class ex420{
    public int strongPasswordChecker(String password) {

        int ans = 0;

        int nCharacters = password.length();

        // counts :
            // 0 -> lower case
            // 1 -> upper case
            // 2 -> digit
            // 3 -> sequences
            // 4 -> number of Characters
        int[] counts = new int[5];
        counts[4] = nCharacters;

        // keeps track of the sizes of the sequences
        // max possible sequence being the string size
        int[] sequences = new int[nCharacters+1];

        // keeps track of the sequences that are multiple of 3, 3+1 and 3+2
        int[] threePlus = new int[3];

        // keeps track of the sequences that are multiple of 3
        // max possible being the string size / 3
        int[] multByThree = new int[(nCharacters+1)/3+1];

        countSequences(password, sequences, threePlus, multByThree,
                counts);

        // first do the > 20
        // after that remove the characters from the sequences, if a sequence
        // gets to .size() < 3, remove it from the list

        // second iterate through the list to replace the characters
        // that still need to be altered

        // third check if we need to add characters
        int toEliminate = 0;
        if (counts[4] > 20) {
            toEliminate = counts[4] - 20;
            deleteCharacters(sequences, threePlus, multByThree,
                    counts, toEliminate);
        }
        ans+= toEliminate;
        // now we need to replace the characters
        if (counts[3] > 0) {
            int replaced = replaceCharacters(sequences, counts);
            ans += replaced;
        }
        if (counts[4] < 6) {
            int added = addCharacters(counts);
            ans += added;
        }
        if (counts[0] == 0 || counts[1] == 0 || counts[2] == 0) {
            int completed = completePassword(counts);
            ans += completed;
        }
        return ans;
    }

    private void countSequences (String password, int[] sequences,
                                 int[] threePlus, int[] multByThree,
                                 int[] counts) {
        Character crrChar = null;
        int sizeSequence = 0;
        for (char ch : password.toCharArray()) {
            if (crrChar==null || ch==crrChar){
                sizeSequence++;
                crrChar = ch;
            }
            else{
                if (sizeSequence >= 3){
                    counts[3]++;
                    sequences[sizeSequence]++;
                    threePlus[sizeSequence%3]++;
                    if (sizeSequence % 3 == 0){
                        multByThree[sizeSequence/3]++;
                    }
                }
                crrChar = ch;
                sizeSequence = 1;
            }
            if (Character.isAlphabetic(ch)){
                if (Character.isLowerCase(ch)) counts[0]++;
                else counts[1]++;
            }
            else if (Character.isDigit(ch)) counts[2]++;
        }
        if (sizeSequence >= 3){
            counts[3]++;
            sequences[sizeSequence]++;
            threePlus[sizeSequence%3]++;
            if (sizeSequence % 3 == 0){
                multByThree[sizeSequence/3]++;
            }
        }
    }

    private void deleteCharacters(int[] sequences, int[] threePlus,
                                  int[] multByThree, int[] counts,
                                  int toEliminate) {
        while (toEliminate > 0 && counts[3] > 0){
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
            sequences[pos]--;
            threePlus[pos%3]--;
            toEliminate--;
            if (pos<=3) counts[3]--;
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
    }

    private int replaceCharacters(int [] sequences, int[] counts) {
        int replaced = 0;
        while (counts[3] > 0){
            int pos = -1;
            for (int i=3;i<sequences.length;i++){
                if (sequences[i] > 0){
                    pos = i;
                    break;
                }
            }
            if (pos == -1) break;
            int toChange = pos/3;
            replaced += toChange;
            if (counts[4] < 6){
                counts[4]+= Math.min (toChange, 6 - counts[4]);
            }
            sequences[pos]--;
            if (pos <= 3) counts[3]--;
            while (toChange > 0 && (counts[0] == 0 || counts[1] == 0 || counts[2] == 0)){
                if (counts[0] == 0) counts[0]++;
                else if (counts[1] == 0) counts[1]++;
                else if (counts[2] == 0) counts[2]++;
                toChange--;
            }
        }
        return replaced;
    }

    private int addCharacters(int[] counts) {
        int added = 0;
        while (counts[4] < 6) {
            if (counts[0] == 0) counts[0]++;
            else if (counts[1] == 0) counts[1]++;
            else if (counts[2] == 0) counts[2]++;
            counts[4]++;
            added++;
        }
        return added;
    }

    private int completePassword(int[] counts) {
        int complete = 0;
        while (counts[0] == 0 || counts[1] == 0 || counts[2] == 0) {
            if (counts[0] == 0) counts[0]++;
            else if (counts[1] == 0) counts[1]++;
            else if (counts[2] == 0) counts[2]++;
            complete++;
        }
        return complete;
    }

    public static void main(String[] args) {
        ex420 myObj = new ex420();
        String str = "QQQQQ";
        int p = myObj.strongPasswordChecker(str);
        System.out.println("The result is: " + p);
    }
}