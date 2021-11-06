package edu.miracosta.cs210.roulettesimulator; /**
 * @Authors:  Raul Aguilar, Robert Edmonston, Austin Garrison
 * @Date:     October 10, 2021
 * FA21 CS 210 5198 Final Project
 * Roulette Simulator Application (RSA)
 *
 * Based on code by:
 * Evan Silverthorn (silvee49322@gmail.com)
 * and Robert Edmonston ( bedmonston@icloud.com)
 *
 * Text.java
 */

import java.text.NumberFormat;

public class Text {
    String formattedBalance(int balance) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(balance);
    }

    //** Roulette Table **//
    void displayBetMenu() {
        System.out.println("What type of bet would you like to make? (1-3 or 0 to exit)");
        System.out.println("1) Number Bet");
        System.out.println("2) Color Bet");
        System.out.println("3) Odd/Even Bet");
    }

    public void displayEndGame(String name, int balance) {
        System.out.println("Thanks for playing " + name);
        System.out.println("Your ending balance is " + formattedBalance(balance));
    }
}
