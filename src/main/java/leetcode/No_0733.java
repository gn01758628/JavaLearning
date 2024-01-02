package leetcode;

import java.util.Arrays;

public class No_0733 {
    //  題目大意：
    //  有一幅以二維整數數組表示的圖畫，每一個整數表示該圖畫的像素值。
    //  給你一個初始坐標坐標(sr、sc)表示圖像渲染開始的像素值(row、column)和一個新的顏色值color，讓你重新上色這幅圖像。
    //  上色規則：
    //  從初始座標開始上色，如果成功上色就會向四個方向(上下左右)繼續蔓延。
    //  蔓延過去的點也會判斷是否可以上色，可以上色就繼續蔓延，不可以上色就停止。
    //  可以上色的條件：
    //  1.該點的顏色不等於新的顏色(已經是新的顏色了不需上色)
    //  2.該點的顏色必須等於起始點的原始顏色

    //  解題思路：
    //  設好停止條件，對四個方向遞迴
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if (sr == m || sc == n) return image;
        int point = image[sr][sc];
        if (point == color) return image;
        image[sr][sc] = color;
        if (sr - 1 >= 0 && image[sr - 1][sc] == point) {
            floodFill(image, sr - 1, sc, color);
        }
        if (sr + 1 != m && image[sr + 1][sc] == point) {
            floodFill(image, sr + 1, sc, color);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == point) {
            floodFill(image, sr, sc - 1, color);
        }
        if (sc + 1 != n && image[sr][sc + 1] == point) {
            floodFill(image, sr, sc + 1, color);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int sr = 0, sc = 0, color = 0;
        int[][] floodFill = floodFill(image, sr, sc, color);
        for (int[] arr : floodFill) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
