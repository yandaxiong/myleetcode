package com.xiong.jingdian150;

import java.util.ArrayDeque;

/**
 * @author xiong
 * @create 2025-08-13-19:47
 */
public class g2_71simplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
    public static String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals("..")){
                if(stack.size()>0){
                    stack.pop();
                }
            }else if(split[i].equals(".") || split[i].equals("")){
                continue;
            }else {
                stack.push(split[i]);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append("/"+stack.pollLast());
        }
        if(stringBuffer.length() == 0){
            return "/";
        }
        return stringBuffer.toString();
    }

}
