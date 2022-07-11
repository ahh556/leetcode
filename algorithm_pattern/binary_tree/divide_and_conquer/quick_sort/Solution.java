package leetcode.algorithm_pattern.binary_tree.divide_and_conquer.quick_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/8
 * @version: 1.0
 */
public class Solution {


    public static int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    public static void quickSort(int [] nums,int start,int end) {

        if(start < end) {
            // 分
            int pindex = partition(nums,start,end);
            quickSort(nums,start,pindex - 1);
            quickSort(nums,pindex + 1,end);
        }

        // 4 5 6 8 1 9 10 1
        //定义 左指针i，右指针j，i指针维护左边都符合顺序，j指针维护右边都符合顺序，i从左往右遍历，之后出现大于选定值则停止，
        // j从右往左变量,之后出现小于选定值则停止 ,出现之后交换两个指针，都遍历到指定值之后，
    }

    public static int  partition(int [] nums,int start,int end) {
        Random random = new Random();
        int randIndex = random.nextInt(end + 1 - start) + start;
        swap(nums,randIndex,end);
        int p = nums[end];
        int i = start;
        for (int j = start; j <= end; j++) {
            if(nums[j] < p) {
                swap(nums,i,j);
                i++;
            }

        }
        swap(nums,i,end);
        return i;
    }

    public static void swap (int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
