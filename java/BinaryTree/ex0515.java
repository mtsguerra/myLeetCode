import java.util.LinkedList;
import java.util.List;

public class ex0515 {
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

    //--------------------------------------------------------------------//
    // in this one i create a public list where the biggest value will be stored, and create
    // a recursive method to iterate through the tree, using the root, and the currentLevel
    // of the current root, setting the value of lv[currentLevel] in the max of the current
    // biggest value and the current value, in the case of the current level not existing
    // on the lv i will be adding the level with the current value as the biggest, and in the
    // end recursive call the same method with root.left and root.right, adding 1 to the current
    // level to both calls

    public List<Integer> lv;

    public List<Integer> largestValues(TreeNode root) {
        lv = new LinkedList<>();
        largestValuesRecursive(root, 0);
        return lv;
    }
    public void largestValuesRecursive(TreeNode root, int currentLevel){
        if (root==null) return;
        if (currentLevel >= lv.size()) lv.add(root.val);
        else lv.set(currentLevel,  Math.max(lv.get(currentLevel), root.val));
         
        largestValuesRecursive(root.left, currentLevel+1);
        largestValuesRecursive(root.right, currentLevel+1);
    }

    //--------------------------------------------------------------------//
}
