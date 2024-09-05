package Practical06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCircular Doubly Linked List Operations:");
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

class CircularDoublyLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = this;
            this.next = this;
        }
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at the beginning.");
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        System.out.println("Inserted " + data + " at the end.");
    }

    public void insertAtPosition(T data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1 || head == null) {
            insertAtBeginning(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int currentPosition = 1;

        do {
            if (currentPosition == position) {
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                System.out.println("Inserted " + data + " at position " + position + ".");
                return;
            }
            current = current.next;
            currentPosition++;
        } while (current != head);

        System.out.println("Position out of range. Inserting at the end.");
        insertAtEnd(data);
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        T deletedData = head.data;
        if (head.next == head) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }
        System.out.println("Deleted " + deletedData + " from the beginning.");
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        T deletedData = head.prev.data;
        if (head.next == head) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
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

        do {
            if (currentPosition == position) {
                T deletedData = current.data;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                if (current == head) {
                    head = head.next;
                }
                System.out.println("Deleted " + deletedData + " from position " + position + ".");
                return;
            }
            current = current.next;
            currentPosition++;
        } while (current != head);

        System.out.println("Position out of range");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}