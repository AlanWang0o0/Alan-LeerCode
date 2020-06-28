package LeetCode;

public class T209_Minimum_Size_Subarray_Sum {
    public static void main(String[] args){
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    // 半暴力
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)    return 0;
        int res = nums.length+1;
        int sum = 0;
        // 遍历每个数
        for (int i = 0; i < nums.length; i++) {
            sum=0;
            // 遍历时，遍历长度限定为当前最短长度
            for (int j = i; j < i+res && j<nums.length ; j++) {
                sum += nums[j];
                if(sum >= s){
                    res = j-i+1;
                    break;
                }
            }
        }
        return res==nums.length+1?0:res;
    }

    // 滑动窗口
//    public static int minSubArrayLen(int s, int[] nums){
//        int len = nums.length;
//        int left = 0, right = 0, sum = 0;
//        int res = Integer.MAX_VALUE;
//        while(right<len){
//            sum += nums[right++];
//            while(sum >= s){
//                res = Math.min(right-left,res); // 更新结果
//                sum -= nums[left++];    // 减去最左值，并且left++
//            }
//        }
//        return res == Integer.MAX_VALUE?0:res;
//    }
}
