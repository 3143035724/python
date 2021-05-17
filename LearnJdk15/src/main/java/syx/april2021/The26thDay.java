package syx.april2021;

import org.junit.Test;

import java.util.Arrays;

/**
 * * syx.april2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/4/26 上午 9:15
 */
public class The26thDay {
    /**
     * TODO
     * 题目：1011. 在 D 天内送达包裹的能力
     * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口
     * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量
     */
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        if (weights.length == 1) {
            return weights[0];
        }


        return getCounts(weights, D);
    }

    /**
     * 获取最低载重
     *
     * @param weights     传送带上的包裹
     * @param whileCounts 循环次数
     * @return 最低载重
     */
    private int getCounts(int[] weights, int whileCounts) {

        return 0;
    }

    @Test
    public void test() {
        shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
    }
}
