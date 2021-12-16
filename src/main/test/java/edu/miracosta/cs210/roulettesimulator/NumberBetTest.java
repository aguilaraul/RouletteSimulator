package edu.miracosta.cs210.roulettesimulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBetTest {

    /*
     * Tests to see if a bet that should win is a winner.
     * @author Robert Edmonston
     */
    @Test
    void isWinner() {
        NumberBet win = new NumberBet();
        win.setNumber(1);
        boolean result = true;
        boolean winner;
        int bet = 1;
        winner = win.isWinner(bet);
        assertEquals(result, winner);
    }

    /*
     * Tests to see if a bet that should lose is a loser.
     * @author Austin
     */
    @Test
    void isLoser() {
        NumberBet win = new NumberBet();
        win.setNumber(2);
        boolean result = false;
        boolean winner;
        int bet = 1;
        winner = win.isWinner(bet);
        assertEquals(result, winner);
    }

    /*
     * Tests to see if a bet gives the proper payout.
     * @author Saghar
     */
    @Test
    void payout() {
        NumberBet pay = new NumberBet();
        int result = pay.payout();
        assertEquals(pay.wagerAmount*35, result);
    }
}