package leetcode.algorithm_pattern.binary_tree.divide_and_conquer.merge_sort;

import java.util.Arrays;

/**
 * @description: 归并排序分治版
 * @author: ahh556
 * @createDate: 2022/7/7
 * @version: 1.0
 */
public class Solution {

    public static int[] sortArray(int[] nums) {
        return mergeSort(nums,0,nums.length - 1);
    }
    public static int[] mergeSort(int [] nums,int front,int rear) {
        // 结束条件
        if( front == rear) {
            return new int[]{nums[front]};
        }
        // 分
        int[] numsLeft = mergeSort(nums,front,(rear + front) / 2);
        int[] numsRight = mergeSort(nums,(rear + front) / 2 + 1,rear);
        // 合
        return merge(numsLeft,numsRight);
    }

    /**
     * 合并有序数组,并产生新的数组
     * @param numsLeft
     * @param numsRight
     * @return
     */
    public static int[] merge(int [] numsLeft,int [] numsRight) {
        int i = 0;
        int j = 0;
        int llen = numsLeft.length;
        int rlen = numsRight.length;
        int [] ans = new int[llen + rlen];
        int k = 0;
        // 把有序的其中一组加完
        while (i < llen && j < rlen) {
            if(numsLeft[i] < numsRight[j]) {
                ans[k++] = numsLeft[i++];
            } else {
                ans[k++] = numsRight[j++];
            }
        }
        // 如果是左边完成了
        if (i >= llen) {
            for (int r = j; r < rlen; r++) {
                ans[k++] = numsRight[r];
            }
        }
        // 如果是右边完成了
        if (j >= rlen) {
            for (int l = i; l < llen; l++) {
                ans[k++] = numsLeft[l];
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        int [] nums = {0,3,6,1,5,8,3,9,8,4,2,-1};
//        int [] numsLeft = {1,2,3,4,5};
//        int [] numsRight = {-2,2,6,9};
        int [] ans = sortArray(nums);
//        int [] ans = merge(numsLeft,numsRight);
        System.out.println(Arrays.toString(ans));
    }
}
