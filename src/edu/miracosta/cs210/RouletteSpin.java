/**
* File Name: RouletteSpin.java
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

import java.util.Random;

public class RouletteSpin
{
   private int number;

   RouletteSpin()
   {
     number = getRandomNumber(1, 36);
   }

   public int getNumber()
   {
    return number;
   }

  public int getRandomNumber(int min, int max)
  {
    return (int) ((Math.random() * (max - min)) + min);
  }
}