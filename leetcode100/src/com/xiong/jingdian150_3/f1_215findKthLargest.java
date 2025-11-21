package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-11-20-19:54
 * 
 * LeetCode 215. 数组中的第K个最大元素
 * 题目描述：给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 注意：需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 要求：时间复杂度为 O(n)
 */
public class f1_215findKthLargest {
    /**
     * 主函数，用于测试findKthLargest方法
     */
    public static void main(String[] args) {
        f1_215findKthLargest f1_215findKthLargest = new f1_215findKthLargest();
        // 测试用例：数组[3,2,0,1,2,4,5,5,6]，查找第4大的元素
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        // 输出结果，预期为4
        System.out.println(f1_215findKthLargest.findKthLargest(nums, 4));
    }

    /**
     * 查找数组中第k个最大的元素
     * 使用堆排序算法实现，时间复杂度为O(nlogk)，优于完全排序的O(nlogn)
     * 
     * @param nums 整数数组
     * @param k 第k个最大的元素
     * @return 第k个最大的元素值
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        // 构建最大堆
        buildMaxHeap(nums, heapSize);
        OutArrays.outArrays(nums);
        // 执行k-1次堆排序操作，将前k-1个最大元素放到数组末尾
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            // 将当前最大元素（堆顶）与未排序部分最后一个元素交换
            swap(nums, 0, i);
            --heapSize;
            // 重新调整堆结构，确保堆顶是剩余元素中的最大值
            maxHeapify(nums, 0, heapSize);
        }
        // 此时堆顶元素即为第k个最大元素
        return nums[0];
    }

    /**
     * 构建最大堆
     * 从最后一个非叶子节点开始，自底向上调整堆结构
     * 
     * @param a 待构建堆的数组
     * @param heapSize 堆的大小
     */
    public void buildMaxHeap(int[] a, int heapSize) {
        // 从最后一个非叶子节点开始向前遍历
        // 最后一个非叶子节点的索引为 heapSize/2 - 1
        for (int i = heapSize / 2 - 1; i >= 0; --i) {
            // 调整以i为根节点的子树，使其满足最大堆性质
            maxHeapify(a, i, heapSize);
            OutArrays.outArrays(a);
        }
    }

    /**
     * 调整堆结构，使以节点i为根的子树满足最大堆性质
     * 最大堆性质：父节点的值大于或等于其子节点的值
     * 
     * @param a 数组
     * @param i 当前节点索引
     * @param heapSize 堆的大小
     */
    public void maxHeapify(int[] a, int i, int heapSize) {
        // 计算左右子节点的索引
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        
        // 如果左子节点存在且值大于当前最大值节点，则更新largest
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        
        // 如果右子节点存在且值大于当前最大值节点，则更新largest
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        
        // 如果最大值节点不是当前节点，则交换并继续调整
        if (largest != i) {
            // 交换当前节点与最大值节点
            swap(a, i, largest);
            // 递归调整被交换节点的子树
            maxHeapify(a, largest, heapSize);
        }
    }

    /**
     * 交换数组中两个位置的元素
     * 
     * @param a 数组
     * @param i 第一个位置
     * @param j 第二个位置
     */
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
