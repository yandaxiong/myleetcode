package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-25-16:37
 */
public class g5_50myPow {
    public static void main(String[] args) {
        g5_50myPow g5_50myPow = new g5_50myPow();
        System.out.println(g5_50myPow.myPow(2.0,-2147483648));
    }
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

}
