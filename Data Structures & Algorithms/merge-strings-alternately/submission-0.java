class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sc = new StringBuilder();
        int min = Math.min(word1.length() , word2.length());

        for(int i = 0 ; i < min ; i++){
            sc.append(word1.charAt(i));
            sc.append(word2.charAt(i));
        }

        sc.append(word1.substring(min));
        sc.append(word2.substring(min));
        //if there is something left , it will append it 

        return sc.toString();

        
    }
}