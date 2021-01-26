package syx.arithmetic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * 账户合并
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/18 9:18
 */
public class AccountMerge {

//    1.失败，只有存储邮箱和名称的map
//    private Map<String, String> emailMap;
//
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        emailMap = new HashMap<>();
//        for (List<String> account : accounts) {
//            for (int j = 0; j < account.size(); j++) {
//                // 将邮箱和名称的对应关系存储到emailMap中
//                if (!emailMap.containsKey(account.get(j))) {
//                    emailMap.put(account.get(j), account.get(0));
//                }
//            }
//        }
//        return null;
//    }

//https://leetcode-cn.com/problems/accounts-merge/
    // 2.邮箱map，邮箱和名称的对应关系，合并使用
    private Map<String, String> emailMap;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        emailMap = new HashMap<>();
        Map<String, String> emailNameMap = new HashMap<>();

        for (List<String> account : accounts) {
            for (int j = 0; j < account.size(); j++) {
                // 将邮箱和名称的对应关系存储到emailNameMap中
                if (!emailMap.containsKey(account.get(j))) {
                    emailNameMap.put(account.get(j), account.get(0));
                    if (j != 0) {
                        emailMap.put(account.get(j), account.get(j));
                    }
                }
                // 存在两个及两个以上邮箱
                if (j > 1) {
                    emailMap.put(findEmail(account.get(j)), findEmail(account.get(j - 1)));
                }
            }
        }
        // 暂时存储答案中的邮箱列表
        Map<String, List<String>> temp = new HashMap<>();
        for (String emails : emailMap.keySet()) {
            String name = findEmail(emails);
            if (!temp.containsKey(name)) {
                temp.put(name, new ArrayList<>());
            }
            temp.get(name).add(emails);
        }
        List<List<String>> result = new ArrayList();
        // 将答案从映射中放到列表总
        for (String emails : temp.keySet()) {
            // 获取当前根元素对应的列表
            List<String> layer = temp.get(emails);
            // 题目要求的排序
            Collections.sort(layer);
            // 添加姓名
            layer.add(0, emailNameMap.get(emails));
            // 将当前列表加入答案
            result.add(layer);
        }

        return result;
    }

    private String findEmail(String email) {
        if (!emailMap.get(email).equals(email)) {
            // 值和key不相等
            emailMap.put(email, findEmail(emailMap.get(email)));
        }
        return emailMap.get(email);
    }

    @Test
    public void test() {
//[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accountsMerge(accounts);
    }


}
