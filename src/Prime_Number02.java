import java.util.*;

public class Prime_Number02 {
    // Check if number is prime
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // Check if two numbers are anagrams
    public static boolean isAnagram(int a, int b) {
        char[] x = String.valueOf(a).toCharArray();
        char[] y = String.valueOf(b).toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x, y);
    }

    public static boolean isPalindrome(int n) {
        int original = n;
        int reverse = 0;

        while (n > 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }
        return original == reverse;
    }

    public static void main(String[] args) {

        List<Integer> primes = new ArrayList<>();

        //  Collect prime numbers
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i))
                primes.add(i);
        }

        // Find Anagram Primes
        System.out.println("Anagram Prime Numbers:");
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (isAnagram(primes.get(i), primes.get(j))) {
                    System.out.println(primes.get(i) + " , " + primes.get(j));
                }
            }
        }

        //  Find Palindrome Primes
        System.out.println("\nPalindrome Prime Numbers:");
        for (int prime : primes) {
            if (isPalindrome(prime)) {
                System.out.print(prime + " ");
            }
        }
    }
}
