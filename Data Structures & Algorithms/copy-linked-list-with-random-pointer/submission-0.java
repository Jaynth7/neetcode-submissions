/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//Solvable using Two seperate iterations
class Solution {
    //Will store our copies in the initial run
    Map<Node, Node> map ;
    public Node copyRandomList(Node head) {

       if(head == null){
        return head;
       }

       map = new HashMap<>();

       Node temp = head;

        //Intial loop
       while(temp != null){
        //Mapping Org -> Copy
        map.put(temp , new Node(temp.val));
        temp = temp.next;
       }
       
       //Reassign
       temp = head;


        while(temp !=  null){
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);

            temp = temp.next;
        }


        return map.get(head);


    }
}
