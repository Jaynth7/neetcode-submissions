class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            switch(str){
                //inclusion of curly brackets bcz java wont allow the redeclaration bcz it belongs to the same scope
                case "+":{
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                break;
            }
                case "-":{
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                break;
            }
                case "/":{
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                break;
            }
                case "*":{
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                break;
            }
                default:
                    stack.push(Integer.parseInt(str));
                break;
            }
        }
        return stack.pop();
    }
}