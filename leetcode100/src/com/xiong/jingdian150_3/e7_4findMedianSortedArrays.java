package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-20-16:49
 */
public class e7_4findMedianSortedArrays {
    public static void main(String[] args) {
        e7_4findMedianSortedArrays e74findMedianSortedArrays = new e7_4findMedianSortedArrays();
        System.out.println(e74findMedianSortedArrays.findMedianSortedArrays(new int[]{},new int[]{2,3}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmpNums = new int[0];
        if (nums1.length==0){
            tmpNums = nums2;
        }if (nums2.length==0){
            tmpNums = nums1;
        }
        if(tmpNums.length>0){
            if (tmpNums.length%2==1){
                return tmpNums[tmpNums.length/2];
            }else {
                return (double) (tmpNums[tmpNums.length / 2-1] + tmpNums[tmpNums.length / 2 ]) /2  ;
            }
        }


        int aLength = nums1.length;
        int bLength = nums2.length;
        int k = (aLength + bLength + 1) / 2;
        int aindex = 0;
        int bindex = 0;
        while (k>1){
            int medium = k/2;
            if(aLength-aindex<medium){
                bindex = bindex+medium;
            }else if(bLength-bindex<medium){
                aindex = aindex+medium;
            } else {
                if (nums1[aindex + medium - 1] <= nums2[bindex + medium - 1]) {
                    aindex = aindex + medium;
                } else {
                    bindex = bindex + medium;
                }
            }
            k = k-medium;
        }
//        System.out.println(aindex + "--" + bindex);
        int tmpIndex;
        if (aLength== aindex || bLength==bindex){
            if (aLength== aindex){
                tmpIndex = bindex;
                tmpNums = nums2;
            }else {
                tmpIndex = aindex;
                tmpNums = nums1;
            }
            if ((aLength + bLength) % 2 != 0) {
                return tmpNums[tmpIndex];
            }else {
                return (double) (tmpNums[tmpIndex] + tmpNums[tmpIndex + 1]) /2;
            }
        }else {

            if ((aLength + bLength) % 2 != 0) {
                return Math.min(nums1[aindex], nums2[bindex]);
            } else {
                if (nums1[aindex] <= nums2[bindex]) {
                    if (aindex + 1 < aLength) {
                        return (nums1[aindex] + Math.min(nums1[aindex + 1], nums2[bindex])) / 2.0;
                    } else {
                        return (nums1[aindex] + nums2[bindex]) / 2.0;
                    }
                } else {
                    if (bindex + 1 < bLength) {
                        return (nums2[bindex] + Math.min(nums2[bindex + 1], nums1[aindex] ) ) / 2.0;
                    } else {
                        return (nums2[bindex] + nums1[aindex]) / 2.0;
                    }
                }
            }
        }
    }



}
