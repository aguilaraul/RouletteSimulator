package edu.miracosta.cs210.roulettesimulator;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public final class AccountsManager {

  /**
   * Private constructor so no one can instantiate the class
   */
  private AccountsManager() {
  }

  /**
   * Static to class instance of the class
   */
  private static final AccountsManager INSTANCE = new AccountsManager();

  /**
   * To be called by user to obtain instance of class
   * @return instance of the singleton
   */
  public static AccountsManager getInstance() { return INSTANCE; }

  public void savePlayer(String name, int balance) {
    String filename = name.toLowerCase() + ".txt";
    try {
      PrintWriter pw = new PrintWriter(filename);
      pw.println(balance);
      pw.close();
    } catch (IOException ie) {
      System.out.println("Unable to save user data.");
      ie.printStackTrace();
    }
  }

  public Player loadPlayer(String name) {
    int balance = 1000;
    String filename = name.toLowerCase() + ".txt";
    try {
      Scanner myReader = new Scanner(new File(filename));
      while (myReader.hasNextLine()) {
        System.out.println("Returning user - loading previous account balance...");
        String data = myReader.nextLine();
        balance = Integer.parseInt(data);
        System.out.println("You're balance is: $" + balance);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Seems like you are a new user, " + name + ". You will start with a bankroll of $1000.00!");
      savePlayer(name, balance);
    }
    return new Player(name, balance);
  }

}