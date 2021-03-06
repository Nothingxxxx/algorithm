package nothing;

public class Demo {
/*
* 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
*
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
* */
    public int longestPalindrome(String s) {

        //arr用来存放字符串中相应字符的个数
        int[] arr = new int[123];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }

        int count = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                count += i;
            } else {
                count += i - 1;
            }
        }

        if (count != s.length()) {
            count++;
        }
        return count;
    }
}
