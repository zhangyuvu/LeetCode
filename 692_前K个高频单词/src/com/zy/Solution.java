package com.zy;

import java.util.*;

/**
 * @author zhangyu
 * @date 2021/10/11 18:14
 *
    给一非空的单词列表，返回前 k 个出现次数最多的单词。

    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

    示例 1：

    输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    输出: ["i", "love"]
    解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
     
    示例 2：

    输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    输出: ["the", "is", "sunny", "day"]
    解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
     
    注意：

    假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
    输入的单词均由小写字母组成。

 */
public class Solution {

    // 内存占用更多
    //  public List<String> topKFrequent(String[] words, int k) {
    //     HashMap<String, Integer> counts = new HashMap<>();

    //     for (String word : words) {  // map 中保存所有单词出现的次数
    //         if (!counts.containsKey(word)) {
    //             counts.put(word, 1);
    //         } else {
    //             counts.replace(word, counts.get(word) + 1);
    //         }
    //     }

    //     List<String> array = new ArrayList<>(counts.keySet());
    //     array.sort((w1, w2) -> {
    //         Integer count1 = counts.get(w1);
    //         Integer count2 = counts.get(w2);
    //         return count1.equals(count2) ? w1.compareTo(w2) : count2 - count1;
    //     });

    //     return array.subList(0,k);
    // }


    // 这种方式内存占用更少
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {  // map 中保存所有单词出现的次数
//            if (!counts.containsKey(word)) {
//                counts.put(word, 1);
//            } else {
//                counts.replace(word, counts.get(word) + 1);
//            }
            // 上面代码的优化
            // getOrDefault() 针对存在与map中的Key返回对应的value
            // 针对不存在的key返回defaultValue的值
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<String> array = new ArrayList<>();

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {        // 优先级队列
            Integer count1 = counts.get(w1);
            Integer count2 = counts.get(w2);
            return count1.equals(count2) ? w1.compareTo(w2) : count2 - count1;// 从大到小排放
        });

        pq.addAll(counts.keySet());

        for (int i = 0 ; i < k ; i++){
            array.add(pq.poll());
        }

        return array;
    }

    // 升级
    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {  // map 中保存所有单词出现的次数
            if (!counts.containsKey(word)) {
                counts.put(word, 1);
            } else {
                counts.replace(word, counts.get(word) + 1);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {        // 优先级队列
            Integer count1 = counts.get(w1);
            Integer count2 = counts.get(w2);
            return count1.equals(count2) ? w2.compareTo(w1) : count1 - count2;  // 从小到大排放
        });


        // 放入所有数据  经过几轮 poll之后 最后需要返回的数据从小到大排序
        for(String word : counts.keySet()){
            pq.offer(word);
            if(pq.size() > k) pq.poll();
        }

        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) res.add(pq.poll());

        Collections.reverse(res);

        return res;
    }

}
