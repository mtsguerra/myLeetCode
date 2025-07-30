import java.util.*;

class ex0150{
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
     * The expression is given as an array of strings, where each string is either
     * an integer or one of the four operators: "+", "-", "*", "/".
     *
     * Time Complexity: O(n) where n is the number of tokens in the input array.
     * Space Complexity: O(n) for the stack used to evaluate the expression.
     *
     * @param tokens Array of strings representing the RPN expression
     * @return The result of the evaluated expression as an integer
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if (token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if (token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ex0150 myo = new ex0150();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = myo.evalRPN(tokens);
        System.out.println("Result of RPN evaluation: " + result); // Output: 9
    }

}