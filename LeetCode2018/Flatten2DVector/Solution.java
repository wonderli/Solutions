class Vector2D {
    int[][] arr;
    int i = 0;
    int j = 0;
    public Vector2D(int[][] v) {
        arr = v;
    }

    public int next() {
        if(!hasNext()) return -1;
        int ret = arr[i][j];
        j++;
        return ret;
    }
    private void update(){
        while(i < arr.length && j == arr[i].length){
            i++;
            j = 0;
        }
    }

    public boolean hasNext() {
        update();
        return i < arr.length;
    }
    
}
