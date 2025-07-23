package com.xiong.jingdian150;

import static com.xiong.utils.OutArrays.outArrays;

/**
 * @author xiong
 * @create 2025-07-15-19:55
 * 88. 合并两个有序数组
 */
public class a1_88merge {
    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        int[] ints = new int[m + n];
        int m1=0;
        int n1=0;
        for (int i = 0; i < m + n; i++) {
            if(m1==m){
                ints[i] = nums2[n1];
                n1++;
            }else if(n1==n) {
                ints[i] = nums1[m1];
                m1++;
            }else if(nums1[m1]>=nums2[n1]){
                ints[i]=nums2[n1];
                n1++;
            }else {
                ints[i]=nums1[m1];
                m1++;
            }
        }
        System.arraycopy(ints, 0, nums1, 0, ints.length);
        outArrays(nums1);

    }
}
