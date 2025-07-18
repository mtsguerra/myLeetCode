


public class ex0889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] postorder, int postStart, int postEnd) {
        // Base case: if invalid indices or empty array
        if (preStart > preEnd) {
            return null;
        }

        // Create root node from first element of preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // If only one node left
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