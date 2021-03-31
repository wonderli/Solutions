class p10_5{
	public int search(String[] strings, String key, int first, int last) {
		if(key == "" || key == null || strings == null)
			return -1;
		int mid = (first + last)/2;
		int left, right;
		if(strings[mid].isEmpty()){
			left = mid - 1;
			right = mid + 1;
			while(true) {
				if(left < first || right > last)
					return -1;
				else if(left > first && (!strings[left].isEmpty())) {
					mid = left;
					break;
				}
				else if(right < last && (!strings[right].isEmpty())) {
					mid = right;
					break;
				}
				left--;
				right++;
			}
		}
		if(strings[mid].equals(key))
			return mid;
		else if(strings[mid].compareTo(key) < 0)
			return search(strings, key, mid+1, last);
		else
			return search(strings, key, first, mid - 1);
		
	}
	public static void main(String[] args) {
		String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String key = new String("car");
		int size = 13;
		p10_5 p = new p10_5();
		int ret = p.search(strings, key, 0, size - 1);
		System.out.println("Key:" + key);
		System.out.println(ret);
	}
}
