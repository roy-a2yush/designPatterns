package org.example.oopconcepts;

class BankAccount {
    // Private fields (Encapsulated data)
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getter Methods (Controlled Access)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter Method (Controlled Modification)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Additional Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

// Main Class
public class EncapsulationExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("New Balance: " + account.getBalance());
    }
}
