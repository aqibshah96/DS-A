public class LinkedList {
    node head;

    class node {
        String data;
        node next;

        // constructor
        node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private LinkedList() {
        head = null;
    }

    // add to list and replace the head, a stack
    public void addStart(String data) {
        node temp = new node(data);
        if (head != null) {
            temp.next = head;
        }
        head = temp;
    }

    // add to list at the end, a queue
    public void append(String data) {
        node temp = new node(data);
        if (head == null) {
            head = temp;
            return;
        }
        node iterate = head;
        while (iterate.next != null) {
            iterate = iterate.next;
        }
        iterate.next = temp;
    }

    // add a node after a given node using the nodes string value to find location
    // using string comparison
    public void addAfter(String data, String toAdd) {
        node temp = new node(toAdd);
        if (head == null) {
            head = temp;
            return;
        }
        node iterate = head;
        // traverse to where node is
        while (!iterate.data.equals(data)) {
            iterate = iterate.next;
        }
        temp.next = iterate.next;
        iterate.next = temp;
        return;

    }

    // given a string, delete the node
    public void delete(String data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        node iterate = head;
        // if node to be deleted is head
        if (iterate.data.equals(data)) {
            head.data = null;
            head = head.next;
        }
        // if node to be deleted is in the middle
        while (iterate.next != null) {
            if (iterate.next.data.equals(data)) {
                node temp = iterate.next.next;
                iterate.next.data = null;
                iterate.next = null;
                iterate.next = temp;
                return;
            }
            iterate = iterate.next;
        }
        // if node to be deleted is tail
        if (iterate.data.equals(data)) {
            iterate.data = null;
        }
    }

    void printList() {
        node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.addStart("hey");
        list.addStart("what's up");
        list.addStart("hello");
        list.addAfter("hello", "seen");
        list.delete("hey");
        list.printList();
    }

}