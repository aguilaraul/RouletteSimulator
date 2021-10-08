/**
* File Name: Account.java
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
import java.text.NumberFormat;

public class Player
{
  private String name;
  private int balance;
  //private boolean isBankrupt = false;

  public Player(String name) {
    this.name = name;
    this.balance = 1000;
  }

  public Player(String aName, int aBalance)
  {
    name = aName;
    balance = aBalance;
  }

  public int getBalance()
  {
    return balance;
  }

  public void setBalance(int newBalance)
  {
    balance = newBalance;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String newName)
  {
    // Useful if we want to limit what a Player name can be
    name = newName;
  }

  // public String formattedBalance()
  // {
  //   NumberFormat currency = NumberFormat.getCurrencyInstance();
  //     String formattedBalance = currency.format(balance);
  //     return formattedBalance;
  // }
}