package edu.miracosta.cs210.roulettesimulator;

/**
* File Name: NumberBet.java
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

public class NumberBet extends Bet
{
  int number;

  void setNumber(int aNumber) {
    number = aNumber;
  }

  boolean isWinner(int winningNumber) {
    if (number == winningNumber) {
      return true;
    }
    return false;
  }

  public int payout() {
    return 35 * wagerAmount;
  }

  @Override
  public String toString() {
    String numberString = "# " + number;
    return numberString;
  }
}