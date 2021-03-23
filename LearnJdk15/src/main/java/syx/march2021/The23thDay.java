package syx.march2021;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/23 下午 2:13
 */
public class The23thDay {
    /**
     * 题目：70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 相关标签：动态规划
     * https://leetcode-cn.com/problems/climbing-stairs/
     */
    public int climbStairs(int n) {
        // 根据题目可得：f(n) = f(n-1)+f(n-2)
        int nBefore1 = 0;
        int nBefore2 = 0;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            nBefore1 = nBefore2;
            nBefore2 = sum;
            sum = nBefore1 + nBefore2;
        }
        return sum;
    }
}
