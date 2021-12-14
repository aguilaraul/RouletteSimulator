/**
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

package edu.miracosta.cs210.roulettesimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.text.NumberFormat;

public final class Text {

    private int winningNumber;
    private ObservableList<String> log = FXCollections.observableArrayList();

    /**
     * Private constructor so nobody can instantiate the class.
     */
    private Text() {
    }

    /**
     * Static to class instance of the class.
     */
    private static final Text INSTANCE = new Text();

    /**
     * To be called by user to obtain instance of the class
     * @return instance of the singleton
     */
    public static Text getInstance() {
        return INSTANCE;
    }

    public String formattedBalance(double balance) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(balance);
    }

    //** Roulette Table **//
    public void displayBetMenu() {
        System.out.println("What type of bet would you like to make? (1-3 or 0 to exit)");
        System.out.println("1) Number Bet");
        System.out.println("2) Color Bet");
        System.out.println("3) Odd/Even Bet");
    }

    public void displayEndGame(String name, int balance) {
        System.out.println("Thanks for playing " + name);
        System.out.println("Your ending balance is " + formattedBalance(balance));
    }

    // RouletteWheelControl
    public void setWinningNumber(int n) {
        winningNumber = n;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public String winningNumber(int n) {
        return "The winning number was" + n;
    }

    public void addToLog(String message) {
        this.log.add(message);
    }
}
