import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

public class ex1028 {
    public TreeNode recoverFromPreorder(String traversal) {
        int i=0;
        List<int[]> pairs = new ArrayList<>();
        while (i < traversal.length()){
            int level =0;
            while (i < traversal.length() && traversal.charAt(i)=='-'){
                level++;
                i++;
            }
            int val = 0;
            while (i < traversal.length() && traversal.charAt(i)!='-') {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            pairs.add(new int[]{val,level});
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(pairs.get(0)[0]);
        stack.push(root);
        for (int j=1;j < pairs.size();j++){
            int value = pairs.get(j)[0];
            int level = pairs.get(j)[1];
            while (stack.size()>level){
                stack.pop();
            }
            TreeNode node = new TreeNode (value);
            TreeNode parent = stack.peek();
            if (parent.left==null){
                parent.left = node;
            }
            else parent.right = node;
            stack.push(node);
        }

        return root;
    }
}*/