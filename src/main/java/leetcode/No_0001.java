package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_0001 {
    //  題目大意：
    //  在數組(nums)裡找到兩個數的合等於給定值(target)
    //  返回兩個數字在數組中的索引(index)

    //  解題思路：
    //  暴力解法雙迴圈遍歷所有組合，時間複雜度會變成O(n²)
    //  尋找一次遍歷即可解決的辦法O(n)
    //  對每個元素，在map中尋找符合結果的數字，存在則返回索引
    //  不存在則存入map，讓後面的元素尋找
    public static int[] twoSum(int[] nums, int target) {
        // 手動設置map的起始容量(Capacity)可以降低擴容操作帶來的消耗
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        // 第一個元素直接存入
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[]{map.get(gap), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] nums3 = {3,3};
        System.out.println(Arrays.toString(twoSum(nums,target)));
        System.out.println(Arrays.toString(twoSum(nums2,target2)));
        System.out.println(Arrays.toString(twoSum(nums3,target2)));
    }
}
