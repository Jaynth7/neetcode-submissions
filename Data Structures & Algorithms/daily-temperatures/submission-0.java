class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i= 0 ; i < temperatures.length ; i++){
            //The while condition is to resolve all waiting days that are cooler than today
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){

                //First step is to get the index of the element that is lower than us
                int indexOfChange = stack.pop();
                //Go to that index and update it 
                answer[indexOfChange] = i - indexOfChange;
            }
            //when the current element is not greater than the previous element if any
            stack.push(i);
        }


        return answer;
    }
}
