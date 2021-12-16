package edu.miracosta.cs210.roulettesimulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBetTest {

    @Test
    void isWinner() {
        NumberBet win = new NumberBet();
        boolean result = true;
        boolean winner;
        int bet = 1;
        winner = win.isWinner(bet);
        assertEquals(result, winner);
    }

    @Test
    void payout() {
        NumberBet pay = new NumberBet();
        int result = pay.payout();
        assertEquals(pay.wagerAmount*35, result);
    }
}