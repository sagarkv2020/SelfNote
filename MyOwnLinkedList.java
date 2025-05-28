package acn;

public class MyOwnLinkedList {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;

    // Add to end
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Add to beginning
    public void prepend(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Delete by value
    public void deleteByValue(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // Insert at head (position 0)
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int currentIndex = 0;

        // Traverse to the node before the desired position
        while (current != null && currentIndex < position - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        // Insert new node
        newNode.next = current.next;
        current.next = newNode;
    }

    // Print the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }



    // Main method to test
    public static void main(String[] args) {
        MyOwnLinkedList list = new MyOwnLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);

        System.out.println("Linked List:");
        list.printList();  // Output: 5 -> 10 -> 20 -> 30 -> null

        list.deleteByValue(20);
        System.out.println("After deleting 20:");
        list.printList();  // Output: 5 -> 10 -> 30 -> null

        list.insertAtPosition(192, 1);
        System.out.println("After putting 192 at postion 3:");
        list.printList();  // Output: 5 -> 10 -> 30 -> null
    }
}
