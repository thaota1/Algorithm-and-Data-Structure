import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}


class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void eliminate(int start, int count) {
        Node current = head;
        Node previous = null;

        while (size > 0) {
            for (int i = 1; i < start; i++) {
                previous = current;
                current = current.next;
            }

            System.out.println("Eliminating person " + current.data);

            if (previous == null) {
                head = current.next;
                tail.next = head;
            } else {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous;
                }
            }

            size--;

            for (int i = 0; i < count - 1; i++) {
                previous = current;
                current = current.next;
            }
        }
    }
}


class josephus_problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();
        System.out.print("Enter the number used for counting off: ");
        int count = scanner.nextInt();
        System.out.print("Enter the number of the person where counting starts (usually 1): ");
        int start = scanner.nextInt();

        CircularLinkedList circle = new CircularLinkedList();
        for (int i = 1; i <= numPeople; i++) {
            circle.insert(i);
        }

        circle.eliminate(start, count);
    }
}