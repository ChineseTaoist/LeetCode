public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        int[] maxLength = new int[s.length()];
        int max = 1;
        for (int i = 0; i < s.length(); i++){
            int lastLength = i > 0 ? maxLength[i - 1] : 0;
            int startSearchPos = lastLength <= 1 ? i + 1 : i + lastLength;
            startSearchPos = s.length() < startSearchPos ? s.length() : startSearchPos;
            String subStr = s.substring(i, startSearchPos);
            for (int j = startSearchPos; j < s.length(); j++){
                if (!subStr.contains(s.substring(j, j + 1))){
                    subStr += s.charAt(j);
                    maxLength[i] = subStr.length() - 1;
                    max = max < maxLength[i] + 1 ? maxLength[i] + 1 : max;
                }else {
//                    maxLength[i] = subStr.length() - 1;
//                    max = max < maxLength[i] + 1 ? maxLength[i] + 1 : max;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int res = lengthOfLongestSubstring.lengthOfLongestSubstring("gaaqfeqlqky");
    }
}
