package com.zy;

import java.util.HashMap;

/**
 * @author zy

    设计一个方法，找出任意指定单词在一本书中的出现频率。
    你的实现应该支持如下操作：
    WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
    get(word)查询指定单词在书中出现的频率

    提示：
    book[i]中只包含小写字母
    1 <= book.length <= 100000
    1 <= book[i].length <= 10
    get函数的调用次数不会超过100000


 */
public class WordsFrequency {
    HashMap<String, Integer> map = new HashMap<>();
    public WordsFrequency(String[] book) {
        for (String s : book) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            }else {
                Integer temp = map.get(s);
                map.replace(s, ++temp);
            }
        }
    }
    public int get(String word) {
        return map.get(word) == null ? 0 : map.get(word);
    }
}
