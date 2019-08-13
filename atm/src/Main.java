/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ty
 */
import java.util.Scanner;
public class Main {

private double currentBal =1000;
Scanner input = new Scanner(System.in);

public void mainMenu(){
    int selection;

        System.out.print("Welcome to the Automated Teller Machine!\n");
        System.out.println("Select from the following menu options below:\n");
        System.out.println("========================");
        System.out.println("| [1]  Check Balance   |");
        System.out.println("| [2]  Withdrawal      |");
        System.out.println("| [3]  Deposit         |");
        System.out.println("| [4]  Exit            |");
        System.out.println("========================");
        System.out.print("Please select your option now: ");
        selection =input.nextInt();

switch (selection){
    case 1:
        viewBalance();
        break;
    case 2:
        withdrawFunds();
        break;
    case 3:
        depositFunds();
        break;
    case 4:
        System.out.println("Thank you for using ATM! \n Goodbye! \n");
}
}

public void viewBalance() {
    int selection1;
    System.out.println("You have selected Balance.\n");
    System.out.println("\t-- Your Current Balance is:$ " + currentBal);
    System.out.println("Return to main menu? \n [1] for YES \n");
    selection1 =input.nextInt();

switch (selection1){
    case 1:
        mainMenu();
        break;
}

}
public void withdrawFunds() {
    int withdrawSelection;

    System.out.println("Amount to withdraw: ");
    System.out.println("[1] - $20");
    System.out.println("[2] - $40");
    System.out.println("[3] - $50");
    System.out.println("[4] - $100");
    System.out.println("[5] - MAIN MENU");
    System.out.print("Please select your option now: ");
    withdrawSelection =input.nextInt();

switch (withdrawSelection){
    case 1:
        accountWithdraw(20);
        mainMenu();
        break;
    case 2:
        accountWithdraw(40);
        mainMenu();
        break;
    case 3:
        accountWithdraw(50);
        mainMenu();
        break;
    case 4:
        accountWithdraw(100);
        mainMenu();
        break;
    case 5:
        mainMenu();
        break;
}

}
public void accountWithdraw(int withdrawFunds){
    currentBal = currentBal -withdrawFunds;
    System.out.println("Please take your funds.");
}
public void depositFunds(){
    int addSelection;

    System.out.println("Amount to deposit: ");
    System.out.println("[1] - $20");
    System.out.println("[2] - $40");
    System.out.println("[3] - $50");
    System.out.println("[4] - $100");
    System.out.println("[5] - MAIN MENU");
    System.out.print("Please select your option now: ");
    addSelection =input.nextInt();

    switch (addSelection){
    case 1:
        accountAdd(20);
        mainMenu();
        break;
    case 2:
        accountAdd(40);
        mainMenu();
        break;
    case 3:
        accountAdd(50);
        mainMenu();
        break;
    case 4:
        accountAdd(100);
        mainMenu();
        break;
    case 5:
        mainMenu();
        break;
}
}
public void accountAdd (int depositFunds){
    currentBal = currentBal +depositFunds;
    System.out.println("Thank you.");
}
    public static void main(String[] args) {
    new Main().mainMenu();
    }
}
