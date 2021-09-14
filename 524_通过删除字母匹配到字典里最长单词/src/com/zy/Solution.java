package com.zy;

import java.sql.Connection;
import java.util.*;

/**
 * @author zy
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("e");
        arrayList.add("bb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("a");
        arrayList.add("ffff");
        arrayList.add("hhhh");
        arrayList.add("aaaa");

        System.out.println("a".compareTo("b"));



//        Collections.sort(arrayList);
//        Collections.sort(arrayList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int res = o2.length() - o1.length();  // 长的字符串排前面
//                if(res == 0){
////                    res =  arrayList.indexOf(o1) - arrayList.indexOf(o2);  // 字符串长度相等的
//                    res = o2.compareTo(o1);  // 字符串长度相等的
//                }
//                return res;
//            }
//        });
        System.out.println(arrayList.toString());
    }

    public String findLongestWord(String s, List<String> dictionary) {

        // 对字典进行排序 长的放前面
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = o2.length() - o1.length();  // 长的字符串排前面
                if(res == 0){
                    res =  o1.compareTo(o2);  // 字符串长度相等的按照字符串的比较规则来
                }
                return res;
            }
        });

        for (String str : dictionary) {
            if(str.length() > s.length()){
                continue;
            }
            int j = 0, i = 0;
            while (j < str.length() && i < s.length()){
                if(s.charAt(i) == str.charAt(j)){
                    ++j;
                }
                ++i;
            }
            if(j == str.length()){
                return str;
            }
        }
        return "";
    }
}
