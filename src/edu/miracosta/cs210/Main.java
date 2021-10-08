/**
 * @Authors:  Robert Edmonston, Raul Aguilar, Austin Garrison
 * @Date:     October 7, 2021
 * FA21 CS 210 5198 Final Project
 * Roulette Simulator Application (RSA)
 * 
 * 
 * 
 * Based on code by:
 * Evan Silverthorn (silvee49322@gmail.com)
 * and Robert Edmonston ( bedmonston@icloud.com)
 */

import java.util.Scanner;

class Main{

    public static void main(String[] args) {
      AccountsManager aManager = new AccountsManager();
      RouletteTable table = new RouletteTable();
      boolean keepPlaying = true;
      Player player;
      String playerName;
      int playerBalance;
      
      // Log-in
      System.out.println("Welcome to the Roulette Simulator!");
      System.out.println("Please enter your name : ");
      Scanner input = new Scanner(System.in);
      String name = input.next();
      input.close();
      player = AccountsManager.loadPlayer(name);
      playerName = player.getName();
      playerBalance = player.getBalance();

      // #debug
      System.out.println("Player name:" + playerName);
      System.out.println("Player balance:" + playerBalance);
      
      // Gameplay
      while (keepPlaying)
      {
        table.play(playerName, playerBalance);
      }
      table.endGame();
    }

    // public static Player loadPlayer()
    // {
    //   Player player;
    //   System.out.println("Welcome to the Roulette Simulator!");
    //   System.out.println("Please enter your name : ");
    //   Scanner input = new Scanner(System.in);
    //   String name = input.next();
    //   input.close();
    //   player = AccountsManager.loadPlayer(name);
    //   playerName = player.getName();
    //   System.out.println("Welcome " + player.getName() + ". Your account balance is " + player.formattedBalance());
    //   return player;
    // }

}
