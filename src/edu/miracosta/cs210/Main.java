/**
 * @Authors:  Robert Edmonston, Raul Aguilar, Austin Garrison
 * @Date:     October 07 2021
 * FA21 CS 210 5198 Final Project
 * Roulette Simulator Application (RSA)
 * 
 * Based on code by:
 * Evan Silverthorn (silvee49322@gmail.com)
 * and Robert Edmonston ( bedmonston@icloud.com)
 * 
 * Main
 */

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
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
    player = AccountsManager.loadPlayer(name);
    playerName = player.getName();
    playerBalance = player.getBalance();
    
    // Gameplay
    while (keepPlaying) {
      table.play(playerName, playerBalance);
    }
    input.close();
  }
}
