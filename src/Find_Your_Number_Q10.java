import java.util.Scanner;

public class Find_Your_Number_Q10 {

    public static void guessNumber(int low, int high, Scanner sc) {

        if (low == high) {
            System.out.println("Your number is: " + low);
            return;
        }

        int mid = low + (high - low) / 2;

        System.out.println("Is your number between " + low + " and " + mid + "? (true/false)");

        boolean answer = sc.nextBoolean();

        if (answer) {
            guessNumber(low, mid, sc);
        } else {
            guessNumber(mid + 1, high, sc);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take n from user
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        int N = (int) Math.pow(2, n);

        // Ask user to think of a number
        System.out.println("Think of a number between 0 and " + (N - 1));

        //  Start guessing
        guessNumber(0, N - 1, sc);

        sc.close();
    }
}
