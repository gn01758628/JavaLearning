package leetcode.Tree;

import java.util.*;

public class No_0226 {
    //  題目大意：
    //  翻轉二元樹(Binary Tree)

    //  解題思路：
    //  利用遞迴左右交換

    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempRight = root.right;
        root.right = invertBinaryTree(root.left);
        root.left = invertBinaryTree(tempRight);
        return root;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode root = new TreeNode(4, left, right);
        int[] rootArr = root.getArrayBFS();
        int[] invertRootArr = invertBinaryTree(root).getArrayBFS();
        System.out.println(Arrays.toString(rootArr));
        System.out.println(Arrays.toString(invertRootArr));
    }
}
