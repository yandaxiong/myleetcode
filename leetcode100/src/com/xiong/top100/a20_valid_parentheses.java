package com.xiong.top100;

import java.util.LinkedList;
import java.util.Map;

/**
 * @author xiong
 * @Description  有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @date 2023-02-27 2:48 下午
 */
public class a20_valid_parentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if(length%2!=0){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='}' || c==')' || c==']'){
                if(stack.size()==0){
                    return false;
                }
                Character c0 = stack.getLast();
                if(match(c0,c)){
                    stack.removeLast();
                    continue;
                }
            }
            stack.addLast(c);
        }
        return  stack.size()==0;
    }
    public static boolean match(Character a,Character b) {
        if(a=='{' && b=='}'){ return  true; }
        if(a=='(' && b==')'){ return  true; }
        if(a=='[' && b==']'){ return  true; }
        return  false;
    }
    public static boolean isValid2(String s) {
        int length = s.length();
        if(length%2!=0){
            return false;
        }
        int oldSize = s.length();
        int newSize = s.length()+2;
        while (oldSize!=newSize){
            oldSize = newSize;
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            newSize = s.length();
        }
        return s.length() == 0;
    }


}
