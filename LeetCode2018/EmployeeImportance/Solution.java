import java.util.*;
public class Solution{
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            int key = e.id;
            map.put(key, e);
        }
        return getImportance(map.get(id), map);
    }
    public int getImportance(Employee e, Map<Integer, Employee> map){
        List<Integer> list = e.subordinates;
        if(list.isEmpty()){
            return e.importance;
        }
        int result = 0;
        List<Employee> l = new ArrayList<>();
        for(Integer i : list){
            l.add(map.get(i));
        }
        for(Employee employee : l){
            result += getImportance(employee, map);
        }
        return result + e.importance;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}


class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
