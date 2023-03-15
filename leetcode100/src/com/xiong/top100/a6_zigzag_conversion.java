package com.xiong.top100;

import java.util.ArrayList;

/**
 * @author xiong
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * @date 2023-02-21 5:30 下午
 */
public class a6_zigzag_conversion {

    public static void main(String[] args) {
        String paypalishiring = convert("A", 1);
        System.out.println(paypalishiring);

    }
    public static  String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int len = (numRows-1)*2;
        StringBuilder result = new StringBuilder();
        int length = s.length();
        ArrayList<int[]> list = indexList(len);
        for (int[] array:list){
            if(array.length==1){
                int j = array[0];
                while (j < length) {
                    result.append(s.charAt(j));
                    j = j + len;
                }
            }else {
                int j1 = array[0];
                int j2 = array[1];
                while (j1 < length){
                    result.append(s.charAt(j1));
                    j1 = j1 +len;
                    if(j2 < length){
                        result.append(s.charAt(j2));
                        j2 = j2 +len;
                    }
                }
            }
        }
        return  result.toString();
    }

    public static ArrayList<int[]> indexList(int len){
        ArrayList<int[]> resultList = new ArrayList<>();
        int[] first = {0};
        resultList.add(first );
        for (int i = 1;i<len/2;i++){
            int[] array = {i,len-i};
            resultList.add(array);
        }
        resultList.add(new int[]{len/2});
        return  resultList;

    }
}
