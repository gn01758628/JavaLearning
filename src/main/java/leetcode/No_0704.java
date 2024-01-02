package leetcode;

public class No_0704 {
    //  題目大意：
    //  在有序的array中尋找目標值

    //  解題思路：
    //  二分搜尋法：
    //  元素已排序，所以先取位於中間的元素值，慢慢逼近正確位置

    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int midIndex = (start + end) / 2;
        while (start <= end) {
            if (nums[midIndex] == target) return midIndex;
            if (nums[midIndex] > target) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
            midIndex = (start + end) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println(binarySearch(nums1, target1));
        int target2 = 2;
        System.out.println(binarySearch(nums1, target2));
    }
}
