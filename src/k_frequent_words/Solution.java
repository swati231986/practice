package k_frequent_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String [] args) {
        //String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> result = topKFrequent(words,3);
        result.forEach(e -> System.out.println(e));
    }



    public static List<String> topKFrequent(String[] words, int k) {
        if(words.length == 0 || k==0) {
            return new ArrayList();
        }

        // store words and their frequencies in a map
        Map<String, Integer> wordFreq = new HashMap();

        for(String word:words) {
            int count = wordFreq.containsKey(word) ? wordFreq.get(word) : 0;
            wordFreq.put(word, ++count);
        }

        // store the words by their frequencies
        Map<Integer, PriorityQueue<String>> freqWord = new HashMap();

        for(Map.Entry<String, Integer> entry:wordFreq.entrySet()) {
            if(freqWord.containsKey(entry.getValue())) {
                freqWord.get(entry.getValue()).add(entry.getKey());
            } else {
                PriorityQueue priorityQueue =  new PriorityQueue();
                priorityQueue.add(entry.getKey());
                freqWord.put(entry.getValue(),  priorityQueue);
            }
        }

        //store the entries of freqWord in a priorityqueue

        PriorityQueue<Map.Entry<Integer, PriorityQueue<String>>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());

        for(Map.Entry entry:freqWord.entrySet()) {
            pq.add(entry);
        }

        //read k entries from pq in a list
        List<String> result = new ArrayList();
        int numRemaining = k;
        for(int i =0; i<k;) {
            Map.Entry<Integer, PriorityQueue<String>> entry = pq.poll();
            List<String> list = entry.getValue().stream().collect(Collectors.toList());
            if(list.size() > numRemaining) {
                list = list.stream().limit(numRemaining).collect(Collectors.toList());
            }
            result.addAll(list);
            i = i + list.size();
            numRemaining = numRemaining - i;

        }

        return result;
    }
}
