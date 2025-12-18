import java.util.Scanner;

public class Merge_Sort {

    // Merge Sort using a[lo, hi)
    public static void mergeSort(String[] a, int lo, int hi) {

        // Base case
        if (hi - lo <= 1) {
            return;
        }

        // Reduction step
        int mid = lo + (hi - lo) / 2;

        // Sort left and right halves
        mergeSort(a, lo, mid);
        mergeSort(a, mid, hi);

        // Merge sorted halves
        merge(a, lo, mid, hi);
    }

    // Merge two sorted subarrays a[lo, mid) and a[mid, hi)
    private static void merge(String[] a, int lo, int mid, int hi) {

        String[] temp = new String[hi - lo];
        int i = lo, j = mid, k = 0;

        while (i < mid && j < hi) {
            if (a[i].compareTo(a[j]) <= 0) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i < mid) {
            temp[k++] = a[i++];
        }

        while (j < hi) {
            temp[k++] = a[j++];
        }

        // Copy back to original array
        for (int x = 0; x < temp.length; x++) {
            a[lo + x] = temp[x];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] arr = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        // Perform merge sort
        mergeSort(arr, 0, arr.length);

        // Output
        System.out.println("Sorted List:");
        for (String s : arr) {
            System.out.println(s);
        }

        sc.close();
    }
}
