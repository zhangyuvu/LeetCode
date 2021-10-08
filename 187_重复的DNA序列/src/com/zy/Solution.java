package com.zy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhangyu
 * @date 2021/10/8 15:18
    所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，
识别 DNA 中的重复序列有时会对研究非常有帮助。

    编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

    示例 1：

    输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    输出：["AAAAACCCCC","CCCCCAAAAA"]
    示例 2：

    输入：s = "AAAAAAAAAAAAA"
    输出：["AAAAAAAAAA"]
     

    提示：

    0 <= s.length <= 105
    s[i] 为 'A'、'C'、'G' 或 'T'


 */
public class Solution {

    // 利用大小为10的滑动窗口和hashMap 避免重复答案
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> values = new ArrayList<>();
        if(s.length() <= 10) return values;  // 保证字符串 s 至少有11个字符

        StringBuilder sb = new StringBuilder();     // 滑动窗口
        HashMap<String, Boolean> valueMap = new HashMap<>(); // 查重的map

        for(int j = 0; j <= 9 ; j++){           // 放入第一个子串
            sb.append(s.charAt(j));
        }
        String temp = sb.toString();
        valueMap.put(temp,false);

        for (int i = 1; i <= s.length() - 10; i++) {
            sb.deleteCharAt(0);                         // 删除最前面的字符 添加新子串的最后一个字符
            sb.append(s.charAt(i + 9));
            temp = sb.toString();

            if (!valueMap.containsKey(temp)){
                valueMap.put(temp,false);       // 第一次加进map的字符都为 false
                continue;
            }

            if(!valueMap.get(temp)){
                values.add(temp);
                valueMap.replace(temp,true);        // 添加过list的字符换成 true 这样就无法再添加
            }
        }

        return values;
    }

}
