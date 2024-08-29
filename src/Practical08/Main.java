package Practical08;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        String reversedSentence = reverseSentence(sentence);
        System.out.println("Reversed sentence:");
        System.out.println(reversedSentence);

        scanner.close();
    }

    public static String reverseSentence(String sentence) {
        Stack<String> stack = new Stack<>();
        String[] words = sentence.split("\\s+");

        // Push words onto the stack
        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversedSentence = new StringBuilder();

        // Pop words from the stack to reverse the order
        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop());
            if (!stack.isEmpty()) {
                reversedSentence.append(" ");
            }
        }

        return reversedSentence.toString();
    }
}