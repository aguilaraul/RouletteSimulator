package edu.miracosta.cs210.roulettesimulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBetTest {

    @Test
    void isWinner() {
        NumberBet win = new NumberBet();
        boolean result = win.isWinner(1);
        assertEquals(true, result);
    }

    @Test
    void payout() {
        NumberBet pay = new NumberBet();
        int result = pay.payout();
        assertEquals(pay.wagerAmount*35, result);
    }
}