import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search_word {

    public static boolean binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = arr[mid].compareTo(target);

            if (cmp == 0)
                return true;
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        String[] words = {
                "apple",
                "banana",
                "grape",
                "orange",
                "mango",
                "pear"
        };

        Arrays.sort(words);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter word to search: ");

        String searchWord = input.next().trim();
        input.close();

        boolean found = binarySearch(words, searchWord);

        if (found)
            System.out.println("Word FOUND in the list");
        else
            System.out.println("Word NOT FOUND in the list");
    }
}
