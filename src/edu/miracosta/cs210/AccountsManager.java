/**
* File Name: Accounts.java
*
* File Description: 
*
* Date Created: 05/26/2021 
*
* Author: Evan Silverthorn, Robert Edmonston 
* Email: silvee49322@gmail.com, bedmonston@icloud.com
*
* Updated:
*/

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class AccountsManager {

  public AccountsManager() {
    
  }

  public static void savePlayer(String name, int balance) {
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

  public static Player loadPlayer(String name)
  {
    int balance = 1000;
    String filename = name.toLowerCase() + ".txt";
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println("Returning user - loading previous account balance...");
        balance = Integer.parseInt(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Seems like you are a new user, " + name + ". You will start with a bankroll of $1000.00!");
      savePlayer(name, balance);
    }
    return new Player(name, balance);
  }

}