package com.xiong.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiong
 * @Description 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @date 2023-03-01 8:46 下午
 */
public class a32_longest_valid_parentheses {
    public static void main(String[] args) {
        a32_longest_valid_parentheses a32 = new a32_longest_valid_parentheses();
        System.out.println(a32.longestValidParentheses3("()(())"));

    }
//      0 1 2 3
//      ( ( ) )
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i=1;i<s.length();i++){
            if(')'==s.charAt(i)){
                if('(' == s.charAt(i-1)){
                    dp[i] = i>=2?dp[i-2]+2:2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (  (i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0  ) + 2;
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxans;
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses(String s) {
        int oldLength = s.length();
        ArrayList<Boolean> booleans = new ArrayList<>();
        for (int i=0;i<oldLength;i++){
            booleans.add(false);
        }
        LinkedList<String[]> list = new LinkedList<>();
        for (int i=0;i<oldLength;i++){
            char c = s.charAt(i);
            if('('==c){
                list.addLast(new String[]{"(",i+""});
            }else {
                if(list.size()>0 && "(".equals(list.getLast()[0])){
                    booleans.set(i,true);
                    booleans.set(Integer.parseInt(list.getLast()[1]) ,true);
                    list.removeLast();
                }
            }
        }
        int maxLen = 0;
        int tmpLen = 0;
        for (Boolean aBoolean : booleans) {
            if (aBoolean) {
                tmpLen++;
            } else {
                tmpLen = 0;
            }
            maxLen = Math.max(maxLen, tmpLen);
        }
        return maxLen;
    }
}
