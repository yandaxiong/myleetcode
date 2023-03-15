package com.xiong.top100;

/**
 * @author xiong
 * @Description 找出字符串中第一个匹配项的下标
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1 。
 *
 * @date 2023-02-28 8:56 下午
 */
public class a28_find_the_index_of_first_occurrence_in_string {
    public static void main(String[] args) {
        System.out.println(strStr("leetcodetcotco","tco"));
    }
    public static  int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }
}
