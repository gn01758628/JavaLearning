package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_0021 {
    //  題目大意：
    //  合併兩個有序鏈表

    //  解題思路：
    //  理解鏈表的運作模式
    //  創建一個假的頭節點，方便後續操作

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // 返回描述數據結構的Array
        private int[] getArray() {
            List<Integer> list = new ArrayList<>();

            for (ListNode current = this; current != null; current = current.next) {
                list.add(current.val);
            }

            return list.stream().mapToInt(i -> i).toArray();
        }

        // 覆寫toString方便觀察
        @Override
        public String toString() {
            return Arrays.toString(getArray());
        }
    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (list1 != null & list2 != null) {
            if (list1.val >= list2.val) {
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return prevHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        System.out.println(mergeTwoSortedLists(list1, list2));
    }
}
