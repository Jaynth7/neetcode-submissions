

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;  // ❌ was target.length — target is an int, not an array

        // ❌ you were sorting position[] directly — can't use comparator on int[]
        // ✅ first build a 2D array pairing position+speed together
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]); // ✅ now sorting int[][] works fine

        // was Stack<Integer> — time is a double, can't push double into Integer stack
        Stack<Double> stack = new Stack<>();

        // was iterating position[] (int[]) as int[] — now iterating cars (int[][])
        for (int[] car : cars) {
            double time = (double)(target - car[0]) / car[1]; // ✅ car[0]=pos, car[1]=speed

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}