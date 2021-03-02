package syx.march2021;

import org.junit.Test;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/2 14:01
 */
public class The2thDay {

    /**
     * 题目：二维区域和检索-矩阵不可变
     * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)
     * 相关标签：动态规划
     * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
     */
    // 效率较低
    class NumMatrixA {

        private int[][] classMatrix;

        public NumMatrixA(int[][] matrix) {
            this.classMatrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (classMatrix == null || classMatrix.length == 0) {
                return 0;
            }
            int result = 0;
            for (int row = row1; row <= row2; row++) {
                for (int col = col1; col <= col2; col++) {
                    result += classMatrix[row][col];
                }
            }

            return result;
        }
    }


    class NumMatrixB {
        int[][] sum;

        public NumMatrixB(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            // 初始化时计算每一行前缀和，就是说第一个值为A，第二个值就为A+B
            int length = matrix[0].length;
            sum = new int[matrix.length][length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < length; j++) {
                    sum[i][j + 1] = matrix[i][j] + sum[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sum == null || sum.length == 0) {
                return 0;
            }
            int sumNum = 0;
            // row1为行，col1为列
            for (int i = row1; i <= row2; i++) {
                // 所有的都需要在sum数组中减去前序位置，保留当前位置
                //  sum[i][col2 + 1] - sum[i][col1] = 当前行位置的值;
                sumNum = sumNum + sum[i][col2 + 1] - sum[i][col1];
            }
            return sumNum;
        }
    }


    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrixA obj = new NumMatrixA(matrix);
        obj.sumRegion(2, 1, 4, 3);
    }
}
