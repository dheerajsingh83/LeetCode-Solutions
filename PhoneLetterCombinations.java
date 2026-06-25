import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] phone = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, digits, 0, new StringBuilder(), phone);
        return result;
    }

    private void backtrack(List<String> result, String digits, int index,
                           StringBuilder path, String[] phone) {

        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(result, digits, index + 1, path, phone);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
