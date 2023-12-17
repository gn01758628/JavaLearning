package leetcode;

public class No_0121 {
    //  題目大意：
    //  一個陣列，它的第i個元素是股票第i天的價格。
    //  如果最多只允許完成一筆交易（即買入和賣出一支股票）。
    //  設計一個算法來計算你所能獲取的最大利潤。注意你不能在買入股票前賣出股票。

    //  解題思路：
    //  動態規劃(Dynamic Programming)：
    //  將一個問題分解為更小的子問題
    //  並且儲存子問題的解，來提高計算效率
    public static int bestTimeToBuyAndSellStock(int[] prices) {
        int lowerPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            lowerPrice = Math.min(price, lowerPrice);
            maxProfit = Math.max(price - lowerPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(bestTimeToBuyAndSellStock(prices1));
        int[] prices2 = {7,6,4,3,1};
        System.out.println(bestTimeToBuyAndSellStock(prices2));
    }
}
