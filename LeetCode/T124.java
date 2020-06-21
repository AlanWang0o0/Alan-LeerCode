package LeetCode;

public class T124 {
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args){
        TreeNode a = new TreeNode(-10);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        maxGain(a);
        System.out.println(maxSum);
    }

    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int temp = node.val + leftGain + rightGain;

        // 更新最大值
        maxSum = Math.max(maxSum, temp);

        // 返回节点的最大值
        return node.val + Math.max(leftGain, rightGain);
    }
}
