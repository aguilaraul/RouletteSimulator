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
 * Main.java
 */

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    RouletteTable table = new RouletteTable();
    Player player;
    String playerName;
    int playerBalance;
      
    // Log-in
    System.out.println("Welcome to the Roulette Simulator!");
    System.out.println("Please enter your name : ");
    Scanner input = new Scanner(System.in);
    playerName = input.next();
    player = AccountsManager.loadPlayer(playerName);
    playerBalance = player.getBalance();
    
    // Gameplay
    table.RouletteTable(playerName, playerBalance);

    input.close();
  }
}
