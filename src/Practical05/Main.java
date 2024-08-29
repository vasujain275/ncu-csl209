package Practical05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDoubly Linked List Operations:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from position");
            System.out.println("7. Display list");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    list.insertAtBeginning(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to insert: ");
                    list.insertAtEnd(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    list.insertAtPosition(value, position);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    list.deleteFromPosition(scanner.nextInt());
                    break;
                case 7:
                    System.out.println("Current list:");
                    list.display();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at the beginning.");
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Inserted " + data + " at the end.");
    }

    public void insertAtPosition(T data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        System.out.println("Inserted " + data + " at position " + position + ".");
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        T deletedData = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Deleted " + deletedData + " from the beginning.");
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        T deletedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Deleted " + deletedData + " from the end.");
    }

    public void deleteFromPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid operation");
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node<T> current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return;
        }

        T deletedData = current.data;
        if (current == tail) {
            deleteFromEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Deleted " + deletedData + " from position " + position + ".");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}