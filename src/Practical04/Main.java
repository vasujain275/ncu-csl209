package Practical04;

class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }
}

class LinkedList<T> {
    private Node<T> head;
    private int length;

    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        length++;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);

        list.printList();
    }
}