package com.xiong.top100;

/**
 * @author xiong
 * @Description
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n))
 * @date 2023-02-09 5:47 下午
 */
public class a4_median_two_sorted_arrays {

    public static void main(String[] args) {
        int[] a1 = {};
        int[] a2 = {1};
        double medianSortedArrays = findMedianSortedArrays(a1, a2);
        System.out.println(medianSortedArrays);
    }
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0 && n==0){
            return 0d;
        }
        if(m == 0){
            if(n%2==0){
                return  (nums2[n/2]+nums2[n/2-1])/2d;
            }else {
                return  nums2[n/2];
            }
        }
        if(n == 0){
            if(m%2==0){
                return  (nums1[m/2]+nums1[m/2-1])/2d;
            }else {
                return  nums1[m/2];
            }
        }
        int i = 0;
        int j = 0;
        int resultIndex;
        int resultPre=0;
        int resultNow=0;
        resultIndex = (n+m)/2;
        while (i+j<=resultIndex){
            resultPre = resultNow;
            if( j==n || (i<m && nums1[i]<nums2[j]) ){
                resultNow = nums1[i];
                i++;
            }else{
                resultNow = nums2[j];
                j++;
            }
        }
        if((n+m)%2==0){
            return (resultPre+resultNow)/2.0d;
        }else {
            return resultNow;
        }
    }

}
