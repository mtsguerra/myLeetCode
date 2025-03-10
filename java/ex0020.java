import java.util.Scanner;
import java.util.Stack;

public class ex0020 {

    //--------------------------------------------------------------------//
    // to start we have a condition that filters the sentences where only the even sized
    // could possibly be valid, we create a stack list where we will be storing the opening
    // cases ({,(,[) through a iterative loop of the string, where when the current char
    // == one of the closing cases we will be be checking the current stack, if the stack
    // is empty that would mean theres no opening case to complete this one, so return false,
    // now if its not empty we will be trying to find a opening pair to complete it, if
    // the first char that we get through .pop its not the ideal pair, we will return false,
    // because even if we find the pair that completes it after finding a wrong pair that would
    // mean that the sentence is composed of, for example, ([) which is not a valid sentence

    static Scanner input = new Scanner(System.in);

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stck = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '[' || ch == '{' || ch == '('){
                stck.push(ch);
            }
            else if (ch==')'){
                if (stck.isEmpty()) return false;
                if (stck.pop() != '(') return false;
            } 
            else if (ch==']'){
                if (stck.isEmpty()) return false;
                if (stck.pop() != '[') return false;
            }
            else if (ch=='}'){
                if (stck.isEmpty()) return false;
                if (stck.pop() != '{') return false;
            }          
        }
        return stck.isEmpty();
    }

    public void read(){
        String s = input.nextLine();
        System.out.println(isValid(s));
    }

    //--------------------------------------------------------------------//

    public static void main(String[] args) {
        ex0020 myo = new ex0020();
        myo.read();
    }
}
