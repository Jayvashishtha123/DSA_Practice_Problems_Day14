import java.util.Scanner;

// Person class
class Person {
    String name;
    String type; // deposit or withdraw
    int amount;

    Person(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }
}

// Queue implementation using array
class Queue {
    private Person[] queue;
    private int front, rear, size;

    Queue(int capacity) {
        queue = new Person[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(Person p) {
        queue[++rear] = p;
        size++;
    }

    Person dequeue() {
        size--;
        return queue[front++];
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }
}

public class Simulate_Banking_Cash_Counter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial cash balance: ");
        int balance = sc.nextInt();

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        Queue queue = new Queue(n);

        // Input panel
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Transaction (deposit/withdraw): ");
            String type = sc.next();

            System.out.print("Amount: ");
            int amount = sc.nextInt();

            queue.enqueue(new Person(name, type, amount));
        }

        // Process queue
        System.out.println("\n--- Processing Transactions ---");

        while (!queue.isEmpty()) {
            Person p = queue.dequeue();

            if (p.type.equalsIgnoreCase("deposit")) {
                balance += p.amount;
                System.out.println(p.name + " deposited " + p.amount +
                        " | Balance: " + balance);
            }
            else if (p.type.equalsIgnoreCase("withdraw")) {
                if (balance >= p.amount) {
                    balance -= p.amount;
                    System.out.println(p.name + " withdrew " + p.amount +
                            " | Balance: " + balance);
                } else {
                    System.out.println(p.name + " withdrawal of " + p.amount +
                            " failed (Insufficient Balance)");
                }
            }
        }

        System.out.println("\nFinal Cash Balance: " + balance);

        sc.close();
    }
}
