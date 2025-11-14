package com.xiong.jingdian150_2;

import java.math.BigInteger;

/**
 * @author xiong
 * @create 2025-11-11-20:22
 */
public class g1_67addBinary {
    public static void main(String[] args) {
        g1_67addBinary g167addBinary = new g1_67addBinary();
        System.out.println(g167addBinary.addBinary("11", "1"));
    }
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
                ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
