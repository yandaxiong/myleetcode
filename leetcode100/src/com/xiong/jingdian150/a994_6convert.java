package com.xiong.jingdian150;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-07-30-17:49
 */
public class a994_6convert {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR");
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int num = numRows + numRows - 2;
        StringBuffer sb = new StringBuffer();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int tmpIndex = i;
                while (tmpIndex < charArray.length) {
                    sb.append(charArray[tmpIndex]);
                    tmpIndex = tmpIndex + num;
                }
            } else {
                int tmpIndex = i;
                while (tmpIndex < charArray.length) {
                    sb.append(charArray[tmpIndex]);
                    int i1 = tmpIndex + (num - tmpIndex % num) - tmpIndex % num;
                    if(i1<charArray.length) {
                        sb.append(charArray[i1]);
                    }
                    tmpIndex = tmpIndex + num;
                }
            }
        }
        return sb.toString();
    }
}