package LeetCode;

public class T14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    // 自己写的，纵向比较
//    public static String longestCommonPrefix(String[] strs) {
//        if(strs == null || strs.length==0)  return "";
//        int minLen = Integer.MAX_VALUE;
//        for(String s:strs){
//            if(s.length()<minLen)   minLen = s.length();
//        }
//        for(int i=0 ; i<minLen ; i++){
//            char temp = strs[0].charAt(i);
//            for(String s:strs){
//                if(s.charAt(i) != temp) return strs[0].substring(0,i);
//            }
//        }
//        return strs[0].substring(0,minLen);
//    }

    // 纵向比较优化
//    public static String longestCommonPrefix(String[] strs) {
//        if(strs == null || strs.length==0)  return "";
//
//        int length = strs[0].length();
//        for (int i = 0; i < length; i++) {
//            char temp = strs[0].charAt(i);
//            for(int j=1 ; j<strs.length ; j++){
//                if(i == strs[j].length() || strs[j].charAt(i) != temp)  return strs[0].substring(0,i);
//            }
//        }
//        return strs[0];
//    }

    // 分治法
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        } else {
//            return longestCommonPrefix(strs, 0, strs.length - 1);
//        }
//    }
//    public static String longestCommonPrefix(String[] strs,int start,int end){
//        if (start == end) {
//            return strs[start];
//        } else {
//            int mid = (end - start) / 2 + start;
//            String lcpLeft = longestCommonPrefix(strs, start, mid);
//            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
//            return commonPrefix(lcpLeft, lcpRight);
//        }
//    }
//    public static String commonPrefix(String lcpLeft, String lcpRight) {
//        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
//        for (int i = 0; i < minLength; i++) {
//            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
//                return lcpLeft.substring(0, i);
//            }
//        }
//        return lcpLeft.substring(0, minLength);
//    }

    // 二分法
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
