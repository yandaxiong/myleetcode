package com.xiong.top100;

import java.util.Arrays;

/**
 * @author xiong
 * @Description 正则表达式匹配
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * @date 2023-02-22 11:22 上午
 */
public class a10_regular_expression_matching {
    public static void main(String[] args) {
        String s = "a";
        String p = ".*..a*";
        System.out.println(isMatch(s,p));
    }
    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][]  booleanArray = new boolean[sLen+1][pLen+1];
        //在结果上添加空格
        booleanArray[0][0] = true;
        for (int i=1;i<sLen+1;i++){
            booleanArray[i][0] = false;
        }
        for (int column=1;column<=pLen;column++){
            char c = p.charAt(column-1);
            if(column>1) {
                if (c == '*') {
                    booleanArray[0][column] = booleanArray[0][column - 2];
                } else {
                    booleanArray[0][column] = false;
                }
            }else {
                booleanArray[0][column] = c == '*';
            }
        }


        for (int row=1;row<=sLen;row++){
            char sChar = s.charAt(row - 1);
            for (int column=1;column<=pLen;column++){
                char pChar = p.charAt(column - 1);
                if(pChar == sChar  || pChar == '.'){
                    booleanArray[row][column] = booleanArray[row-1][column-1];
                }else if (pChar == '*'){
                    if(booleanArray[row][column - 2]){
                        booleanArray[row][column] = true;
                    }else {
                        char prev = p.charAt(column-2);
                        if (prev== sChar || prev == '.') {
                            booleanArray[row][column] = booleanArray[row - 1][column]; // * 前面的字符出现多次
                        }
                    }
                }else {
                    booleanArray[row][column] = false;
                }
            }

        }
        return booleanArray[sLen][pLen];
    }


        public boolean isMatch2(String s, String p) {

            boolean table[][] = new boolean[s.length() + 1][p.length() + 1];

            table[0][0] = true;

            for (int col=1; col<table[0].length; col++) {
                char ch = p.charAt(col-1);
                if (col > 1) {
                    if (ch == '*') {
                        table[0][col] = table[0][col-2];
                    } else {
                        table[0][col] = false;
                    }

                } else {
                    if (ch == '*') {
                        table[0][col] = true;
                    }
                }
            }

            for (int row=1; row<table.length; row++) {
                char ch1 = s.charAt(row-1);
                for (int col=1; col<table[row].length; col++) {
                    char ch2 = p.charAt(col-1);
                    if (ch1==ch2 || ch2 == '.') {
                        table[row][col] = table[row-1][col-1];
                    } else if (ch2 == '*') {
                        if(col > 1) {
                            if (table[row][col-2]) {
                                table[row][col] = true; // * 前面的字符出现0次
                            } else {
                                char prev = p.charAt(col-2);
                                if (prev== ch1 || prev == '.') {
                                    table[row][col] = table[row - 1][col]; // * 前面的字符出现多次
                                }
                            }

                        }
                    }
                }
            }


            boolean lastRow[] = table[table.length-1];
            return lastRow[lastRow.length-1];
        }


}
