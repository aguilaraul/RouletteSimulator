/**
* File Name: OddEvenBet.java
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

public class OddEvenBet extends Bet
{
  boolean isEven;

  void setIsEven(boolean value) {
    isEven = value;
  }

  boolean isWinner(int winningNumber) {
    return (winningNumber % 2 == 0) ? isEven : !isEven;
  }
}