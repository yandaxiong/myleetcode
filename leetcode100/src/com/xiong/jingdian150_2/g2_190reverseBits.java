package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-11-12-10:56
 */
public class g2_190reverseBits {
    public static void main(String[] args) {
        g2_190reverseBits g2190reverseBits = new g2_190reverseBits();
        System.out.println(g2190reverseBits.reverseBits(43261596));
    }
    /**
     * 反转一个32位无符号整数的二进制位
     * 
     * @param n 需要反转的32位整数
     * @return 反转二进制位后的整数结果
     */
    public int reverseBits(int n) {
        int reverse=0;
        // 循环处理32位二进制数
        for(int i=0;i<32&&n>0;i++){
            // 提取n的最低位，并将其放置到结果的对应高位位置
            reverse|=(n&1)<<(31-i);
            // 无符号右移一位，处理下一位
            n>>>=1;
            System.out.println(Integer.toString(reverse,2));
        }

        return reverse;
    }


}
