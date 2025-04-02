class ex420{

    private static final int LOWERCASE_COUNT = 0;
    private static final int UPPERCASE_COUNT = 1;
    private static final int DIGIT_COUNT = 2;
    private static final int SEQUENCE_COUNT = 3;
    private static final int PASSWORD_LENGTH = 4;

    /**
     * Given a String password, return the minimum number of operations to
     * make a password strong.
     *
     * A password is considered strong if:
     * 1. It has at least 6 characters and at most 20 characters.
     * 2. It must contain at least one lowercase letter, at least one
     * uppercase and at least one digit.
     * 3. It must not contain three repeating characters in a row
     *
     * The possible operations are:
     * 1. Insert one character (any position)
     * 2. Delete one character
     * 3. Replace one character
     *
     * @param password the password to be checked
     * @return the minimum number of operations to make the password strong
     */
    public int strongPasswordChecker(String password) {

        int totalOperations = 0;
        // passwordInfos array keeps track of:
            // [0] -> lowercase letters count
            // [1] -> uppercase letters count
            // [2] -> digits count
            // [3] -> sequencesLengths of 3+ characters count
            // [4] -> length of the password
        int[] passwordInfos = new int[5];
        passwordInfos[PASSWORD_LENGTH] = password.length();

        // Keeps track of the lengths of the sequencesLengths.
            // sequencesLengths[i] = number of sequencesLengths of length i
        int[] sequencesLengths = new int[passwordInfos[PASSWORD_LENGTH]+1];

        // Keeps track of sequencesLengths grouped by remainder when divided by 3
            // remainderGroups[0] = count of sequencesLengths with length % 3 == 0
            // remainderGroups[1] = count of sequencesLengths with length % 3 == 1
            // remainderGroups[2] = count of sequencesLengths with length % 3 == 2
        int[] remainderGroups = new int[3];

        // Keeps track of occurrences of sequencesLengths with length % 3 == 0
            // sequencesDivisibleByThree[i] = count of sequencesLengths with length = 3*i
        int[] sequencesDivisibleByThree = new int[(passwordInfos[PASSWORD_LENGTH]+1)/3+1];

        countSequences(password, sequencesLengths, remainderGroups, sequencesDivisibleByThree,
                passwordInfos);

        // Step 1: Handle passwords longer than 20 characters
        int toEliminate = 0;
        if (passwordInfos[PASSWORD_LENGTH] > 20) {
            toEliminate = passwordInfos[PASSWORD_LENGTH] - 20;
            deleteCharacters(sequencesLengths, remainderGroups, sequencesDivisibleByThree,
                    passwordInfos, toEliminate);
        }
        totalOperations += toEliminate;

        // Step 2: Replace characters to break the undesired sequencesLengths
        if (passwordInfos[SEQUENCE_COUNT] > 0) {
            int charsReplaced = replaceCharacters(sequencesLengths,
                    passwordInfos);
            totalOperations += charsReplaced;
        }

        // Step 3: Add characters to meet the minimum length requirement
        if (passwordInfos[PASSWORD_LENGTH] < 6) {
            int charsAdded = addCharacters(passwordInfos);
            totalOperations += charsAdded;
        }

        // Step 4: Complete the password by adding missing character types
        if (passwordInfos[LOWERCASE_COUNT] == 0 || passwordInfos[UPPERCASE_COUNT] == 0 || passwordInfos[DIGIT_COUNT] == 0) {
            int typesCompleted = completePassword(passwordInfos);
            totalOperations += typesCompleted;
        }
        return totalOperations;
    }

    /**
     * Analyses the password and counts:
     * 1. Character types (lowercase, uppercase, digits)
     * 2. SequencesLengths of 3+ characters
     *
     * @param password the password to be analysed
     * @param sequencesLength array to keep track of the lengths of the sequencesLengths
     * @param remainderGroups array to keep track of the sequencesLengths grouped by remainder
     * @param seqsDivisibleByThree array to keep track of the sequencesLengths with length % 3 == 0
     * @param passwordInfos array to keep track of the character types count
     */
    private void countSequences (String password, int[] sequencesLength,
                                 int[] remainderGroups,
                                 int[] seqsDivisibleByThree,
                                 int[] passwordInfos) {
        Character crrChar = null;
        int seqLen = 0;
        for (char ch : password.toCharArray()) {
            if (crrChar==null || ch==crrChar){
                seqLen++;
                crrChar = ch;
            }
            else{
                if (seqLen >= 3){
                    passwordInfos[SEQUENCE_COUNT]++;
                    sequencesLength[seqLen]++;
                    remainderGroups[seqLen %3]++;
                    if (seqLen % 3 == 0){
                        seqsDivisibleByThree[seqLen /3]++;
                    }
                }
                crrChar = ch;
                seqLen = 1;
            }
            if (Character.isAlphabetic(ch)){
                if (Character.isLowerCase(ch)) passwordInfos[LOWERCASE_COUNT]++;
                else passwordInfos[UPPERCASE_COUNT]++;
            }
            else if (Character.isDigit(ch)) passwordInfos[DIGIT_COUNT]++;
        }
        if (seqLen >= 3){
            passwordInfos[SEQUENCE_COUNT]++;
            sequencesLength[seqLen]++;
            remainderGroups[seqLen %3]++;
            if (seqLen % 3 == 0){
                seqsDivisibleByThree[seqLen /3]++;
            }
        }
    }

    /**
     * Deletes characters from the password to meet the maximum length requirement
     * and prioritizes deletions that breaks a sequence efficiently (Greedy).
     *
     * @param sequencesLengths array to keep track of the lengths of the sequencesLengths
     * @param remainderGroups array to keep track of the sequencesLengths grouped by remainder
     * @param seqsDivisibleByThree array to keep track of the sequencesLengths with length % 3 == 0
     * @param passwordInfos array to keep track of the character types count
     * @param toEliminate number of characters to be deleted
     */
    private void deleteCharacters(int[] sequencesLengths,
                                  int[] remainderGroups,
                                  int[] seqsDivisibleByThree,
                                  int[] passwordInfos,
                                  int toEliminate) {
        while (toEliminate > 0 && passwordInfos[SEQUENCE_COUNT] > 0){
            int seqPosition =-1;
            // If possible find a sequenceLengths of length % 3 == 0, because
            // in the case of deleting a character from that sequence the
            // number of replacements later on will be reduced by one
            if (remainderGroups[0] >0){
                for (int i=0;i<seqsDivisibleByThree.length;i++){
                    if (seqsDivisibleByThree[i] > 0){
                        seqPosition = i*3;
                        break;
                    }
                }
            }
            // If not, try to find the most close sequenceLength to a
            // multiple of 3
            else {
                int startPoint;
                if (remainderGroups[1]>0) startPoint=4;
                else startPoint = 5;
                for (int i=startPoint;i<sequencesLengths.length;i+=3){
                    if (sequencesLengths[i] > 0){
                        seqPosition = i;
                        break;
                    }
                }
            }

            sequencesLengths[seqPosition]--;
            remainderGroups[seqPosition %3]--;
            toEliminate--;

            if (seqPosition <=3) passwordInfos[SEQUENCE_COUNT]--;
            else {
                sequencesLengths[seqPosition -1]++;
                remainderGroups[(seqPosition -1)%3]++;
                if ((seqPosition -1) % 3 == 0){
                    seqsDivisibleByThree[(seqPosition -1)/3]++;
                }
            }
            if (seqPosition % 3 == 0){
                seqsDivisibleByThree[seqPosition /3]--;
            }
        }
    }

    /**
     * Replaces characters to break the repeating sequences, as well as try
     * to use these replacements to meet the minimum length requirement and
     * satisfy the missing character types.
     *
     * @param sequencesLengths array to keep track of the lengths of the sequencesLengths
     * @param passwordInfos array to keep track of the character types count
     * @return the number of characters replaced
     */
    private int replaceCharacters(int [] sequencesLengths,
                                  int[] passwordInfos) {
        int replaced = 0;
        while (passwordInfos[SEQUENCE_COUNT] > 0){
            int pos = -1;
            for (int i=3;i<sequencesLengths.length;i++){
                if (sequencesLengths[i] > 0){
                    pos = i;
                    break;
                }
            }
            if (pos == -1) break;

            int nToChange = pos/3;
            replaced += nToChange;

            if (passwordInfos[PASSWORD_LENGTH] < 6){
                // only add the minimum number of characters needed to reach 6
                passwordInfos[PASSWORD_LENGTH]+= Math.min (nToChange,
                        6 - passwordInfos[PASSWORD_LENGTH]);
            }

            sequencesLengths[pos]--;
            passwordInfos[SEQUENCE_COUNT]--;

            while (nToChange > 0 && (passwordInfos[LOWERCASE_COUNT] == 0 || passwordInfos[UPPERCASE_COUNT] == 0 || passwordInfos[DIGIT_COUNT] == 0)){
                if (passwordInfos[LOWERCASE_COUNT] == 0) passwordInfos[LOWERCASE_COUNT]++;
                else if (passwordInfos[UPPERCASE_COUNT] == 0) passwordInfos[UPPERCASE_COUNT]++;
                else if (passwordInfos[DIGIT_COUNT] == 0) passwordInfos[DIGIT_COUNT]++;
                nToChange--;
            }
        }
        return replaced;
    }

    /**
     * Adds characters to the password to meet the minimum length requirement
     * and tries to use these characters to satisfy the missing character types.
     *
     * @param passwordInfos array to keep track of the character types count
     * @return the number of characters added
     */
    private int addCharacters(int[] passwordInfos) {
        int added = 0;
        while (passwordInfos[PASSWORD_LENGTH] < 6) {
            if (passwordInfos[LOWERCASE_COUNT] == 0) passwordInfos[LOWERCASE_COUNT]++;
            else if (passwordInfos[UPPERCASE_COUNT] == 0) passwordInfos[UPPERCASE_COUNT]++;
            else if (passwordInfos[DIGIT_COUNT] == 0) passwordInfos[DIGIT_COUNT]++;
            passwordInfos[PASSWORD_LENGTH]++;
            added++;
        }
        return added;
    }

    /**
     * Makes sure the password satisfies the requirements to be strong
     *
     * @param passwordInfos array to keep track of the character types count
     * @return the number of character types added
     */
    private int completePassword(int[] passwordInfos) {
        int complete = 0;
        while (passwordInfos[LOWERCASE_COUNT] == 0 || passwordInfos[UPPERCASE_COUNT] == 0 || passwordInfos[DIGIT_COUNT] == 0) {
            if (passwordInfos[LOWERCASE_COUNT] == 0) passwordInfos[LOWERCASE_COUNT]++;
            else if (passwordInfos[UPPERCASE_COUNT] == 0) passwordInfos[UPPERCASE_COUNT]++;
            else if (passwordInfos[DIGIT_COUNT] == 0) passwordInfos[DIGIT_COUNT]++;
            complete++;
        }
        return complete;
    }

    // Test method
    public static void main(String[] args) {
        ex420 myObj = new ex420();
        String str = "QQQQQ";
        int p = myObj.strongPasswordChecker(str);
        System.out.println("The result is: " + p);
    }
}