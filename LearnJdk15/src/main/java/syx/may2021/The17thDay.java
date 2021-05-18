package syx.may2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * * 招银面试题：在n个数字中，找出所有和为SUM的组合(TODO )
 *https://blog.csdn.net/andycpp/article/details/1796669
 * @author syx
 * @version 1.0.0
 * @date 2021/5/17 上午 11:50
 */
public class The17thDay {

    private static List<List<Integer>> list = new ArrayList<>();
    private static final Integer SUM = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> systemIn;
        if (scanner.hasNext()) {
            systemIn = new ArrayList<>();
            scanner.nextLine();
            String next = scanner.nextLine();
            Arrays.stream(next.split(" ")).sorted().forEach(e -> systemIn.add(Integer.valueOf(e)));
            if (count == 1) {
                if (systemIn.get(0).equals(SUM)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                return;
            }
            // 对数据进行相应处理
            findAll(systemIn, count);
            System.out.println(list.size());
        }
    }

    /**
     * 查询对应总和为sum的集合
     *
     * @param systemIn 输入集合
     * @param count    集合长度
     */
    private static void findAll(List<Integer> systemIn, int count) {
        List<Integer> saveList = new ArrayList<>();
        find(saveList, systemIn, count);
        list.add(saveList);
    }

    /**
     * 查询对应总和为sum的集合
     *
     * @param systemIn 输入集合
     * @param count    集合长度
     * @param saveList 符合条件的集合暂时存放容器
     */
    private static void find(List<Integer> saveList, List<Integer> systemIn, int count) {

    }


}
