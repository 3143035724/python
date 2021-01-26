package syx.arithmetic;

/**
 * * 给定一个矩阵，大小为m，从左上角开始每次只能向右走或者向下走，最后达到右下角的位置。路径中所有数字累加起来就是路径和，返回所有路径的最小路径和
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/13 18:26
 */
public class TestOne {

    public static void test(int m[][]) {
        // 初始位置为startX,startY
        int startX = 0;
        int startY = 0;
        int minValue = 0;
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                if (x == startX && y == startY) {
                    if (x + 1 == m.length) {
                        startY++;
                    } else if (y + 1 == m[x].length) {
                        startX++;
                    } else {
                        if (m[x + 1][y] < m[x][y + 1]) {
                            // 1,0 < 0,1
                            startX++;
                        } else {
                            startY++;
                        }
                    }
                    minValue += m[x][y];
                }
            }
        }
        System.out.println(minValue);

    }

    public static void main(String[] args) {
        // 给定一个矩阵，大小为m，从左上角开始每次只能向右走或者向下走，最后达到右下角的位置。路径中所有数字累加起来就是路径和，返回所有路径的最小路径和
        /**
         比如输入矩阵为
         4 1 5 3
         3 2 7 7
         6 5 2 8
         8 9 4 5

         最小路径为
         23
         */
        int m[][] = {
                {4, 1, 5, 3},
                {3, 2, 7, 7},
                {6, 5, 2, 8},
                {8, 9, 4, 5}
        };
        test(m);
    }

}
