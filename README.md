# Software Requirements Specifications
## 1. Introduction
### 1.1 Purpose
This SRS describes the general requirements for version 1.0 of the Roulette Simulator Application (RSA). This document is intended to be used by project team members who will be responsible for implementing and verifying the correct functioning of the application.  

### 1.2 Document Conventions
No special typographical conventions are used in this SRS.
### 1.3 Project Scope
### 1.4 References

## 2. Overall Description
### 2.1 Product Perspective
The RSA 1.0 release will be a relatively simple one designed to support just enough features to be considered a “minimum viable product”.  

![System Context Diagram](/docs/final-project_system-context-diagram.png)

## 2.2 User Classes and Characteristics
| Classes | Description |
| ------- | ----------- |
| Player (user) | The application will have a User class in this release (called “Player”). A Player may be defined as someone who is playing the roulette simulator for fun or educational purposes. Players will be allowed to save their names and virtual bankroll as a “profile” within the application, and to load this information next time they play. Multiple user “profiles” are supported.|
| Administrator (Casino Staff) | The application will have a User class in this release (called “Administrator”). An Administrator may be defined as someone who works at the casino such as a dealer or other casino staff. Administrators will be authorized to accept bets, distribute winnings and ban users for breaking terms and agreements.  |

## 3. System Features
### 3.1 Player Account
#### 3.1.1 Description
The application will support multiple players who can login in a username and password and maintain a personal profile which will be read from and saved to a binary file. Data that will be stored includes the user’s name, account balance, and betting history. When the application is started it will ask the user if he/she is a new or old user. If he is a new user then he should create a new account with a balance of $1000.00. But if he is an old user, they should enter their username and password and data will be loaded from the file with their name, and if no file exists it will create a new one.
#### 3.1.2 Functional Requirements
| Player.Manager: | Managing a Player |
| --------------- | ----------------- |
| .savePlayer | When a player stops playing at the roulette table, their balance and betting history is saved into a file. |
| .createNewPlayer | When a player is new, they should create a new profile with a new username and password. |
| .loginPlayer | When a player logins in successfully by entering their username and password, their player save file is loaded with their balance and betting history. |

### 3.2 Playing Roulette
#### 3.2.1 Description
Once a Player is seated at a roulette table, they are able to play the game by choosing their type of bet, their wager, and what number or color they would like to place their bet on.
#### 3.2.2 Functional Requirements
| RouletteTable | Playing Roulette |
| ------------- | ---------------- |
| .chooseBetType | The Player is presented with a menu of the different Bet types available for selection. If the Player enters ‘0’ as a choice, the game ends and saves the player’s data before exiting. |
| .wager | After selecting a Bet type, the Player is asked to enter a wager. The wager cannot be less than 0 and more than the player’s current balance. |
| .placeBet | After a Bet type and wager has been entered, the Player is asked to enter a number, color, or parity depending on their Bet choice. Then the wheel is spun. |
| .spinWheel | The wheel is spun after the Player has entered their Bet type, wager, and where to place their bet, and a random number is generated. If the number generated is equivalent to the player’s choice, then the player won the round, a winning message is displayed, and the payout is added to the player’s current balance. Otherwise, the player loses the round, a losing message is displayed, and the wager is subtracted from the player’s current wage. |
