public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s;
        }
        int maxLength = 0;
        String longestSubStr = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++){
            if (i + maxLength >= s.length()){
                break;
            }
            for (int j = i + maxLength; j < s.length(); j++){
                String subStr = s.substring(i, j + 1);
                if (isPalindromic(subStr)){
                    maxLength = subStr.length();
                    longestSubStr = subStr;
                }
            }
        }
        return longestSubStr;
    }
    // todo: 法二：对每种边界情况进行枚举


    private boolean isPalindromic(String s){
        for (int i = 0; i < s.length() / 2 + 1; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        longestPalindrome.longestPalindrome("1234");
    }
}
