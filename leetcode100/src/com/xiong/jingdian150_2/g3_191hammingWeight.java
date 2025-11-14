package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-11-12-11:14
 */
public class g3_191hammingWeight {
    public static void main(String[] args) {
        g3_191hammingWeight g3191hammingWeight = new g3_191hammingWeight();
        System.out.println(g3191hammingWeight.hammingWeight(11));
    }
    public int hammingWeight(int n) {
        int count = 0;
        for (int i =0;i<32;i++){
            if((n&1)==1){
                count++;
            }
            n>>>=1;
        }
        return count;
    }
}
