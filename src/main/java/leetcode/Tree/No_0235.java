package leetcode.Tree;

public class No_0235 {
    //  題目大意：
    //  給定一個二元搜尋樹 Binary search tree(BST)
    //  找到該樹中兩個指定節點的最近共同祖先 Lowest common ancestor(LCA)
    //  LCA：

    //  解題思路：
    //  理解BST的定義：
    //  1.若任意節點的左子樹不空，則"左子樹"上所有節點的值均"小於"它的"根節點"的值
    //  2.若任意節點的右子樹不空，則"右子樹"上所有節點的值均"大於"它的"根節點"的值
    //  3.任意節點的左、右子樹也分別為二元搜尋樹

    // 迴圈
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    // 遞迴
    public static TreeNode lowestCommonAncestorByRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorByRecursion(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorByRecursion(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode no4 = new TreeNode(4,new TreeNode(3),new TreeNode(5));
        TreeNode no2 = new TreeNode(2,new TreeNode(0),no4);
        TreeNode no8 = new TreeNode(8,new TreeNode(7),new TreeNode(9));
        TreeNode root = new TreeNode(6,no2,no8);
        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(lowestCommonAncestor);
    }
}
