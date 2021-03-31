import java.util.*;
class HtWt implements Comparable{
    public int height;
    public int weight;
    public HtWt(int h, int w) {
       height = h;
       weight = w;
    }
    public int compareTo(Object o) {
        HtWt second = (HtWt) o;
        if(this.height != second.height) {
            return ((Integer)this.height).compareTo(second.height);
        }else {
            return ((Integer)this.weight).compareTo(second.weight);
        }
    }
    public boolean isBefore(HtWt other){
        if(this.height < other.height && this.weight < other.weight) return true;
        else return false;
    }
    public ArrayList<HtWt> getLongestSequence(ArrayList<HtWt> items) {
        Collections.sort(items);
        return longestIncreasingSubSequence(items);
    }
    public void longestIncreasingSubSequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index) {
        if(current_index >= array.size() || current_index < 0) return;
        HtWt current_element = array.get(current_index);
        ArrayList<HtWt> best_sequence = null;
        for(int i = 0; i < current_index; i++) {
            if(array.get(i).isBefore(current_element)) {
                best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
            }
        }
        ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
        if(best_sequence != null) {
            new_solution.addAll(best_sequence);
        }
        new_solution.add(current_element);
        solutions[current_index] = new_solution;
        longestIncreasingSubSequence(array, solutions, current_index+1);
    }
    public ArrayList<HtWt> longestIncreasingSubSequence(ArrayList<HtWt> array) {
        ArrayList<HtWt> solutions[] = new ArrayList[array.size()];
        longestIncreasingSubSequence(array, solutions, 0);
        ArrayList<HtWt> best_sequence = null;
        for(int i = 0; i < array.size(); i++) {
            best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
        }
        return best_sequence;
    }
    public ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if(seq1 == null) return seq2;
        if(seq2 == null) return seq1;
        return seq1.size() > seq2.size() ? seq1:seq2;
    }
    public static void main(String[] args) {

        HtWt h1 = new HtWt(65, 100);
        HtWt h2 = new HtWt(70, 150);
        HtWt h3 = new HtWt(56, 90);
        HtWt h4 = new HtWt(75, 190);
        HtWt h5 = new HtWt(60, 95);
        HtWt h6 = new HtWt(68, 110);
        HtWt t = new HtWt(0,0);
        ArrayList<HtWt> list = new ArrayList<HtWt>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        list.add(h5);
        list.add(h6);
        ArrayList<HtWt> ret = t.longestIncreasingSubSequence(list);
        for(int i = 0; i < ret.size(); i++) {
            System.out.print("(" + ret.get(i).height + ", " + ret.get(i).weight + ")" + " ");
        }

    }
}
