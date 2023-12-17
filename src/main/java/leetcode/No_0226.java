package leetcode;

import java.util.*;

public class No_0226 {
    //  題目大意：
    //  翻轉二元樹(Binary Tree)

    //  解題思路：
    //  利用遞迴左右交換
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private int[] getArray() {
            //  廣度優先搜索算法(BFS,Breadth-First Search)
            //  BFS的基本步驟
            List<Integer> list = new ArrayList<>();
            //  1.初始化隊列，並將起點加入隊列當中
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            //  2.循環遍歷
            while (!queue.isEmpty()) {
                //  從頭部取出
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                //  從尾端加入
                if (currentNode.left!=null) queue.add(currentNode.left);
                if (currentNode.right!=null) queue.add(currentNode.right);
            }
            return list.stream().mapToInt(i -> i).toArray();
        }

        @Override
        public String toString() {
            return Arrays.toString(this.getArray());
        }
    }

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
        TreeNode top = new TreeNode(4, left, right);
        System.out.println(top);
        System.out.println(invertBinaryTree(top));
    }
}
