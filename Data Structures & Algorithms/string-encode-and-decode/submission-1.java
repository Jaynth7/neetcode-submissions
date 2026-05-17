
class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int lengthPointer = 0;
        
        while (lengthPointer < str.length()) {
            int hashPointer = lengthPointer;
            
            // Scan until we hit the delimiter
            while (str.charAt(hashPointer) != '#') {
                hashPointer++;
            }
            
            // Extract the length of the upcoming string
            int lengthOfString = Integer.parseInt(str.substring(lengthPointer, hashPointer));
            
            // Move the length pointer right past the '#' character
            lengthPointer = hashPointer + 1;
            
            // Extract the actual string using the length value
            result.add(str.substring(lengthPointer, lengthPointer + lengthOfString));
            
            // Move the length pointer to the start of the next chunk
            lengthPointer = lengthPointer + lengthOfString;
        }
        
        return result;
    }
}