package LeetCode;

import java.util.Arrays;

public class T16_3Sum_Closest {
    public static void main(String[] args){
        System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3},-1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int min_diff = Integer.MAX_VALUE;   // 记录最小距离
        Arrays.sort(nums);  // 排序
        for (int i = 0; i < nums.length; i++) {
            if(i>1 && nums[i] == nums[i-1]) continue;   // 去重剪枝
            int left = i+1, right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(min_diff > Math.abs(target-sum)){
                    min_diff = Math.abs(target - sum);
                    res = sum;
                }
                if(min_diff == 0)   return target;      // 如果获得target，直接返回，不再循环
                if(left<right && sum < target) left++;  // 小于target，左指针右移
                if(left<right && sum > target) right--; // 大于target，右指针左移
            }

        }
        return res;
    }
}
