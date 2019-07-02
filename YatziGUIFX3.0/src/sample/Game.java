package sample;

import javafx.collections.ObservableList;


public class Game {


    Player[] players = new Player[2];
    Player player1, player2;
    Player currentPlayer;
    private int[][] table = new int[2][18];
    Die die1 = new Die();
    Die die2 = new Die();
    Die die3 = new Die();
    Die die4 = new Die();
    Die die5 = new Die();
    public int[] dieTable = new int[5];
    boolean w1, w2, w3, w4, w5;
    int wurfNummer, rundeNummer, zeilenNummer;
    ObservableList playerPunkte;






    Game(Player player1, Player player2) {

        players[0] = player1;
        players[1] = player2;
        this.player1 = player1;
        this.player2 = player2;


        play();


    }



    public void play() {



            currentPlayer = players[rundeNummer % 2];
            zeilenNummer = rundeNummer % 2;




            wurfNummer = 1;

            roll1();
            sendInfo();

            rundeNummer++;


    }

    //wurf

    private void roll1() {
        dieTable[0] = die1.roll();
        dieTable[1] = die2.roll();
        dieTable[2] = die3.roll();
        dieTable[3] = die4.roll();
        dieTable[4] = die5.roll();
    }

    public void roll2() {
        if (w1) dieTable[0] = die1.roll();
        if (w2) dieTable[1] = die2.roll();
        if (w3) dieTable[2] = die3.roll();
        if (w4) dieTable[3] = die4.roll();
        if (w5) dieTable[4] = die5.roll();
    }

    public void roll3() {
        if (w1) dieTable[0] = die1.roll();
        if (w2) dieTable[1] = die2.roll();
        if (w3) dieTable[2] = die3.roll();
        if (w4) dieTable[3] = die4.roll();
        if (w5) dieTable[4] = die5.roll();
    }


    //modus

    public void einer() {
        int count = 0;
        int result;
        if (die1.getDie() == 1) count++;
        if (die2.getDie() == 1) count++;
        if (die3.getDie() == 1) count++;
        if (die4.getDie() == 1) count++;
        if (die5.getDie() == 1) count++;

        result = count*1;

        currentPlayer.setEiner(result);
        currentPlayer.setEinerC(true);

    }

    public void zweier() {
        int count = 0;
        int result;
        if (die1.getDie() == 2) count++;
        if (die2.getDie() == 2) count++;
        if (die3.getDie() == 2) count++;
        if (die4.getDie() == 2) count++;
        if (die5.getDie() == 2) count++;

        result = count*2;

        currentPlayer.setZweier(result);
        currentPlayer.setZweierC(true);

    }

    public void dreier() {
        int count = 0;
        int result;
        if (die1.getDie() == 3) count++;
        if (die2.getDie() == 3) count++;
        if (die3.getDie() == 3) count++;
        if (die4.getDie() == 3) count++;
        if (die5.getDie() == 3) count++;

        result = count*3;

        currentPlayer.setDreier(result);
        currentPlayer.setDreierC(true);

    }



    public void vierer() {
        int count = 0;
        int result;
        if (die1.getDie() == 4) count++;
        if (die2.getDie() == 4) count++;
        if (die3.getDie() == 4) count++;
        if (die4.getDie() == 4) count++;
        if (die5.getDie() == 4) count++;

        result = count*4;

        currentPlayer.setVierer(result);
        currentPlayer.setViererC(true);
    }

    public void fünfer() {
        int count = 0;
        int result;
        if (die1.getDie() == 5) count++;
        if (die2.getDie() == 5) count++;
        if (die3.getDie() == 5) count++;
        if (die4.getDie() == 5) count++;
        if (die5.getDie() == 5) count++;

        result = count*5;

        currentPlayer.setFünfer(result);
        currentPlayer.setFünferC(true);
    }

    public void sechser() {
        int count = 0;
        int result;
        if (die1.getDie() == 6) count++;
        if (die2.getDie() == 6) count++;
        if (die3.getDie() == 6) count++;
        if (die4.getDie() == 6) count++;
        if (die5.getDie() == 6) count++;

        result = count*6;

        currentPlayer.setSechser(result);
        currentPlayer.setSechserC(true);

    }

