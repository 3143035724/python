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
    class NumMatrix {

        private int[][] classMatrix;

        public NumMatrix(int[][] matrix) {
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


    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        obj.sumRegion(2, 1, 4, 3);
    }
}
