import java.util.Arrays;
import java.util.Scanner;

public class Anagram_Detection {

    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        char[] a = s1.toLowerCase().toCharArray();
        char[] b = s2.toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        if (isAnagram(str1, str2))
            System.out.println("The Two Strings are Anagram");
        else
            System.out.println("The Two Strings are NOT Anagram");

        sc.close();
    }
}
