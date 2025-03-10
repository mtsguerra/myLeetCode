public class ex1014 {

    //----------------------------------------------------------//
    //while iterating through the array, we keep track of the max value that can be
    //obtained with values[i] + i, and with that we compare with the subsequent values 
    //that would form the current score, by the formula maxLeft + values[i] - i, keeping
    //track of the biggest score possible

    public int maxScoreSightseeingPair(int[]values){
        int maxScore = Integer.MIN_VALUE;
        int leftV = values[0];
        for (int i=1;i<values.length;i++){
            maxScore = Math.max(maxScore, leftV+values[i]-i);
            leftV = Math.max(leftV, values[i]+i);
        }
        return maxScore;
    }

    //----------------------------------------------------------//

    /*public int maxScoreSightseeingPair(int[] values) {
        int maxScore =0;
        for (int i=0;i<values.length;i++){
            int n1 = values[i];
            for (int j=i+1;j<values.length;j++){
                int currentScore = values[i] + values[j] + i - j;
                maxScore = Math.max(maxScore, currentScore);
            }
        }
        return maxScore;
    }*/

    public static void main(String[] args) {
        ex1014 myo = new ex1014();
        int[] ns = {1,3,5};
        System.out.println(myo.maxScoreSightseeingPair(ns));
    }

}