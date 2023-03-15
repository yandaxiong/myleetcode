package com.xiong.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiong
 * @Description 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @date 2023-02-24 11:39 上午
 */
public class a17_letter_combinations_of_a_phone_number {
    public static void main(String[] args) {
       String digits = "23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);

    }

    public static  List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); //准备结果存储空间
        if (digits == null || digits.length() == 0) {  // 如果字符为空或长度为0，返回[]
            return ans;
        }
        String[] letter = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // 建立数字到字母映射
        StringBuilder path = new StringBuilder(); //存储回溯过程中的字符
        process(digits, 0, letter, ans, path); // 回溯过程
        return ans;
    }
    public static  void process(String digits, int index, String[] letter, List<String> ans, StringBuilder path) {
        if (index == digits.length()) { //回溯边界条件
            ans.add(path.toString());  //如果到了digits的终点，把回溯过程中的字符转化为字符串并添加到结果
            return;
        }
        int pos = digits.charAt(index) - '2'; // 得到数字到字母映射的对应位置
        for (int i = 0; i < letter[pos].length(); i++) { // 遍历当前数字对应的字母
            path.append(letter[pos].charAt(i)); // 把单个字母添加到路径
            process(digits, index + 1, letter, ans, path); // 进入下一个数字，
            path.delete(index, index + 1); //去除路径中上面添加的字母
        }

    }



    public static List<String> letterCombinations2(String digits) {
        if("".equals(digits)){
            return new ArrayList<>();
        }
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a","b","c"});
        map.put('3', new String[]{"d","e","f"});
        map.put('4', new String[]{"g","h","i"});
        map.put('5', new String[]{"j","k","l"});
        map.put('6', new String[]{"m","n","o"});
        map.put('7', new String[]{"p","q","r","s"});
        map.put('8', new String[]{"t","u","v"});
        map.put('9', new String[]{"w","x","y","z"});
        int len = 1;
        for (int i = 0;i<digits.length();i++){
            len = map.get(digits.charAt(i)).length * len;
        }
        ArrayList<String> resultList = new ArrayList<>();
        int circulationNum = len;
        for (int i = 0;i<digits.length();i++){
            char c = digits.charAt(i);
            String[] strings = map.get(c);
            circulationNum = circulationNum/strings.length;//一个字符每次插入几个
            int  cirNUm = len/(circulationNum*strings.length);//循环插入多少次
//            System.out.println(circulationNum);
//            System.out.println(cirNUm);
            for (int cirIndex=0;cirIndex<cirNUm;cirIndex++){ //需要循环插入多少次
                for (int j=0;j<strings.length;j++){ //每次循环插入什么字符
                    for (int insertIndex=0;insertIndex<circulationNum;insertIndex++){ //每次循环插入单个字符多少次
                        if(i!=0){
                            int num = (cirIndex*strings.length*circulationNum)+(j*circulationNum)+insertIndex;
                            System.out.println(num);
                            resultList.set(num,resultList.get(num)+strings[j]);
                        }else {
                            resultList.add(strings[j]);
                        }

                    }
                }
            }
        }
        return  resultList;
    }



}
