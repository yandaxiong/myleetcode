package com.xiong.jingdian150;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-08-13-20:33
 */
public class g4_150evalRPN {
    public static void main(String[] args) {
        String[] tokens = { "2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("+");
        hashSet.add("-");
        hashSet.add("*");
        hashSet.add("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        int res = Integer.parseInt(tokens[0]);
        for (String token : tokens) {
            if (!hashSet.contains(token)) {
                stack.push(token);
            }else {
                int pop2 = Integer.parseInt(stack.pop()) ;
                int pop1 = Integer.parseInt(stack.pop()) ;
                if(token.equals("*")){res = pop1*pop2 ; }
                if(token.equals("-")){res = pop1-pop2 ; }
                if(token.equals("+")){res = pop1+pop2 ; }
                if(token.equals("/")){res = pop1/pop2 ; }
                stack.push(res+"");
            }
        }
        return res;
    }
}
