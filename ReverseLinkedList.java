package acn;//1 -> 2 -> 3 ->4 -> 5return reverse linked list

class Node {
    public Node next;
    public int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public  class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        printList(reverseLinkedList(head));

    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data +" -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}


