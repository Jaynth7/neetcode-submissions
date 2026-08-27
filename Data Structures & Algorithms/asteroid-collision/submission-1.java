class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        
        //if moving in the opposite direction - means that it will collide
        //if(n > 0 && incomingAsteroid(ia) < 0)
        //if(ia < n){ dont add ia} , if(n < ia) {pop n and push ia} -> repeats , keep on checking the top   with the current asteroid
        //if(math.abs(ia) == n), then pop n and dont push ia


        for(int ast = 0 ; ast < asteroids.length ; ast++){
            int a = asteroids[ast];


            while(!stack.isEmpty() && stack.peek() > 0 && a < 0){
               int diff = stack.peek() + a;

               //if diff negative , it means that the current asteroid is bigger
               if(diff < 0){
                stack.pop();
               //if diff is positive , it means that its moving in the same direction 
               }else if(diff > 0){
                a = 0;
               }else {
                a = 0;
                //if diff is zero , both are equal and gonna collide.
                stack.pop();
               }
            }

            if(a != 0){
                stack.add(a);
            }
        }
        //Convert into an array
        return stack.stream().mapToInt(i -> i).toArray();

    }
}