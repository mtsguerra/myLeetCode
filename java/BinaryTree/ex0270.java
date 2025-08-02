public class ex0270 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * Given the root of a binary search tree and a target value, return the value in the BST
     * that is closest to the target value.
     *
     * Time Complexity: O(h) where h is the height of the tree.
     * Space Complexity: O(h) for the recursion stack.
     *
     * @param root Root node of the binary search tree
     * @param target Target value to find the closest value to
     * @return The value in the BST that is closest to the target value
     */
    public int closestValue(TreeNode root, double target) {
        return closestValueRecursive(root, target, Integer.MAX_VALUE);
    }
    public int closestValueRecursive(TreeNode root, double target, int closest){
        if (root == null) return closest;
        if (Math.abs(target - root.val) < Math.abs(target - closest)) closest = root.val; 
        if (root.val > target) return closestValueRecursive(root.left, target, closest);
        else return closestValueRecursive(root.right, target, closest);
    }
    public static void main(String[] args) {
        
    }
}

