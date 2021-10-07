/**
* File Name: RouletteWheel.java
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

public class RouletteWheel
{
  public static RouletteSpin spin()
  {
    System.out.println("Spinning wheel!");
    RouletteSpin rouletteSpin = new RouletteSpin();
    for (int i=0;i<400;i++)
    {
      if (i%10 == 0) {
        System.out.print(".");
        try {
          Thread.sleep(125);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("|" + rouletteSpin.getNumber() + "|");
    return rouletteSpin;
  }
}