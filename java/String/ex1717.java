import java.util.*;

class ex1717 {

    public int maximumGain(String s, int x, int y) {
        char firstChar = x >= y ? 'a' : 'b';
        char secondChar = x >= y ? 'b' : 'a';
        int priorityScore = Math.max(x,y);
        int secondPriorityScore = Math.min(x,y);

        int score = 0;

        boolean[] toRemove = new boolean[s.length()];
        Stack<Integer> stck = new Stack<>();

        for (int i= 0;i < s.length(); i++) {
            if (s.charAt(i) == firstChar) stck.push(i);
            else if (!stck.isEmpty() && s.charAt(i) == secondChar) {
                score += priorityScore;
                toRemove[i] = true;
                toRemove[stck.pop()] = true;
            }
            else stck.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove[i]) sb.append(s.charAt(i));
        }
        stck.clear();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == secondChar) stck.push(i);
            else if (!stck.isEmpty() && sb.charAt(i) == firstChar) {
                score += secondPriorityScore;
                stck.pop();
            }
            else stck.clear();
        }
        return score;
    }

    /*public int maximumGain(String s, int x, int y) {

        char firstChar = x >= y ? 'a' : 'b';
        int priorityScore = Math.max(x,y);
        char secondChar = x >= y ? 'b' : 'a';
        int secondPriorityScore = Math.min(x,y);

        int score = 0;
        Stack<Character> stck1 = new Stack<>();
        Stack<Character> stck2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != firstChar && s.charAt(i) != secondChar) {
                if (stck1.isEmpty()) continue;
                while (!stck1.isEmpty() && !stck2.isEmpty()) {
                    score += secondPriorityScore;
                    stck1.pop();
                    stck2.pop();
                }
                stck2.clear();
                stck1.clear();
                continue;
            }
            if (stck1.isEmpty()) {
                stck1.push(s.charAt(i));
            }
            else if (stck1.peek() == s.charAt(i)) {
                if (s.charAt(i) == firstChar) stck1.push(s.charAt(i));
                else {
                    if (!stck2.isEmpty()) {
                        stck2.pop();
                        score += priorityScore;
                    }
                    else stck1.push(s.charAt(i));
                }
            }
            else{
                if (s.charAt(i) == secondChar){
                    stck1.pop();
                    score += priorityScore;
                }
                else {
                    stck2.push(s.charAt(i));
                }
            }
        }
        while (!stck1.isEmpty() && !stck2.isEmpty()) {
            score += secondPriorityScore;
            stck1.pop();
            stck2.pop();
        }
        return score;
    }*/

    public static void main(String[] args) {
        ex1717 solution = new ex1717();
        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;
        int result = solution.maximumGain(s, x, y);
        System.out.println("Maximum Gain: " + result); // Expected output: 14
    }
}