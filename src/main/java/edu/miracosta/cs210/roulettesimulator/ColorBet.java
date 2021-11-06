package edu.miracosta.cs210.roulettesimulator;

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
 * ColorBet.java
 */

public class ColorBet extends Bet {
  private final int[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
  private final int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
  //Used to see if a winning number is either a red or black number
  private final int[][] colorInfo = {redNumbers, blackNumbers};

  private Color betColor;

  void setColor(Color aColor)
  {
    betColor = aColor;
  }

  boolean isWinner(int winningNumber) {
    int colorIndex = (betColor == Color.RED) ? 0 : 1;
    int[] numbers  = colorInfo[colorIndex];
    for (int number : numbers) {
      if (number == winningNumber) {
        return true;
      }
    }
    return false;
  }
}