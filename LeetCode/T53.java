package LeetCode;

// 最大子序和
public class T53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        // 动态规划：nums[i] = Math.max(nums[i],nums[i]+nums[i-1]);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i],nums[i]+nums[i-1]);
        }

        // 找出最大值
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
