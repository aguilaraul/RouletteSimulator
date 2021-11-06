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

[Insert System Context Diagram]  

## 2.2 User Classes and Characteristics
| Classes | Description |
| ------- | ----------- |
| Player (user) | The application will have a User class in this release (called “Player”). A Player may be defined as someone who is playing the roulette simulator for fun or educational purposes. Players will be allowed to save their names and virtual bankroll as a “profile” within the application, and to load this information next time they play.|
| Administrator (Casino Staff) | n/a |

## 3. System Features
### 3.1 Player Account
#### 3.1.1 Description
The application will allow users to maintain a personal profile which will be read from and saved to a file. Data that will be stored includes the user’s name, account balance, and betting history. When the application is started it will ask the user for their name and load the data from the file with their name, and if no file exists it will create a new one and give them a balance of $1000.00.  
#### 3.1.2 Functional Requirements
