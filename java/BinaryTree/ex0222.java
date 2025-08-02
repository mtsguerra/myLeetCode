public class ex0222 {
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
     * Given the root of a complete binary tree, return the number of the
     * nodes in the tree. A complete binary tree is a binary tree in which
     * every level, except possibly the last, is completely filled, and all
     * nodes are as far left as possible.
     *
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(h) where h is the height of the tree due to recursion stack.
     *
     * @param root Root node of the binary tree
     * @return Number of nodes in the complete binary tree
     */
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
               
}
