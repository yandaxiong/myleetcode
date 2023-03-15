package com.xiong.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiong
 * @Description 串联所有单词的子串
 * 给定一个字符串s和一个字符串数组words。words中所有字符串 长度相同。
 *
 * s中的 串联子串 是指一个包含words中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，"cdefab"，"efabcd"， 和"efcdab" 都是串联子串。"acdbef" 不是串联子串，因为他不是任何words排列的连接。
 * 返回所有串联字串在s中的开始索引。你可以以 任意顺序 返回答案。
 *
 * @date 2023-03-01 4:17 下午
 */

public class a30_substring_with_concatenation_of_all_words {
    public static void main(String[] args) {
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring("wordgoodgoodgoodbestword",words));
    }
    public static  List<Integer> findSubstring(String s, String[] words) {
        int oneWordsLen = words[0].length();
        int allWordsLen = oneWordsLen * words.length;
        ArrayList<Integer> resultList = new ArrayList<>();
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String word:words){
            wordsMap.put(word, wordsMap.get(word)==null?1:wordsMap.get(word)+1);
        }

        sfor:for (int i=0;i<=s.length()-allWordsLen;i++){
            HashMap<String, Integer> tmpMap = new HashMap<>(wordsMap);
            for (int j=0;j<allWordsLen;j=j+oneWordsLen){
                String subStr = s.substring(i+j, i+j+oneWordsLen);
                if(tmpMap.get(subStr)==null) continue sfor;
                if(tmpMap.get(subStr)-1<0){
                    continue sfor;
                }else {
                    tmpMap.put(subStr, tmpMap.get(subStr)-1);
                }
            }
            resultList.add(i);
        }
        return resultList;
    }

}
