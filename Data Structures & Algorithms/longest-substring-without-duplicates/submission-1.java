class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // char → last seen index
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // if we've seen this char AND it's inside our current window
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1; // jump left past the duplicate instantly
            }

            map.put(c, right);  // update last seen index
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}