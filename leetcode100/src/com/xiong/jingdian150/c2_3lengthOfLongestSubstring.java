package com.xiong.jingdian150;

import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-07-31-20:36
 */
public class c2_3lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0) return 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < charArray.length; end++) {
            while (set.contains(charArray[end])) {
                max = Math.max(max, end - start );
                set.remove(charArray[start]);
                start++;
            }
                set.add(charArray[end]);
        }
        max = Math.max(max, set.size());
        return max;
    }
}
