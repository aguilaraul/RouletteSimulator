/**
* File Name: Bet.java
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

public class Bet {

  int wagerAmount;

  public int getWagerAmount()
  {
    return wagerAmount;
  }
  public void setWagerAmount(int amt)
  {
    wagerAmount = amt;
  }
  boolean isWinner(int winningNumber)
  {
    return false;
  }

  public int payout()
  {
    return wagerAmount;
  }

}