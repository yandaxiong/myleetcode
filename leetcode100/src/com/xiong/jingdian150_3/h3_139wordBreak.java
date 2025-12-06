package com.xiong.jingdian150_3;

import java.util.*;

/**
 * @author xiong
 * @create 2025-11-25-20:42
 */
public class h3_139wordBreak {
    public static void main(String[] args) {
        h3_139wordBreak h3_139wordBreak = new h3_139wordBreak();
        System.out.println(h3_139wordBreak.wordBreak("leetcode", List.of("leet", "code")));
//        System.out.println(h3_139wordBreak.wordBreak("applepenapple", List.of("apple", "pen")));
//        System.out.println(h3_139wordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
