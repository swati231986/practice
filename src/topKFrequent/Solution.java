package topKFrequent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        //String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
        //String [] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        String [] words = {"plpaboutit","jnoqzdute","sfvkdqf","mjc","nkpllqzjzp","foqqenbey","ssnanizsav",
                "nkpllqzjzp","sfvkdqf","isnjmy","pnqsz","hhqpvvt","fvvdtpnzx","jkqonvenhx","cyxwlef","hhqpvvt",
                "fvvdtpnzx","plpaboutit","sfvkdqf","mjc","fvvdtpnzx","bwumsj","foqqenbey","isnjmy","nkpllqzjzp",
                "hhqpvvt","foqqenbey","fvvdtpnzx","bwumsj","hhqpvvt","fvvdtpnzx","jkqonvenhx","jnoqzdute","foqqenbey",
                "jnoqzdute","foqqenbey","hhqpvvt","ssnanizsav","mjc","foqqenbey","bwumsj","ssnanizsav","fvvdtpnzx","nkpllqzjzp",
                "jkqonvenhx","hhqpvvt","mjc","isnjmy","bwumsj","pnqsz","hhqpvvt","nkpllqzjzp","jnoqzdute","pnqsz","nkpllqzjzp",
                "jnoqzdute","foqqenbey","nkpllqzjzp","hhqpvvt","fvvdtpnzx","plpaboutit","jnoqzdute","sfvkdqf","fvvdtpnzx","jkqonvenhx",
                "jnoqzdute","nkpllqzjzp","jnoqzdute","fvvdtpnzx","jkqonvenhx","hhqpvvt","isnjmy","jkqonvenhx","ssnanizsav","jnoqzdute",
                "jkqonvenhx","fvvdtpnzx","hhqpvvt","bwumsj","nkpllqzjzp","bwumsj","jkqonvenhx","jnoqzdute","pnqsz",
                "foqqenbey","sfvkdqf","sfvkdqf"};


        List<String> result = s.topKFrequent(words, 1);
        result.forEach(e -> System.out.println(e));
    }

    public List<String> topKFrequent(String[] words, int k) {
        if(words.length == 0 || k==0) {
            return new ArrayList();
        }

        // store words and their frequencies in a map
        Map<String, Integer> wordFreq = new HashMap();

        for(String word:words) {
            int count = wordFreq.containsKey(word) ? wordFreq.get(word) : 0;
            wordFreq.put(word, ++count);
        }

        Map<Integer, PriorityQueue<String>> map = new HashMap();
        for(Map.Entry<String, Integer> entry:wordFreq.entrySet()) {
            if(map.containsKey(entry.getValue())) {
                map.get(entry.getValue()).add(entry.getKey());
            } else {
                PriorityQueue<String> queue = new PriorityQueue();
                queue.add(entry.getKey());
                map.put(entry.getValue(), queue);
            }
        }


        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if(entry1.getValue() == entry2.getValue()) {
                    if(entry1.getKey().compareTo(entry2.getKey()) >0) {
                        return 1;
                    } else {
                        return 0;
                    }

                } else if(entry1.getValue() >= entry2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });


        for(Map.Entry<String, Integer> entry: wordFreq.entrySet()) {
            pq.add(entry);
        }

        List<String> result = new ArrayList();

        for(int i = 1; i<=k; ) {
            Map.Entry<String, Integer> entry = pq.poll();
            if(map.containsKey(entry.getValue())) {
                PriorityQueue<String> queue = map.get(entry.getValue());
                while(i <= k && !queue.isEmpty()) {
                    result.add(queue.poll());
                    i++;
                }
            }
        }


        return result;
    }
}
