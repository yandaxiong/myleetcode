package com.xiong.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @Description 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @date 2023-02-27 4:09 下午
 */
public class a22_generate_parentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        ArrayList<String> list0 = new ArrayList<>();
        list0.add("");
        arrayLists.add(0,list0);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("()");
        arrayLists.add(1,list1);
        for (int i=2;i<=n;i++){
            ArrayList<String> tmpList = new ArrayList<>();
            for (int q=0;q<=i-1;q++){ //中间有几个括号
                int p = i-1-q;
                ArrayList<String> qList = arrayLists.get(q);
                ArrayList<String> pList = arrayLists.get(p);
                for (String qstr:qList){
                    for (String pstr:pList){
                        tmpList.add("("+qstr+")"+pstr);
                    }
                }
            }
            arrayLists.add(i,tmpList);
        }
        return  arrayLists.get(n);
    }
}
