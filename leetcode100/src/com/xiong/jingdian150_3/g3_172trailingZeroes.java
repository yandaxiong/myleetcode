package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-25-15:40
 */
public class g3_172trailingZeroes {
    public static void main(String[] args) {
        g3_172trailingZeroes g3_172trailingZeroes = new g3_172trailingZeroes();
        System.out.println(g3_172trailingZeroes.trailingZeroes(30));
    }
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i=5;i<=n;i=i+5){
            for (int j=i;j%5==0;j=j/5){
                count++;
            }
        }
        return count;
    }
}
