/**
 * @Authors:  Robert Edmonston, Raul Aguilar, Austin Garrison
 * @Date:     October 10, 2021
 * FA21 CS 210 5198 Final Project
 * Roulette Simulator Application (RSA)
 * 
 * Based on code by:
 * Evan Silverthorn (silvee49322@gmail.com)
 * and Robert Edmonston ( bedmonston@icloud.com)
 * 
 * 
 * RouletteTable
 */

import java.util.Scanner;

public class RouletteTable {
  private final Text text = new Text();
  private final Scanner input = new Scanner(System.in);

  private Boolean keepPlaying = true;
  private Bet bet;
  private String name;
  private int balance;
  private int winningNumber;
  private int wagerAmount;

  public void RouletteTable(String name, int balance) {
    this.name = name;
    this.balance = balance;
    while(keepPlaying()) {
      play();
    }
  }

  public void play() {
    this.bet = placeBet(chooseBetType());
    if (this.bet != null) {
      spinWheel();
    } else {
      endGame();
    }
  }

  public Boolean keepPlaying() {
    return this.keepPlaying;
  }

  public void endGame() {
    System.out.println("ENDING BALANCE:" + this.balance); // #debug
    AccountsManager.savePlayer(this.name, this.balance);
    text.displayEndGame(this.name, this.balance);
    keepPlaying = false;
    System.exit(0);
  }

  /* Placing bets */
  private int chooseBetType() {
    text.displayBetMenu();
    int choice = input.nextInt();
    if(choice == 0) { // check that an integer is, in fact, entered. #error-check
      endGame();
    }
    return choice;
  }

  private int wager() {
    System.out.println("How much would you like to wager? (enter 0 to stop playing)");
    int wager = input.nextInt();

    while (wager > this.balance) {
        System.out.println("Amount must not exceed account balance of " + text.formattedBalance(this.balance));
        System.out.println("How much would you like to wager?");
      System.out.println("HERE"); // #debug
      wager = input.nextInt();
      if (wager <= 0) {
        endGame();
      }
    }
    System.out.println("Your $" + wager + " wager has been placed!");
    this.wagerAmount = wager;
    return wager;
  }


  public Bet placeBet(int choice) {
    int wager = wager();
    switch (choice) {
      case 1:
        // Can be moved to NumberBet class and run function #cleanup
        NumberBet numberBet = new NumberBet();
        numberBet.setWagerAmount(wager);
        System.out.println
        ("Please enter the number you'd like to bet on (1-36)");
        int number = 1;
        do {
        if (number > 36 || number < 1) {
          System.out.println("Invalid entry. Number must be between 1-36.");
          System.out.println("Please enter the number you'd like to bet on (1-36)");
        }
          number = input.nextInt();
        } while (number > 36 || number < 1);
        numberBet.setNumber(number);
        return this.bet = numberBet;

      case 2:
        // #cleanup
        ColorBet colorBet = new ColorBet();
        colorBet.setWagerAmount(wager);
        System.out.println("Enter '1' for Red or '2' for Black");
        int color;
        do {
          color = input.nextInt();
          if (color <1 || color > 2) {
            System.out.println("Invalid Entry. Enter '1' for Red or '2' for Black");
          }
        } while (color != 1 && color !=2);
        Color aColor = (color==1) ? Color.RED : Color.BLACK;
        colorBet.setColor(aColor);
        return this.bet = colorBet;

      case 3:
        // #cleanup
        OddEvenBet oebet = new OddEvenBet();
        oebet.setWagerAmount(wager);
        System.out.println("Enter '1' for odd or '2' for even");
        int oddEven;
        do {
          oddEven = input.nextInt();
          if (oddEven <1 || oddEven > 2) {
            System.out.println("Invalid Entry. Enter '1' for odd or '2' for even");
          }
        } while (oddEven != 1 && oddEven !=2);
        oebet.setIsEven(oddEven==2);
        return this.bet = oebet;

      case 0:
        endGame();

      default:
        // Offensive programming - Be sure the code in each case
        // statement's default clause fails hard (aborts program) or
        // otherwise impossible to overlook #debug
        System.exit(0);
      return this.bet = null;
    }
  }


  /* Roulette Wheel */
  public void displaySpin() {
    System.out.println("Spinning wheel!");
    for (int i=0;i<400;i++) {
      if (i%10 == 0) {
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
    int wheelLow = 0;
    int wheelHigh = 36;
    winningNumber = (int) ((Math.random() * (wheelHigh - wheelLow)) + wheelLow);
    displaySpin();
    if (bet.isWinner(winningNumber)) {
      System.out.println("You won!!!!");
      this.balance = balance + bet.payout();
    } else {
      System.out.println("You lost :(");
      this.balance = balance - bet.getWagerAmount();
    }
    System.out.println("New balance is " + text.formattedBalance(this.balance));
  }
  
  public int getWinningNumber() {
    return winningNumber;
  }

}
