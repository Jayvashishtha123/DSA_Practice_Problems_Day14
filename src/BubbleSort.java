import java.util.Scanner;

public class BubbleSort {

    // Bubble Sort logic
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Pairwise comparison
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: stop if already sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of elements
        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read integers
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort using Bubble Sort
        bubbleSort(arr);

        // Print sorted list
        System.out.println("Sorted List:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
