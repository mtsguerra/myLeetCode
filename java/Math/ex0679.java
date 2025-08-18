import java.util.*;

class ex0679 {
    /**
     * Given an array of integers cards, you have to judge whether you can get 24 by using all the cards.
     * You can use the four basic operations: addition, subtraction, multiplication, and division.
     * You can use parentheses to change the order of operations.
     *
     * Time Complexity: O(n^2 * 2^n), where n is the number of cards.
     * Space Complexity: O(n), where n is the number of cards.
     *
     * @param cards an array of integers representing the cards
     * @return true if you can get 24, false otherwise
     */
    public boolean judgePoint24(int[] cards) {
        for (int i=0; i < cards.length; i++) {
            for (int j=0; j<cards.length; j++) {
                if (i == j) continue;
                List<Double> temp = new ArrayList<>();
                double dCard1 = cards[i];
                double dCard2 = cards[j];
                for (int k=0; k<cards.length; k++) {
                    if (k != i && k != j) temp.add((double) cards[k]);
                }
                temp.add(dCard1 + dCard2);
                if (withParentheses(temp))return true;
                temp.remove(temp.size() - 1);

                temp.add(dCard1 - dCard2);
                if (withParentheses(temp))return true;
                temp.remove(temp.size() - 1);

                temp.add(dCard1 * dCard2);
                if (withParentheses(temp))return true;
                temp.remove(temp.size() - 1);

                if (cards[j] != 0) {
                    temp.add(dCard1 / dCard2);
                    if (withParentheses(temp)) return true;
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return false;
    }
    public boolean withParentheses(List<Double> acc){
        if (acc.size() == 1) return Math.abs(acc.get(0) - 24) < 1e-6;
        for (int i=0;i<acc.size();i++){
            double dCard1 = acc.get(i);
            for (int j=0;j<acc.size();j++){
                if (i == j) continue;
                double dCard2 = acc.get(j);
                List<Double> temp = new ArrayList<>(acc);
                temp.remove(Math.max(i,j));
                temp.remove(Math.min(i,j));

                temp.add(dCard1 + dCard2);
                if (withParentheses(temp)) return true;
                temp.remove(temp.size() - 1);

                temp.add(dCard1 - dCard2);
                if (withParentheses(temp)) return true;
                temp.remove(temp.size() - 1);

                temp.add(dCard1 * dCard2);
                if (withParentheses(temp)) return true;
                temp.remove(temp.size() - 1);

                if (dCard2 != 0) {
                    temp.add(dCard1 / dCard2);
                    if (withParentheses(temp)) return true;
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return false;
    }
}