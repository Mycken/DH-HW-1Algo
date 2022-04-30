package HW1;

import java.util.TreeSet;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int array[] = {-10, -3, 0, 5, 9};
        int array_1[] = {0,1,2,3,4,5};


        System.out.println(new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(array_1));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode tree = new TreeNode(nums[nums.length / 2]);
        int current = nums.length - 1;
        int length = nums.length;
        while (length != 1) {
            current = current / 2;
            tree = doInsert(tree,nums[current]);
            length = current + 1;
        }
//        tree.val = nums[nums.length / 2];
//        for (int i = nums.length / 2 - 1; i >= 0; i--) {
//            tree = doInsert(tree,nums[i]);
//        }
//        for (int i = nums.length /2 + 1; i < nums.length; i++) {
//            tree = doInsert(tree,nums[i]);
//        }
        return tree;
    }
    private static int getHalfOfArrayIndex(int current){
        return current / 2;
    }

    private static TreeNode doInsert(TreeNode node, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (x < node.val) {
            node.left = doInsert(node.left, x);
        } else if (x > node.val) {
            node.right = doInsert(node.right, x);
        }
        return node;
    }
    public static TreeNode add(int val, TreeNode current){
        if(val< current.val){
            if(current.left==null){
                current.left = new TreeNode(val);
            } else if(current.left != null)
                current.left = add(val, current.left);
        }
        else{
            if(current.right==null){
                current.right = new TreeNode(val);
            }
            else if(current.right != null)
                current.right = add(val,current.right);
        }

        return current;
    }
}