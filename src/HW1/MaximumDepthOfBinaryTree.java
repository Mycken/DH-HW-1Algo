package HW1;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4))
                , new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode root_1 = new TreeNode(1, new TreeNode(2),
                new TreeNode(2, null, new TreeNode(3)));
        TreeNode root_2 = new TreeNode(1);//, new TreeNode(1), new TreeNode(1));
        TreeNode root_3 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null)
                , new TreeNode(2, null, new TreeNode(3)));

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root_3));

    }

    public int maxDepth(TreeNode root) {
        if(root!=null)
            return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
        else
            return 0;
    }
}
