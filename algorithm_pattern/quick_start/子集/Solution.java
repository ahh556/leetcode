package leetcode刷题.algorithm_pattern.quick_start.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/1
 * @version: 1.0
 */
public class Solution {
//
//    从左往右遍历：
//    选出长度为0的子集
//            选出长度为1的子集
//    选出长度为2的子集...
//            []
//            1 2 3
//            1 2 ,1 3
//            2 3,
//            1 2 3
//    关键在于怎么找子集，由规律可知：
//    空集在最前面，空集的直接加入集合中，设置计数器index + cn0，index的意思的第一个开始匹配的位置，
//    从index开始与index所表示的子集的最后一位的索引 + 1开始组合，直到不能在组合了，流程重复次数为子集的大小
//    需要做预处理，通过值能够快速找到位置
//    创建一个长度为20的数组存的时候 value + 10 存在数组中，value + 10 之后取值对应的索引
    /**
     * 自写的遍历
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int valueToIndex[] = new int[21];
        // 预处理 需要整体 + 10 之后存入
        for (int i = 0; i < nums.length; i++) {
            valueToIndex[nums[i] + 10] = i;
        }
        // 创建空集
        List<Integer> list = new ArrayList<>();
        // 创建返回集合
        List<List<Integer>> ans = new ArrayList<>();
        // 将空集加入到ans中
        ans.add(list);
        // 创建index：开始匹配的位置
        int index = 0;// 上一次选择的第一个索引为0
        int length = nums.length;
        int sonLastEleIndex = 0;
        for (int i = 1; i <= length; i++) {
            // 拿上一次选择的所有数组开始匹配
            for (int j = index; j < index + cNI(i,length); j++) {
                List<Integer> temp = ans.get(j);
                for (int k = sonLastEleIndex; k < length; k++) {
                    List<Integer> sonList = getCopyList(temp);
                    sonList.add(nums[k]);
                    ans.add(sonList);
                }
                sonLastEleIndex = valueToIndex[ans.get(j + 1).get(ans.get(j + 1).size() - 1) + 10] + 1;
            }
            index = index + cNI(i,length);

        }
        return ans;
    }

    /**
     * 计算组合数公式
     * @param i
     * @param n
     * @return
     */
    public int cNI(int i,int n) {
        int a1 = 1;
        for (int j = n; j >=n - i +1 ; j--) {
            a1 = a1 * j;
        }
        int a2 = 1;
        for (int j = i; j >=1 ; j--) {
            a2 = a2 * j;
        }
        return a1 / a2;
    }
    public List<Integer> getCopyList(List<Integer> oldList) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            newList.add(oldList.get(i));
        }
        return newList;
    }
}
