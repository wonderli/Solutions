class Solution {
    
    private class Item{
        int val;
        int index;
        public Item(int v, int i){
            val = v;
            index = i;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        Item[] items = new Item[n];
        for(int i = 0; i < n;i++){
            items[i] = new Item(nums[i], i);
        }
        mergeSort(items, 0, n-1, count);
        List<Integer> res = new ArrayList<>();
        for(int c : count){
            res.add(c);
        }
        return res;
    }
    
    private void mergeSort(Item[] items, int low, int high, int[] count){
        if(low >= high) return;
        int mid = low + (high - low)/2;
        mergeSort(items, low, mid, count);
        mergeSort(items, mid+1, high, count);
        merge(items, low, mid, mid+1, high, count);
    }
    private void merge(Item[] items, int low, int lowEnd, int high, int highEnd, int[] count){
        int m = highEnd - low + 1;
        Item[] sorted = new Item[m];
        int rightCounter = 0;
        int l = low;
        int h = high;
        int index = 0;
        while(l <= lowEnd && h <= highEnd){
            if(items[h].val < items[l].val){
                rightCounter++;
                sorted[index] = items[h];
                h++;
            }else{
                count[items[l].index] += rightCounter;
                sorted[index] =items[l];
                l++;
            }
            index++;
        }
        while(l <= lowEnd){
            count[items[l].index] += rightCounter;
            sorted[index]= items[l];
            index++;
            l++;
        }
        
        while(h <= highEnd){
            sorted[index] = items[h];
            index++;
            h++;
        }
        System.arraycopy(sorted, 0, items, low, m);
    }
}