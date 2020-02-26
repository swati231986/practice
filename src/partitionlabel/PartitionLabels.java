package partitionlabel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String [] args) {
        String S = "eccbbbbdec";
        List<Integer> partitions =  partitionLabels(S);
        for(Integer partition: partitions) {
            System.out.println(partition);
        }

    }

    /*public static List<Integer> partitionLabels(String S) {
        Map<Character, List<Integer>> firstLastOccurrance = getFirstLastOccurance(S);
        int rangeStart = 0;
        int rangeEnd = 0;
        Map<Integer, List<Integer> > rangeLimit = new HashMap<>();
        List<Integer> partitions = new ArrayList<>();
        for(Character key: firstLastOccurrance.keySet()) {
            int start = 0; int end = 0;
            List<Integer> rangeList = firstLastOccurrance.get(key);
            if(rangeList.get(0) != null) {
                start = firstLastOccurrance.get(key).get(0);
            }
            if(rangeList.size() >1 && rangeList.get(1) != null) {
                end = firstLastOccurrance.get(key).get(1);
            }
            if(rangeStart == rangeEnd) {
                rangeStart = start;
                rangeEnd = end;
            }
            //new range is overlapping with the current range
            if(start < rangeEnd && start > rangeStart && end > rangeEnd) {
                rangeEnd = end;
            } else {
                if(start <rangeStart && end < rangeEnd) {
                    rangeStart = start;
                } else {
                    //range is in between the current range
                    if(start > rangeStart && end < rangeEnd) {
                        continue;
                    } else {

                        //if range is greater than the current range
                        if(start<rangeStart && end> rangeEnd) {
                            rangeStart = start;
                            rangeEnd = end;
                        }
                    }
                }
            }
            //range is outside of the current range
            if((start > rangeEnd ) || rangeEnd == S.length()-1){
                //current range is one of the partition
                if(!partitions.contains(rangeEnd-rangeStart+1)) {
                    int range = rangeEnd-rangeStart+1;
                    if(rangeLimit.get(range) !=null && rangeLimit.get(range).get(0) < rangeStart && rangeLimit.get(range).get(1)>rangeEnd) {
                        int index = partitions.indexOf(range);
                        partitions.remove(index);
                        partitions.add(index, rangeEnd - rangeStart +1);

                    } else {
                        partitions.add(range);
                    }

                    List<Integer> rangeLimitlist = new ArrayList<>();
                    rangeLimitlist.add(rangeStart); rangeLimitlist.add(rangeEnd);
                    rangeLimit.put(range, rangeLimitlist);

                }
                rangeStart = start;
                rangeEnd = end;
            }



        }
        return partitions;
    }

    public static Map<Character, List<Integer>> getFirstLastOccurance(String S) {
        Map<Character, List<Integer>> firstLastOccurrance = new HashMap<>();
        for(int count = 0; count<S.length(); count++) {
            Character c = S.charAt(count);
            List<Integer> firstLastOccuranceList = new ArrayList<>();
            if(!(firstLastOccurrance.get(c) != null)) {
                firstLastOccuranceList.add(0,count);
            } else {
                firstLastOccuranceList = firstLastOccurrance.get(c);
                firstLastOccuranceList.remove(1);
            }
            firstLastOccuranceList.add(1,  count);
            firstLastOccurrance.put(c, firstLastOccuranceList);
        }
        return firstLastOccurrance;
    }*/

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            char y = S.charAt(i);
            int x = S.charAt(i) - 'a';
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

}
