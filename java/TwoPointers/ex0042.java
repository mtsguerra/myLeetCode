import java.util.*;

class ex0042{
    public int trap(int[] height) {

        int count = 0;

        Stack<Integer> monotonicStack = new Stack<>();
        Stack<Integer> indexesStacks = new Stack<>();
        monotonicStack.push(height[height.length-1]);
        indexesStacks.push(height.length-1);

        for (int i = height.length - 2; i >= 0; i--) {
            int h = monotonicStack.peek();
            while (!monotonicStack.isEmpty() && height[i] > monotonicStack.peek()) {
                h = monotonicStack.pop();
                indexesStacks.pop();
                if (!monotonicStack.isEmpty()) {
                    int lastIndex = indexesStacks.peek() - i - 1;
                    count += (Math.min(height[i], monotonicStack.peek()) - h) * lastIndex;
                }
                // if (!monotonicStack.isEmpty())
            }
            monotonicStack.push(height[i]);
            indexesStacks.push(i);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        ex0042 myo = new ex0042();
        System.out.println(myo.trap(height));
    }
}