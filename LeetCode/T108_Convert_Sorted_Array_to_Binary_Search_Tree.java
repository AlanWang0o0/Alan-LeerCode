package LeetCode;

public class T108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public static void main(String[] args){
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        int index = nums.length / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = getNode(0,index-1,nums);
        root.right = getNode(index+1,nums.length-1,nums);
        return root;
    }

    public static TreeNode getNode(int l, int r, int[] nums){
        if(l>r) return null;
        int index = (l+r)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = getNode(l,index-1,nums);
        root.right = getNode(index+1,r,nums);
        return root;
    }

}
