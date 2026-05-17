class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
    Map<String , List<String>> map = new HashMap<>();

    for(String s : strs){
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }


        StringBuilder sn = new StringBuilder();

        for(int val : count){
            sn.append('#').append(val);
        };

        String key = sn.toString();

        map.computeIfAbsent(key , k-> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(map.values());

    }
}
