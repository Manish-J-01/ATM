package com.manish;

import java.util.Scanner;

public class ATMMachine {
    private static Scanner in = new Scanner(System.in);
    private static double balance = 0; // initial balance is 0 for everyone
    private double anotherTransaction;

    public static void main(String[] args) {

        transaction();

    }
    private static void transaction() {
        // most of work done
        int choice;

        System.out.println("Please select an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");

        choice = in.nextInt();

        switch(choice){
            case 1:
                double amount;
                System.out.println("Please enter amount to withdraw: ");
                amount = in.nextDouble();
                if(amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction();// ask if they want another transaction
                }else {
                    // they have some cash
                    // update balance
                    balance = balance - amount;
                    System.out.println("You have withdraw "+amount+" and your new balance is "+balance+"\n");
                    anotherTransaction();
                }
                break;
            case 2:
                // option 2 depositing
                double deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit = in.nextDouble();
                // update balance
                balance = deposit + balance;
                System.out.println("You have deposited "+deposit+" new balance is "+balance+"\n");
                anotherTransaction();
                break;
            case 3:
                // this option is to check balance
                System.out.println("Your balance is "+balance+"\n");
                anotherTransaction();
                break;
            default:
                System.out.println("Invalid option:\n\n");
                break;
                //anotherTransaction();
               //break;

        }

    }
    private static void anotherTransaction() {
        System.out.println("Do you want another transaction ?\n\nPress 1 for another transaction\n2 To exit.");
        int anotherTransaction = in.nextInt();
        if(anotherTransaction == 1) {
            transaction();
        }else if (anotherTransaction == 2){
            System.out.println("Thanks for choosing us. Good Bye!");
        }else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
}
