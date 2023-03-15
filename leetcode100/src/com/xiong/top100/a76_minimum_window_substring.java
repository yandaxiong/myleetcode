package com.xiong.top100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xiong
 * @Description  最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class a76_minimum_window_substring {
    public static void main(String[] args) {
        a76_minimum_window_substring a76MinimumWindowSubstring = new a76_minimum_window_substring();
        String s = "a", t = "a";
        System.out.println(a76MinimumWindowSubstring.minWindow(s,t));

    }
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

//    ------------------------------------------------------------------------------------------------------------------------------------------
    public String minWindow2(String s, String t) {
        if(t.length() > s.length() || s.equals("") || t.equals("")){
            return "";
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (Character c: t.toCharArray()){
            Integer orDefault = tMap.getOrDefault(c, 0)+1;
            tMap.put(c,orDefault);
        }

        int left=0,right=t.length()-1;
        int minLeft=-1,minRight=-1,minSize=s.length()+1;
        while (right<s.length()){
            String subStr = s.substring(left, right+1);
            int i = compare(subStr,tMap);
            if(i>0){
                right++;
            }else {
                if(right-left+1<minSize){
                    minSize = right-left+1;
                    minLeft = left;
                    minRight = right;
                }
                left++;
            }
        }
        return minLeft>=0?s.substring(minLeft,minRight+1):"";
    }
    public int compare(String subStr,HashMap<Character, Integer> tMap) {
        HashMap<Character, Integer> tmpMap = new HashMap<>(tMap);
        for (Character sChar: subStr.toCharArray()){
            if(tmpMap.get(sChar)!=null){
                if(tmpMap.get(sChar)==1){
                    tmpMap.remove(sChar);
                    if(tmpMap.size()==0 ){
                       return 0;
                    }
                }else {
                    tmpMap.put(sChar,tmpMap.get(sChar)-1);
                }
            }
        }
        return tmpMap.size();
    }

}
