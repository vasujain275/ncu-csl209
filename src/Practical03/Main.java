package Practical03;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        // Read numbers into the array
        System.out.println("Enter 5 integer numbers:");
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }

        // Calculate sum of all elements
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum of all elements: " + sum);

        // Calculate sum of alternate elements
        int alternateSum = 0;
        for (int i = 0; i < 5; i += 2) {
            alternateSum += array[i];
        }
        System.out.println("Sum of alternate elements: " + alternateSum);

        // Find second highest element
        Arrays.sort(array);
        int secondHighest = array[array.length - 2];
        System.out.println("Second highest element: " + secondHighest);

        scanner.close();
    }
}