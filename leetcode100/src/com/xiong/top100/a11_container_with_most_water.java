package com.xiong.top100;

/**
 * @author xiong
 * @Description 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * @date 2023-02-23 10:14 上午
 */
public class a11_container_with_most_water {
    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(a);
        System.out.println(i);
    }

    public static  int maxArea(int[] height) {
        int minIndex = 0;
        int maxIndex = height.length-1;
        int maxArea = 0;
        while (minIndex != maxIndex){
            int minIndexHeight = height[minIndex];
            int maxIndexHeight = height[maxIndex];
            if(minIndexHeight>maxIndexHeight){
                maxArea = Math.max(maxArea,maxIndexHeight*(maxIndex-minIndex));
                maxIndex--;
            }else {
                maxArea = Math.max(maxArea,minIndexHeight*(maxIndex-minIndex));
                minIndex++;
            }
        }
        return  maxArea;


    }


    public static  int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i=0;i<height.length-1;i++){
            for (int j=i+1;j<height.length;j++){
                int heightOne = Math.min(height[i], height[j]);
                int oneArea = heightOne * (j-i);
                maxArea = Math.max(maxArea, oneArea);
            }
        }
        return  maxArea;

    }
}
