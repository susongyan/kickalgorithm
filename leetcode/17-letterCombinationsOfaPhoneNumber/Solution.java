package algrithm;

class Solution {
    String[] letterMap= new String[]{
        "  ",  // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };

    List<String>  result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length() == 0){
            return result;
        }
        findCombination(digits,0,"");
        return result;
    }

    private void findCombination(final String digits, int index, String s){
        if(index == digits.length()) {
            result.add(s);
            return;
        }

        int digit = Integer.parseInt(digits.charAt(index)+"");
        String letters = letterMap[digit];
        for(int i = 0; i < letters.length(); i++){
            findCombination(digits, index+1, s+letters.charAt(i));
        }
    }
}