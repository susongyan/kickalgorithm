
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
判断回文字符串，只判断字符和数字，不区分大小写

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Tn = O(n);
Sn = O(1);

*/
class Solution {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            while (!Character.isLetterOrDigit(s.charAt(low)) && low < high) {
                low++;
            }
            while (!Character.isLetterOrDigit(s.charAt(high)) && low < high) {
                high--;
            }

            if (low < high) {
                if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
                    return false;
                low++;
                high--;
            }

        }
        return true;
    }
}