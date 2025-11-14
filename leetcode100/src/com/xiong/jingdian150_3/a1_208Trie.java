package com.xiong.jingdian150_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author xiong
 * @create 2025-11-13-13:45
 */
public class a1_208Trie {
    public static void main(String[] args) {
        a1_208Trie a1208Trie = new a1_208Trie();
        a1208Trie.insert("apple");
        System.out.println(a1208Trie.search("apple"));
        System.out.println(a1208Trie.search("app"));
        System.out.println(a1208Trie.startsWith("app"));
        a1208Trie.insert("app");
        System.out.println(a1208Trie.search("app"));
    }
    private a1_208Trie[] children;
    private boolean isEnd;
    public a1_208Trie() {
        children = new a1_208Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        a1_208Trie node = this;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index]==null){
                node.children[index] = new a1_208Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return  searchStr(word,true);
    }

    public boolean startsWith(String prefix) {
        return  searchStr(prefix,false);
    }

    @Override
    public String toString() {
        return "a1_208Trie{" +
                "children=" + Arrays.toString(children) +
                ", isEnd=" + isEnd +
                '}';
    }

    private boolean searchStr(String str,boolean isEnd){
        a1_208Trie node = this;
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int index = c - 'a';
            if(node.children[index]!=null ){
                node = node.children[index];
            }else {
                return  false;
            }
        }
        if (isEnd){
            return node.isEnd;
        }else {
            return  true;
        }
    }

}
