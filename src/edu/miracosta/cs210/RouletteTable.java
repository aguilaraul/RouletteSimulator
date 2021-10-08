/**
 * @Authors:  Robert Edmonston, Raul Aguilar, Austin Garrison
 * @Date:     October 7, 2021
 * FA21 CS 210 5198 Final Project
 * Roulette Simulator Application (RSA)
 * 
 * RouletteTable
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class RouletteTable {
private final int WHEELLOW = 36;
private final int WHEELHIGH = 0;
private final Scanner in = new Scanner(System.in);

private Bet bet;
private String name;
private int balance;
private int winningNumber;
private int newBalance;


  public void play(String name, int balance) {
      this.name = name;
      this.balance = balance;

      this.bet = createBet();
      if (this.bet == null) {
          System.out.println("Thanks for playing " + name);
          System.out.println("Your ending balance is " + formattedBalance(balance));
      }
      spinWheel();
      System.out.println("New balance is " + formattedBalance(balance));
  }

  public void endGame() {
      AccountsManager.savePlayer(this.name, this.balance);
      displayEndGame();
  }

  /* Placing bets */
  public Bet createBet()
  {
    this.bet = null;
    System.out.println("How much would you like to wager? (enter 0 to stop playing)");
    int amount = -1;
    do {
      if (amount > this.balance) {
        System.out.println("Amount must not exceed account balance of " + formattedBalance(this.balance));
        System.out.println("How much would you like to wager?");
      }
      if(in.hasNextInt()) {
        amount = in.nextInt();
      } else {
        amount = 0;
      }
      if (amount <= 0) {
        return null;
      }
    } while (amount > this.balance);
    /* creatBet should end here */

    /* Choosing type of bet begins here */
    // Display menu first. Should be in Text class #cleanup
    System.out.println("What type of bet would you like to make? (1-3 or 0 to exit)");
    System.out.println("1) Number Bet");
    System.out.println("2) Color Bet");
    System.out.println("3) Odd/Even Bet");
    int choice = in.nextInt();                // #debug Error-checking here
    switch (choice)
    {
      case 1:
        // Can be moved to NumberBet class and run function #cleanup
        NumberBet numberBet = new NumberBet();
        numberBet.setWagerAmount(amount);
        System.out.println
        ("Please enter the number you'd like to bet on (1-36)");
        int number = 1;
        do {
        if (number > 36 || number < 1) {
          System.out.println("Invalid entry. Number must be between 1-36.");
          System.out.println("Please enter the number you'd like to bet on (1-36)");
        }
          number = in.nextInt();
        } while (number > 36 || number < 1);
        numberBet.setNumber(number);
        this.bet = numberBet;
      break;

      case 2:
        // #cleanup
        ColorBet colorBet = new ColorBet();
        colorBet.setWagerAmount(amount);
        System.out.println("Enter '1' for Red or '2' for Black");
        int color = -1;
        do {
          color = in.nextInt();
          if (color <1 || color > 2) {
            System.out.println("Invalid Entry. Enter '1' for Red or '2' for Black");
          }
        } while (color != 1 && color !=2);
        Color aColor = (color==1) ? Color.RED : Color.BLACK;
        colorBet.setColor(aColor);
        this.bet = colorBet;
      break;

      case 3:
        // #cleanup
        OddEvenBet oebet = new OddEvenBet();
        oebet.setWagerAmount(amount);
        System.out.println("Enter '1' for odd or '2' for even");
        int oddEven = -1;
        do {
          oddEven = in.nextInt();
          if (oddEven <1 || oddEven > 2) {
            System.out.println("Invalid Entry. Enter '1' for odd or '2' for even");
          }
        } while (oddEven != 1 && oddEven !=2);
        oebet.setIsEven(oddEven==2);
        this.bet = oebet;
      break;

      default:
        // Offensive programming - Be sure the code in each case
        // statement's deafult clause fails hard (aborts program) or
        // otherwise impossible to overlook #debug
      return null;
    }
    //in.close(); #debug
    System.out.println("Your $" + bet.getWagerAmount() + " wager has been placed!");
    return bet;
  }


  /* Roulette Wheel */
  public void displaySpin()
  {
      System.out.println("Spinning wheel!");
      for (int i=0;i<400;i++)
      {
          if (i%10 == 0)
          {
              System.out.print(".");
              try {
                  Thread.sleep(125);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
      System.out.println("|" + getWinningNumber() + "|");
  }


  /* Roulette Spin */
  private void spinWheel() {
    winningNumber = (int) ((Math.random() * (WHEELHIGH - WHEELLOW)) + WHEELLOW);   
    if (bet.isWinner(winningNumber)) {
      System.out.println("You won!!!!");
      this.balance = balance + bet.payout();
      //account.setBalance(newBalance);
    } else {
      System.out.println("You lost :(");
      this.balance = balance - bet.getWagerAmount();
      //account.setBalance(newBalance);
    }
  }
  
  public int getWinningNumber() {
    return winningNumber;
  }


  /* Text Format */
  private String formattedBalance(int balance) {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    String formattedBalance = currency.format(balance);
    return formattedBalance;
  }

  public void displayEndGame() {
    System.out.println("Thanks for playing " + this.name);
    System.out.println("Your ending balance is " + formattedBalance(this.balance));
  } 

}
