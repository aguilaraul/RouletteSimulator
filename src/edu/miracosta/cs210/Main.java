/**
* Program Name: Final Group Project - Roulette Simulator
*
* Program Description: A roulette simulator in Java.
*
* Date Created: 05/26/2021 
*
* Author: Evan Silverthorn, Robert Edmonston 
* Email: silvee49322@gmail.com, bedmonston@icloud.com
*
* Updated:
*/

import java.util.Scanner;

class Main{

    public static void main(String[] args) {
      Player account = loadPlayer();
      boolean keepPlaying = true;
      while (keepPlaying)
      {
        Bet bet = createBet(account);
        if (bet == null) {
          keepPlaying = false;
          continue;
        }
        RouletteSpin spin = RouletteWheel.spin();
        if (bet.isWinner(spin)) {
          System.out.println("You won!!!!");
          int newBalance = account.getBalance() + bet.payout();
          account.setBalance(newBalance);
        } else {
          System.out.println("You lost :(");
          int newBalance = account.getBalance() - bet.getWagerAmount();
          account.setBalance(newBalance);
        }
        System.out.println("New balance is " + account.formattedBalance());
        AccountsManager.savePlayer(account);
      }
      System.out.println("Thanks for playing " + account.getName());
      System.out.println("Your ending balance is " + account.formattedBalance());
    }

    public static Bet createBet(Player player) // doesn't need to pass in object, we just need
    {                                          // the player's balance #cleanup
      Bet bet = null;
      Scanner in = new Scanner(System.in);
      System.out.println("How much would you like to wager? (enter 0 to stop playing)");
      int amount = -1;
      do {
        if (amount > player.getBalance()) {
          System.out.println("Amount must not exceed account balance of " + player.formattedBalance());
          System.out.println("How much would you like to wager?");
        }
        amount = in.nextInt();
        if (amount <= 0) {
          return null;
        }
      } while (amount > player.getBalance());
      /* creatBet should end here */

      /* Choosing type of bet begins here */
      // Display menu first. Should be it's own function
      System.out.println("What type of bet would you like to make? (1-3 or 0 to exit)");
      System.out.println("1) Number Bet");
      System.out.println("2) Color Bet");
      System.out.println("3) Odd/Even Bet");
      int choice = in.nextInt();                // #debug Error-checking here
      switch (choice)
      {
        case 1:
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
          bet = numberBet;
        break;

        case 2:
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
          bet = colorBet;
        break;

        case 3:
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
          bet = oebet;
        break;

        default:
          // Offensive programming - Be sure the code in each case
          // statement's deafult clause fails hard (aborts program) or
          // otherwise impossible to overlook #debug
        return null;
      }
      in.close();
      System.out.println("Your $" + bet.getWagerAmount() + " wager has been placed!");
      return bet;
    }

    public static Player loadPlayer()
    {
      Player player;
      System.out.println("Welcome to the Roulette Simulator!");
      System.out.println("Please enter your name : ");
      Scanner input = new Scanner(System.in);
      String name = input.next();
      input.close();
      player = AccountsManager.loadPlayer(name);
      System.out.println("Welcome " + player.getName() + ". Your account balance is " + player.formattedBalance());
      return player;
    }

}
