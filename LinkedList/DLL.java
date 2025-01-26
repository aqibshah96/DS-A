
//class for doubly linked list 
public class DLL {
    Node head;

    // class for how to make a node
    private class Node {
        Node prev;
        int data;
        Node next;

        // constructor for a node
        Node(int data) {
            Node prev = null;
            this.data = data;
            Node next = null;
        }
    }

    DLL(int data) {
        Node start = new Node(data);
        head = start;
    }

    DLL() {

    }

    // function to "push" a node to the head(top) of the list
    public void push(int data) {

        /*
         * if(head != null){
         * System.out.println("Head is currently: " + head.data);
         * }
         */

        // call to node constructor
        Node newNode = new Node(data);
        newNode.prev = null;
        newNode.next = head;
        // now to check if head is null
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        System.out.println("Push worked, head is now: " + head.data);
        return;
    }

    public static void main(String[] args) {
        DLL newList = new DLL(15);
        newList.push(8);
        newList.push(9);
    }
}