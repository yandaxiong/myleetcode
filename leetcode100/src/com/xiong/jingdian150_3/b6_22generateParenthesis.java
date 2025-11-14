package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-14-17:20
 */
public class b6_22generateParenthesis {
    public static void main(String[] args) {
        b6_22generateParenthesis b622generateParenthesis = new b6_22generateParenthesis();
        System.out.println(b622generateParenthesis.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        backtrack(n*2,left,right,"",result);
        return result;
    }
    private void backtrack(int n,int left,int right,String tmp,List<String> result){
        char[] chars = new char[]{'(',')'};
        if(left<right){
            return;
        }
        if(left+right>=n){
            if(left==right) result.add(tmp);
            return;
        }
        for (char c:chars){
            if (c=='(')  left++;
            if (c==')') right++;
            backtrack(n,left,right,tmp+c,result);
            if (c=='(')  left--;
            if (c==')') right--;
        }
    }
}
