package syx.february2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/26 14:30
 */
public class The26thDay {


    /**
     * TODO
     * 题目：字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底
     * 单词 word 中包含谜面 puzzle 的第一个字母。
     * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
     * 返回一个答案数组answer，数组中的每个元素answer[i]是在给出的单词列表 words 中可以作为字谜迷面puzzles[i]所对应的谜底的单词数目。
     * 相关标签：位运算、哈希表
     *https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
     */
    /**
     * 示例：
     * 输入：
     * words = ["aaaa","asas","able","ability","actt","actor","access"],
     * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
     * <p>
     * 输出：[1,1,3,2,4,0]
     * 解释：
     * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
     * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
     * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
     * 2 个单词可以作为"absoryz" 的谜底 : "aaaa", "asas"
     * 4 个单词可以作为"actresz" 的谜底 : "aaaa", "asas", "actt", "access"
     * 没有单词可以作为"gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 转换words中的所有字符，使用二进制进行转换
        Map<Integer, Integer> wordToBin = new HashMap<>();
        for (String word : words) {
            int bin = getBin(word);
            wordToBin.put(bin, wordToBin.getOrDefault(bin, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            result.add(getNumber(wordToBin, puzzles[i]));
        }
        return result;
    }

    private Integer getNumber(Map<Integer, Integer> wordToBin, String puzzle) {

        int count = 0;
        int length = puzzle.length();
        // 获取单词第一个字符在二进制中的位置
        int first = puzzle.charAt(0) - 'a';
        for (int i = 0; i < (1 << (length - 1)); i++) {
            // 先将首字母提取出来
            int u = 1 << first;
            // 枚举「除首个字母」之后的每一位，结合上面的首个字母
            // 其实就是枚举以 str 首字母开头的字符有多少种（枚举子集）
            for (int j = 1; j < length; j++) {
                if (((i >> (j - 1)) & 1) != 0) u += 1 << (puzzle.charAt(j) - 'a');
            }
            // 查询这样的字符是否出现在 `words` 中，出现了多少次
            if (wordToBin.containsKey(u)) {
                count += wordToBin.get(u);
            }
        }


        return count;
    }

    int getBin(String str) {
        int t = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            // 每一位字符所对应二进制数字中哪一位
            int u = c - 'a';
            // 如果当前位置为 0，代表还没记录过，则进行记录 (不重复记录)
            if ((t >> u & 1) == 0) t += 1 << u;
        }
        return t;
    }

    // 时间超长
    @Deprecated
    public List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            result.add(findNumbers1(puzzle, words));
        }
        return result;
    }

    // 时间超长
    @Deprecated
    public int findNumbers1(String puzzle, String[] words) {
        int count = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < puzzle.length(); i++) {
            list.add(puzzle.charAt(i));
        }
        Map<Integer, Boolean> mapFlag = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String wordS = words[i];
            int wordLength = wordS.length();
            for (int i1 = 0; i1 < wordLength; i1++) {
                // 首字母和puzzle相同
                if (list.get(0).equals(wordS.charAt(i1))) {
                    // wordS中的字符是否全部包含在puzzle中
                    mapFlag.put(i, true);
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String wordS = words[i];
            int wordLength = wordS.length();
            int wordCount = 0;
            for (int i1 = 0; i1 < wordLength; i1++) {
                // 首字母和puzzle相同
                if (list.contains(wordS.charAt(i1))) {
                    wordCount++;
                }
                if (wordCount == wordLength && mapFlag.containsKey(i)) {
                    count++;
                }
            }
        }

        return count;
    }

    @Test
    public void test() {
        findNumOfValidWords(new String[]{"apple", "pleas", "please"}, new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"});
    }
}
