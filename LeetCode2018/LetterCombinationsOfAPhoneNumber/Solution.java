class Solution {
    
    Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
       
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        helper(0, digits, "", res);
        return res;
    }
    
    public void helper(int index, String digits, String curr, List<String> res){
        if(index == digits.length()){
            res.add(curr);
            return;
        }
        char c = digits.charAt(index);
        String padString = map.get(c);
        for(char e : padString.toCharArray()){
            helper(index+1, digits, curr + e, res);
        }
        
    }
}