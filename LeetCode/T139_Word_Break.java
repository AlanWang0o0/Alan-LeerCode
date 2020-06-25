package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T139_Word_Break {
    public static void main(String[] args){
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaa","aaaa")));
    }
    
    public static boolean wordBreak(String s, List<String> wordDict){
        Boolean[] dp = new Boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = false;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length() ; j++) {
                if(dp[i] && wordDict.contains(s.substring(i,j))){
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
