package LeetCode;

import java.util.*;

/***
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 */
public class T15 {
    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> t:result) {
            System.out.println(t);
        }
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> result = new LinkedHashSet<>();
//        Arrays.sort(nums);     // 先排序，再利用Set去重
//        for (int i = 0; i < nums.length-2; i++) {
//            if(nums[i]>0) break;
//            else if(i>=1 && nums[i] == nums[i-1]) continue;  // 去重
//            for (int j = i+1; j < nums.length-1; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    if(nums[i]+nums[j]+nums[k] == 0){
//                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(result);
//    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len<3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i]>0)   break;  // 按照升序排列，当i>0时，不可能凑0
            else if(i>0 && nums[i] == nums[i-1])    continue;  // 去重，两个相同的数直接跳过
            int L = i+1;
            int R = len-1;
            while(R>L){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i] , nums[L] , nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if(sum<0) L++;   // sum比0小，L往右移动，加大
                else R--;   // sum比0大，R往左移，减小
            }
        }
        return res;
    }
}
