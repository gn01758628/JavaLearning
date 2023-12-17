package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_0242 {
    //  題目大意：
    //  判段字串s中的字母，t是否都有(數量也要相同)

    //  解題思路：
    //  三種解法看方法備註

    // 利用Array
    public static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int num = --arr[t.charAt(i) - 'a'];
            if (num < 0) return false;
        }
        return true;
    }

    // 利用Api的解法
    public static boolean validAnagramByApi(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // 利用HashMap的解法
    public static boolean validAnagramByHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            int num = map.getOrDefault(c, -1);
            num++;
            map.put(c, num);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            int num = map.get(c);
            if (num == 0) {
                map.remove(c);
            } else {
                num--;
                map.put(c, num);
            }
        }
        return map.isEmpty();
    }


    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(validAnagram(s1, s2));
        String s3 = "rat";
        String s4 = "car";
        System.out.println(validAnagramByApi(s3, s4));
        String s5 = "ab";
        String s6 = "a";
        System.out.println(validAnagramByHashMap(s5, s6));
    }
}
