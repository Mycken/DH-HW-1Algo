package HW1;

import java.util.*;
import java.util.stream.IntStream;

public class SymmetricTree {
    static int k = 0;
    static List<Integer> listNode = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4))
                , new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        TreeNode root_3 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null)
                , new TreeNode(2, null, new TreeNode(3)));
        TreeNode root_1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        TreeNode root_2 = new TreeNode(1);//, new TreeNode(1), new TreeNode(1));

        System.out.println(new SymmetricTree().isSymmetric(root_2));
        listNode.forEach(System.out::print);

//        System.out.println(new SymmetricTree().isSymQueue(root));
        System.out.println(new SymmetricTree().isSymStack(root_3));
//        System.out.println(new SymmetricTree().isSymmetric(root));


    }

    public boolean isSymmetric(TreeNode root) {
//        k++;
        if (root != null) {
            isSymmetric(root.left);
            listNode.add(root.val);
            isSymmetric(root.right);
        }
        return IntStream.range(0, listNode.size() / 2)
                .noneMatch(i -> listNode.get(i) != listNode.get(listNode.size() - i - 1));

//            if (k == 1 & root.left == null || k == 1 & root.right == null) return true;
    }

    public boolean isSymStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            while(current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            list.add(current.val);
            if(current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
        System.out.println("Stack - ");
        list.forEach(System.out::print);
        return IntStream.range(0, list.size() / 2)
                .noneMatch(i -> list.get(i) != list.get(list.size() - i - 1));

    }


}
