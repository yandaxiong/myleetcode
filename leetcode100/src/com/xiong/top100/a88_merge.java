package com.xiong.top100;

import com.xiong.utils.OutArrays;

import java.util.Arrays;

/**
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class a88_merge {

    public static void main(String[] args) {
        int[] nums = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n=1;
        merge(nums,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n!=0){
           int[] m1;
            m1 = Arrays.copyOf(nums1, m);
           for (int i=0,j=0;i<m||j<n;){
               if(j!=n  && (i==m || m1[i]>nums2[j]) ){
                   nums1[i+j]=nums2[j];
                   j++;
               }else if(i!=m  && (j==n || m1[i]<=nums2[j] ) ){
                   nums1[i+j]=m1[i];
                   i++;
               }
           }
        }
        OutArrays.outArrays(nums1);
    }


}
