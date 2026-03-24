import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();

        // Count characters in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = map.size();
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Try shrinking
            while (left <= right && formed == required) {
                char ch = s.charAt(left);

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                window.put(ch, window.get(ch) - 1);

                if (map.containsKey(ch) && window.get(ch) < map.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}