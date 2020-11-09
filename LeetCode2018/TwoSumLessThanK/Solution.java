import java.util.*;
class Solution {
    private class Item{
        int val;
        int index;
        public Item(int v, int i){
            val = v;
            index = i;
        }
    }
    public int twoSumLessThanK(int[] A, int K) {
        if(A.length == 1) return -1;
        int len = A.length;
        Item[] items = new Item[len];
        for(int i = 0;i < len; i++){
            items[i] = new Item(A[i], i);
        }
        Arrays.sort(items, new Comparator<Item>(){
            @Override
            public int compare(Item a, Item b){
                return a.val - b.val;
            }
        });
        
        int i = 0;
        int j = len -1;
        int max = -1;
        while(i < j){
            Item l = items[i];
            Item r = items[j];
            if(l.val + r.val < K){
                if(l.val + r.val > max){
                    max = l.val + r.val;
                }
                i++;   
            }else if(l.val + r.val >= K){
                j--;
            }
        }
        return max;
    }
}