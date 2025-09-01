package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-08-13-20:44
 */
public class g5_224calculate {
    public static void main(String[] args) {
        System.out.println(calculate("1-(     -2)"));
    }
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.replace(" ", "");
        if (!s.contains("+") && !s.contains("-")) return Integer.parseInt(s.replace("(", "").replace(")", ""));
        ArrayDeque<String> stack = new ArrayDeque<>();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("+");
        hashSet.add("-");
        hashSet.add("(");
        hashSet.add(")");
        Integer result;
        char[] charArray = s.toCharArray();
        StringBuffer intBuff = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            String s1 = String.valueOf(charArray[i]);
            if (!hashSet.contains(s1)) {
                intBuff.append(charArray[i]);
            }else {
                if(!intBuff.isEmpty()) {
                    stack.push(intBuff.toString());
                }
                if (")".equals(s1)){
                    int tmpInt1 = 0 ;
                    int tmpInt2 = 0 ;
                    ArrayDeque<String> tmpStack = new ArrayDeque<>();
                    while (!stack.peek().equals("(")){
                        tmpStack.push(stack.pop() );
                    }
                    stack.pop();
                    if( hashSet.contains(tmpStack.getFirst())){
                        tmpInt1 = 0;
                    }else {
                        tmpInt1 = Integer.parseInt(tmpStack.pollFirst());
                    }

                    while (!tmpStack.isEmpty()){
                        String fuhao = tmpStack.pollFirst();
                        tmpInt2 = Integer.parseInt(tmpStack.pollFirst());
                        if ("+".equals(fuhao)){
                            tmpInt1 = tmpInt1 + tmpInt2;
                        }else if ("-".equals(fuhao)){
                            tmpInt1 = tmpInt1 - tmpInt2;
                        }
                    }
                    stack.push(Integer.toString(tmpInt1));

                }else{
                    stack.push(s1);
                }
                intBuff = new StringBuffer();
            }
        }
        if(!intBuff.isEmpty()) {
            stack.push(intBuff.toString());
        }
        if( hashSet.contains(stack.getLast())){
            result = 0;
        }else {
            result = Integer.parseInt(stack.pollLast());
        }
        int tmpInt2 = 0 ;
        while (!stack.isEmpty()){
            String fuhao = stack.pollLast();
            tmpInt2 = Integer.parseInt(stack.pollLast());
            if ("+".equals(fuhao)){
                result = result + tmpInt2;
            }else if ("-".equals(fuhao)){
                result = result - tmpInt2;
            }
        }
        return result;
    }
}
