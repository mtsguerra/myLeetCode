public class ex1422 {
    public int maxScore(String s) {
        // initialize all the score variables
        int leftScore=0;
        int rightScore=0;
        int totalScore=0;
        // iterate through the whole string to calculate the right score 
        for (char ch: s.toCharArray()){
            if (ch=='1') rightScore++;
        }
        // now iterate through the string until s.size-1
        for (int i=0;i<s.length()-1;i++){
            char ch = s.charAt(i);
            // adequate the current scores
            if (ch=='1') rightScore--;
            else if (ch=='0') leftScore++;
            // get the max
            totalScore = Math.max(totalScore, leftScore+rightScore);
        }
        return totalScore;
    }
    public static void main(String[] args) {
        String s = "00";
        ex1422 myo = new ex1422();
        System.out.println(myo.maxScore(s));
    }
}
