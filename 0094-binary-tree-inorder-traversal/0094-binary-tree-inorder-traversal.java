import java.util.*;

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);   // Left
        result.add(node.val); // Root
        inorder(node.right);  // Right
    }
}
