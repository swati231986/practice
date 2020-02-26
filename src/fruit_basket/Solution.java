package fruit_basket;

public class Solution {
    public static void main(String [] args) {
       //int []tree = {0,3,3,3,1,2,1,1,2,2,3,3,4};
       //int []tree={1,2,1};
       // int tree[] = {1,2};
        //int tree[] = {0,1,6,6,4,4,6};
        int tree[] = {3,3,3,1,2,1,1,2,1,3,3,4};
        Solution s = new Solution();
        int count = s.totalFruit(tree);
        System.out.println(count);
    }

    public int totalFruit(int[] tree) {
        if(tree.length == 0) {return 0;}
        if(tree.length == 1) {return 1;}

        int start = -1;int change = -1;
        int max = Integer.MIN_VALUE;
        int a = -1; int b = -1;

        for(int i =0; i<tree.length; i++) {
            if(start == -1) {
                start = i;
                a = tree[i];
                continue;
            }
            if(tree[i] != a && b == -1) {
                b = tree[i];
                if(i>0 && tree[i-1] != tree[i]) {
                    change = i;
                }
            } else if(tree[i] == a || tree[i] == b) { // both a and b are defined and ith element is equal to one of them
                if(i>0 && tree[i-1] != tree[i]) {
                    change = i;
                }
            } else if(tree[i] != a && tree[i] != b) { // this is a new kind of tree so we will reset the values of a, b and start
                max = Math.max(max, i-start);
                start = change;
                if(change != -1) {
                    a = tree[start];
                    change = i;
                    b = tree[i];
                }
            }
        }

        max = start != -1 ? Math.max(max, tree.length -start): max;

        return max;

    }

    /*public int totalFruit(int[] tree) {
        if(tree.length == 0) {return 0;}
        if(tree.length == 1) {return 1;}

        int bagA = -1;
        int bagB = -1;
        int bagACount = 0;
        int bagBCount = 0;

        int max = Integer.MIN_VALUE;
        for(int i =0; i<tree.length-1; i++) {
            int a = tree[i];
            if(tree[i] == -1) {
                continue;
            }
            bagA = tree[i];
            bagACount++;

            for(int j = i+1; j<tree.length; j++) {
                int x = tree[j];
                if(tree[j] == bagA) {
                    bagACount++;
                    continue;
                }
                if(bagB == -1 && tree[j] != -1 ) {
                    bagB = tree[j];
                    bagBCount++ ;
                } else if(bagB != -1 && bagA != -1){
                    if(tree[j] == bagA) {bagACount++;}
                    if(tree[j] == bagB) {bagBCount++;}
                    if(tree[j] != bagA && tree[j] != bagB) {
                        break;
                    }
                }

            }
            max = Math.max(max, bagACount+bagBCount);
            bagACount = 0;
            bagBCount = 0;
            bagA = -1;
            bagB = -1;

        }
        return max;
    }*/
}
