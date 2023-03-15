package com.xiong.top100;

/**
 * @author xiong
 * @Description . 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @date 2023-02-23 11:31 上午
 */
public class a14_longest_common_prefix {
    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        String s = longestCommonPrefix(a);
        System.out.println(s);
    }

    public static  String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        for (int i = 0;i<strs[0].length();i++ ){
            char c = strs[0].charAt(i);
            for (int j = 1;j<strs.length;j++){
                if(strs[j].length()<=i){
                    return  result.toString();
                }
                if(strs[j].charAt(i)!=c){
                    return  result.toString();
                }
            }
            result.append(c);
        }
        return  result.toString();
    }
}
