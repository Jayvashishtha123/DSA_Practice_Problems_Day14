import java.util.*;

public class Permutations_of_string_01 {

    public static String[] permutationsRecursive(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        permute(chars, 0, result);
        return result.toArray(new String[0]);
    }
    private static void permute(char[] arr, int index, List<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1, result);
            swap(arr, index, i); // backtrack
        }
    }
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {

        String input = "ABCDE";
        String[] recursiveResult = permutationsRecursive(input);

        System.out.println("Recursive Permutations: " + Arrays.toString(recursiveResult));

    }
}
