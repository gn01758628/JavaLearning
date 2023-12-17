package leetcode;

import java.util.Stack;

public class No_0020 {
    //  題目大意：
    //  檢查括弧是否匹配

    //  解題思路：
    //  考慮檢查時的模式：
    //  遇到左括弧先放入，遇到右括弧檢查匹配
    //  匹配成功即可移除該組我又括弧
    //  越晚放入的左括弧越先匹配(後進先出)-Stack
    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 如果是左括弧，就放入對應的右括弧
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                // 遇到右括弧
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        System.out.println(validParentheses(s1));
        System.out.println(validParentheses(s2));
        System.out.println(validParentheses(s3));

    }
}
