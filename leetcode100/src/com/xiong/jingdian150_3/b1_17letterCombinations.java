package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-14-11:03
 */
public class b1_17letterCombinations {
    public static void main(String[] args) {
        b1_17letterCombinations b117letterCombinations = new b1_17letterCombinations();
        System.out.println(b117letterCombinations.letterCombinations("22"));
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> numCharMap = new HashMap<>();
        numCharMap.put('2', new String[]{"a", "b", "c"});
        numCharMap.put('3', new String[]{"d", "e", "f"});
        numCharMap.put('4', new String[]{"g", "h", "i"});
        numCharMap.put('5', new String[]{"j", "k", "l"});
        numCharMap.put('6', new String[]{"m", "n", "o"});
        numCharMap.put('7', new String[]{"p", "q", "r", "s"});
        numCharMap.put('8', new String[]{"t", "u", "v"});
        numCharMap.put('9', new String[]{"w", "x", "y", "z"});
        List<String> result = new ArrayList<>();
        StringBuilder tmpStr = new StringBuilder();
        char[] charArray = digits.toCharArray();
        backtrack(charArray,0,tmpStr,result ,numCharMap);
        return result;
    }

    private void backtrack(char[] digits,int num, StringBuilder tmpStr, List<String> result,HashMap<Character, String[]> numCharMap ) {
        if(num>=digits.length){
            result.add(tmpStr.toString());
            return;
        }
        char key = digits[num];
        String[] strings = numCharMap.get(key);
        for (String s : strings) {
            tmpStr.append(s);
            backtrack(digits,num + 1, tmpStr, result, numCharMap);
            tmpStr.deleteCharAt(tmpStr.length() - 1);
        }
    }



}
