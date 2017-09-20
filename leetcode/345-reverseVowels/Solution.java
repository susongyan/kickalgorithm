
/**
 * 
倒置字符串中的元音字母

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

Tn = O(n);
Sn = O(1);
 */
class Solution {
    public String reverseVowels(String s) {
         if (s == null || s.length() == 0)
             return s;
         int low = 0;
         int high = s.length() - 1;
         char temp;
         // java不能像js那样直接把字符串当做字符数组来操作，
         // 先获取字符串内部字符数组，然后再对这个数组进行处理
         char[] chars = s.toCharArray(); 
        
         while (low < high) {
             while (!isVowel(chars[low]) && low < high) {
                 low++;
             }
             while (!isVowel(chars[high]) && low < high) {
                 high--;
             }
             if (low < high) {
                 temp = chars[low];
                 chars[low] = chars[high];
                 chars[high] = temp;
             }
             low++;
             high--;
         }
 
         return new String(chars);
     }
 
     public boolean isVowel(char c) {
         String str = String.valueOf(c);
         return str.equalsIgnoreCase("a") ||
                 str.equalsIgnoreCase("e") ||
                 str.equalsIgnoreCase("i") ||
                 str.equalsIgnoreCase("o") ||
                 str.equalsIgnoreCase("u");
     }
 }