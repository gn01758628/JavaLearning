package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
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
        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
