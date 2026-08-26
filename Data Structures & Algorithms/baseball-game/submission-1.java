class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (String c : operations) {

            if (c.equals("C")) {
                stack.pop();

            } else if (c.equals("D")) {
                stack.push(stack.peek() * 2);

            } else if (c.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.peek();

                stack.push(n1);
                stack.push(n1 + n2);

            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}