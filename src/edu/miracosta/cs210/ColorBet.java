/**
* File Name: ColorBet.java
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

public class ColorBet extends Bet
{
  private int blackNumbers[] = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};

  private int redNumbers[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

  //Used to see if a winning number is either a red or black number
  private int colorInfo[][] = {redNumbers, blackNumbers};

  private Color betColor;

  void setColor(Color aColor)
  {
    betColor = aColor;
  }

  boolean isWinner(RouletteSpin spin)
  {
    boolean didWin = false;
    int winningNumber = spin.getNumber();
    int colorIndex = (betColor == Color.RED) ? 0 : 1;
    int numbers[] = colorInfo[colorIndex];
    for (int i=0;i<numbers.length;i++)
    {
      if (numbers[i] == winningNumber) {
        didWin = true;
        break;
      }
    }
    return didWin;
  }
}