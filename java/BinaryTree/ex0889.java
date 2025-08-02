public class ex0889 {
    /**
     * Given two integer arrays preorder and postorder where preorder is the
     * preorder traversal of a binary tree and postorder is the postorder
     * traversal of the same tree, construct and return the binary tree.
     *
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(n) for storing the tree nodes.
     *
     * @param preorder Preorder traversal of the binary tree
     * @param postorder Postorder traversal of the binary tree
     * @return The root node of the constructed binary tree
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        // Find the index of next element (preorder[preStart + 1]) in postorder
        // This will help us determine the left subtree size
        int leftRootIdx = -1;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                leftRootIdx = i;
                break;
            }
        }
        // Calculate size of left subtree
        int leftSubtreeSize = leftRootIdx - postStart + 1;
        // Recursively construct left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize,
                postorder, postStart, leftRootIdx);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd,
                postorder, leftRootIdx + 1, postEnd - 1);
        return root;
    }

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

}