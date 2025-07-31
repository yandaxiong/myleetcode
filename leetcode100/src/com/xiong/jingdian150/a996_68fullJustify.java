package com.xiong.jingdian150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @create 2025-07-30-20:44
 */
public class a996_68fullJustify {
    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        a996_68fullJustify justify = new a996_68fullJustify();
        System.out.println(justify.fullJustify(words,16));
    }
    public  List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        int tmp = maxWidth+1;
        for (int i = 0; i < words.length; i++) {
            tmp = tmp - words[i].length()-1;
            if (tmp >= 0) {
                strings.add(words[i]);
            }else {
                String s = this.strsTostring(strings, maxWidth,false);
                resultList.add(s);
                strings = new ArrayList<>();
                strings.add(words[i]);
                tmp = maxWidth-words[i].length();
            }
            if (i == words.length-1) {
                String s = this.strsTostring(strings, maxWidth,true);
                resultList.add(s);
            }
        }

        return resultList;
    }
    public String  strsTostring(List<String> words, int maxWidth,boolean last) {
        StringBuffer stringBuffer = new StringBuffer(maxWidth);

        if(words.size() == 1 || last) {
            int tmp = maxWidth;
            for (int i = 0; i < words.size()-1; i++) {
                stringBuffer.append(words.get(i)+" ");
                tmp = tmp - words.get(i).length()-1;
            }
            stringBuffer.append(words.get(words.size()-1));
            tmp = tmp - words.get(words.size()-1).length();
            for(int i = 0; i < tmp; i++){
                stringBuffer.append(" ");
            }
            return stringBuffer.toString();
        };
        int len = maxWidth;
        for (int i = 0; i < words.size(); i++) {
            len = len - words.get(i).length();
        }
        int pingjun = len / (words.size()-1);
        int ewait = len % (words.size()-1);

        for (int i = 0; i < words.size(); i++) {
            stringBuffer.append(words.get(i));
            if(i!=words.size()-1) {
                for (int j = 0; j < pingjun; j++) {
                    stringBuffer.append(" ");
                }
            }
            if (ewait > 0) {
                stringBuffer.append(" ");
                ewait--;
            }
        }
        return stringBuffer.toString();
    }

}
