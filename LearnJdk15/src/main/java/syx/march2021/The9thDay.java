package syx.march2021;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/9 15:10
 */
public class The9thDay {

    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder split = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1))) {
                split.append(s.charAt(i));
            }
        }
        return split.toString();
    }
}
