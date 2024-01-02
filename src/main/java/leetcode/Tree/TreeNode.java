package leetcode.Tree;

import java.util.*;

public class TreeNode {
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

    public int[] getArrayBFS() {
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
        return String.valueOf(val);
    }
}
