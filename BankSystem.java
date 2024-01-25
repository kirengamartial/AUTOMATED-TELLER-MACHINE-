import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private Map<String, Account> accounts;
    private Scanner scanner;

    public BankSystem() {
        this.accounts = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            Account account = new Account(accountNumber, initialBalance);
            accounts.put(accountNumber, account);
            System.out.println("Account " + accountNumber + " created with initial balance: $" + initialBalance);
        }
    }

    public double getBalance(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void performTransaction() {
        System.out.println("\nChoose a transaction:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1:
                deposit(accountNumber, amount);
                break;
            case 2:
                withdraw(accountNumber, amount);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        // Create some initial accounts
        // bank.createAccount("12345", 1000);
        // bank.createAccount("67890", 500);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Balance");
            System.out.println("2. Transaction");
            System.out.println("3. Open an Account");
            System.out.println("4. Exit");

            int choice = bank.scanner.nextInt();
            bank.scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = bank.scanner.next();
                    System.out.println("Balance of account " + accountNumber + ": $" + bank.getBalance(accountNumber));
                    break;
                case 2:
                    bank.performTransaction();
                    break;
                case 3:
                    bank.createAccount();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
