package leetcode刷题.algorithm_pattern.quick_start.实现str函数.双重循环;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/1
 * @version: 1.0
 */
public class Solution {
    /**
     * 通过双重遍历直接返回答案，注意需要考虑子串大于父串的情况，还要考虑父串数组越界情况，第一层的循环终止条件应该为i<=父串.length() - 子串.length()
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length() ; i++) {
            for (int j = 0; j < needle.length(); j++) {
                // 如果出现了则返回之后重新开始循环，如果遍历needle完全后则之后返回对应的i
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if(j == needle.length() - 1) {
                    return i;
                }
            }
        }
            return -1;
    }

    /**
     * 第一版的基础上将i,j先定义，可以减少判断次数
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrPlus(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        int i,j;
        for (i = 0; i <= haystack.length() - needle.length() ; i++) {
            for (j = 0; j < needle.length(); j++) {
                // 如果出现了则返回之后重新开始循环，如果遍历needle完全后则之后返回对应的i
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

}


