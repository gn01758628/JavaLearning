package leetcode;

public class No_0125 {
    //  題目大意：
    //  判斷一個字串去除空格與符號後，是否是迴文。

    //  解題思路：
    //  雙指針比對，除了比對還要判斷是否是字母或數字
    public static boolean validPalindrome(String s) {
//        // replaceAll是很耗效能的操作
//        // 並且依靠StringBuilder來翻轉字串
//        // 沒有使用到這個題目的核心
//        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
//        String b = new StringBuilder(s).reverse().toString();
//        return s.equals(b);
        if (s.trim().isEmpty()) return true;
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Api解法
    public static boolean validPalindromeByApi(String s) {
        // replaceAll是很耗效能的操作
        // 並且依靠StringBuilder來翻轉字串
        // 沒有使用到這個題目的核心
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String b = new StringBuilder(s).reverse().toString();
        return s.equals(b);
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(s1));
        String s2 = "race a car";
        System.out.println(validPalindrome(s2));
        String s3 = ".,";
        System.out.println(validPalindrome(s3));


    }
}