    public void einPaar() {

        int paar1;
        int paar2;
        int paar3;
        int paar4;
        int result = 0;

        if (die1.getDie() == die2.getDie() || die1.getDie() == die3.getDie() || die1.getDie() == die4.getDie()
                || die1.getDie() == die5.getDie()) paar1 = die1.getDie();
        else paar1 = 0;

        if (die2.getDie() == die3.getDie() || die2.getDie() == die4.getDie() || die2.getDie() == die5.getDie())
            paar2 = die2.getDie();
        else paar2 = 0;

        if (die3.getDie() == die4.getDie() || die3.getDie() == die5.getDie()) paar3 = die3.getDie();
        else paar3 = 0;

        if (die4.getDie() == die5.getDie()) paar4 = die4.getDie();
        else paar4 = 0;

        if (paar1 >= paar2 && paar1 >= paar3 && paar1 >= paar4) result = paar1*2;

        if (paar2 >= paar1 && paar2 >= paar3 && paar2 >= paar4) result = paar2*2;

        if (paar3 >= paar1 && paar3 >= paar2 && paar3 >= paar4) result = paar3*2;

        if (paar4 >= paar1 && paar4 >= paar2 && paar4 >= paar3) result = paar4*2;

        currentPlayer.setEinPaar(result);
        currentPlayer.setEinPaarC(true);

    }


    public void zweiPaare() {
        int paar1;
        int paar2;
        int paar3;
        int result;


        if (die1.getDie() == die2.getDie() || die1.getDie() == die3.getDie() || die1.getDie() == die4.getDie()
                || die1.getDie() == die5.getDie()) paar1 = die1.getDie();
        else paar1 = 0;

        if (die2.getDie() == die3.getDie() || die2.getDie() == die4.getDie() || die2.getDie() == die5.getDie())
            paar2 = die2.getDie();
        else paar2 = 0;

        if (die3.getDie() == die4.getDie() || die3.getDie() == die5.getDie()) paar3 = die3.getDie();
        else paar3 = 0;


        if ((paar1 > 0 && paar2 > 0 && paar1 != paar2) || (paar1 > 0 && paar3 > 0 && paar1 != paar3)
                || (paar2 > 0 && paar3 > 0 && paar2 != paar3)) {result = paar1*2 + paar2*2 + paar3*2;
            currentPlayer.setZweiPaar(result); }
        else
        currentPlayer.setZweiPaar(0);
        currentPlayer.setZweiPaarC(true);


    }



