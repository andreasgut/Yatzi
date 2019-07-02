package sample;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void einer() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);


        game.die1.setDie(1);
        game.die2.setDie(1);
        game.die3.setDie(1);
        game.die4.setDie(1);
        game.die5.setDie(1);
        game.einer();

        assertEquals(5, player1.getEiner());
    }

    @Test
    public void zweier() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);


        game.die1.setDie(2);
        game.die2.setDie(2);
        game.die3.setDie(2);
        game.die4.setDie(2);
        game.die5.setDie(2);
        game.zweier();

        assertEquals(10, player1.getZweier());
    }

    @Test
    public void dreier() {
    }

    @Test
    public void vierer() {
    }

    @Test
    public void fünfer() {
    }

    @Test
    public void sechser() {
    }

    @Test
    public void einPaar() {
    }

    @Test
    public void zweiPaare() {
    }

    @Test
    public void dreiGleiche() {
    }

    @Test
    public void vierGleiche() {
    }

    @Test
    public void kleineStrasseTrue() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);


        game.die1.setDie(1);
        game.die2.setDie(2);
        game.die3.setDie(3);
        game.die4.setDie(4);
        game.die5.setDie(5);
        game.kleineStrasse();


        assertTrue(player1.getKleineStrasse() == 15);
    }

    @Test
    public void kleineStrasseFalse(){
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);


        game.die1.setDie(1);
        game.die2.setDie(2);
        game.die3.setDie(4);
        game.die4.setDie(5);
        game.die5.setDie(5);
        game.kleineStrasse();

        assertFalse(player1.getKleineStrasse() == 15);

    }

    @Test
    public void grosseStrasse() {
    }

    @Test
    public void fullHouse() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);


        game.die1.setDie(1);
        game.die2.setDie(2);
        game.die3.setDie(4);
        game.die4.setDie(5);
        game.die5.setDie(5);
        game.fullHouse();

        assertTrue(player1.getFullHouse() == 0);

        game.die1.setDie(5);
        game.die2.setDie(5);
        game.die3.setDie(6);
        game.die4.setDie(6);
        game.die5.setDie(6);
        game.fullHouse();

        assertTrue(player1.getFullHouse() == 28);

        game.die1.setDie(5);
        game.die2.setDie(6);
        game.die3.setDie(5);
        game.die4.setDie(6);
        game.die5.setDie(5);
        game.fullHouse();

        assertTrue(player1.getFullHouse() == 27);
    }

    @Test
    public void chance() {
    }

    @Test
    public void yatzy() {
    }
}