    public void dreiGleiche() {

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;

        switch (die1.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die2.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die3.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die4.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die5.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        if (count1 >= 3) currentPlayer.setDreiGleiche(3);
        if (count2 >= 3) currentPlayer.setDreiGleiche(6);
        if (count3 >= 3) currentPlayer.setDreiGleiche(9);
        if (count4 >= 3) currentPlayer.setDreiGleiche(12);
        if (count5 >= 3) currentPlayer.setDreiGleiche(15);
        if (count6 >= 3) currentPlayer.setDreiGleiche(18);
        if (count1 < 3 && count2 < 3 && count3 < 3 && count4 < 3 && count5 < 3 && count6 < 3)
            currentPlayer.setDreiGleiche(0);

        currentPlayer.setDreiGleicheC(true);
    }

    public void vierGleiche() {

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;

        switch (die1.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die2.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die3.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die4.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die5.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        if (count1 >= 4) currentPlayer.setVierGleiche(4);
        if (count2 >= 4) currentPlayer.setVierGleiche(8);
        if (count3 >= 4) currentPlayer.setVierGleiche(12);
        if (count4 >= 4) currentPlayer.setVierGleiche(16);
        if (count5 >= 4) currentPlayer.setVierGleiche(20);
        if (count6 >= 4) currentPlayer.setVierGleiche(24);
        if (count1 < 4 && count2 < 4 && count3 < 4 && count4 < 4 && count5 < 4 && count6 < 4)
            currentPlayer.setVierGleiche(0);

        currentPlayer.setVierGleicheC(true);
    }

    public void kleineStrasse() {

        boolean eins = false;
        boolean zwei = false;
        boolean drei = false;
        boolean vier = false;
        boolean fünf = false;

        switch (die1.getDie()) {

            case 1:
                eins = true;
                break;

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;
        }

        switch (die2.getDie()) {

            case 1:
                eins = true;
                break;

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;

        }

        switch (die3.getDie()) {

            case 1:
                eins = true;
                break;

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;

        }

        switch (die4.getDie()) {

            case 1:
                eins = true;
                break;

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;

        }

        switch (die5.getDie()) {

            case 1:
                eins = true;
                break;

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;

        }

        if (eins == true && zwei == true && drei == true && vier == true && fünf == true) {
            currentPlayer.setKleineStrasse(15);
        } else {
            currentPlayer.setKleineStrasse(0);
        }

        currentPlayer.setKleineStrasseC(true);
    }


    public void grosseStrasse() {

        boolean zwei = false;
        boolean drei = false;
        boolean vier = false;
        boolean fünf = false;
        boolean sechs = false;

        switch (die1.getDie()) {

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;
                break;

            case 6:
                sechs = true;
                break;
        }

        switch (die2.getDie()) {

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;
                break;

            case 6:
                sechs = true;
                break;
        }

        switch (die3.getDie()) {

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;
                break;

            case 6:
                sechs = true;
                break;
        }

        switch (die4.getDie()) {

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;
                break;

            case 6:
                sechs = true;
                break;
        }

        switch (die5.getDie()) {

            case 2:
                zwei = true;
                break;

            case 3:
                drei = true;
                break;

            case 4:
                vier = true;
                break;

            case 5:
                fünf = true;
                break;

            case 6:
                sechs = true;
                break;
        }



        if (zwei == true && drei == true && vier == true && fünf == true && sechs == true) {
            currentPlayer.setGrosseStrasse(20);
        } else {
            currentPlayer.setGrosseStrasse(0);
        }

        currentPlayer.setGrosseStrasseC(true);
    }

    public void fullHouse() {

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int paar = 0;
        int dreier = 0;

        switch (die1.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die2.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die3.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die4.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        switch (die5.getDie()) {

            case 1:
                count1++;
                break;

            case 2:
                count2++;
                break;

            case 3:
                count3++;
                break;

            case 4:
                count4++;
                break;

            case 5:
                count5++;
                break;

            case 6:
                count6++;
                break;

        }

        if (count1 == 2) paar = 2;
        if (count2 == 2) paar = 4;
        if (count3 == 2) paar = 6;
        if (count4 == 2) paar = 8;
        if (count5 == 2) paar = 10;
        if (count6 == 2) paar = 12;

        if (count1 == 3) dreier = 3;
        if (count2 == 3) dreier = 6;
        if (count3 == 3) dreier = 9;
        if (count4 == 3) dreier = 12;
        if (count5 == 3) dreier = 15;
        if (count6 == 3) dreier = 18;

        if (paar == 0 || dreier == 0) currentPlayer.setFullHouse(0);
        else currentPlayer.setFullHouse(paar+dreier);

        currentPlayer.setFullHouseC(true);



    }

    public void chance() {

        int result;

        result = die1.getDie() + die2.getDie() + die3.getDie() + die4.getDie() + die5.getDie();


        currentPlayer.setChance(result);

        currentPlayer.setChanceC(true);


    }

    public void yatzy() {

        if (die1.getDie() == die2.getDie() && die1.getDie() == die2.getDie() && die1.getDie() == die3.getDie() &&
                die4.getDie() == die5.getDie()) currentPlayer.setYatzi(50);
        else {currentPlayer.setYatzi(0);}

        currentPlayer.setYatziC(true);

    }



    public String sendInfo() {

        switch (wurfNummer) {

            case 1:
            case 2: {
                return currentPlayer.getName() + " ist an der Reihe. \n" +
                        "Würfelrunde " + wurfNummer + "\nWenn Sie nochmals Würfel wollen, klicken Sie auf 'Würfeln'.";}
            case 3:{
                return currentPlayer.getName() + " ist an der Reihe. \n" +
                        "Würfelrunde " + wurfNummer + "\nWählen Sie aus, wo sie die Punkte anrechnen lassen wollen.";}

        }


        return " ";
    }


    public int[] getDieTable() {
        return dieTable;
    }

    public void setW1(boolean w1) {
        this.w1 = w1;
    }

    public void setW2(boolean w2) {
        this.w2 = w2;
    }

    public void setW3(boolean w3) {
        this.w3 = w3;
    }

    public void setW4(boolean w4) {
        this.w4 = w4;
    }

    public void setW5(boolean w5) {
        this.w5 = w5;
    }

    public void setDieTable(int[] dieTable) {
        this.dieTable = dieTable;
    }

    public int getWurfNummer() {
        return wurfNummer;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void increaseWurfNummer() {
        wurfNummer++;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getRundeNummer() {
        return rundeNummer;
    }

    public int getZeilenNummer() {
        return zeilenNummer;
    }

    public void setZeilenNummer(int zeilenNummer) {
        this.zeilenNummer = zeilenNummer;
    }
}


