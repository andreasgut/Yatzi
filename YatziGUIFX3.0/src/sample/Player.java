package sample;

public class Player {

    String name;
    int einer, zweier, dreier, vierer, fünfer, sechser, einPaar, zweiPaar, dreiGleiche, vierGleiche, kleineStrasse,
    grosseStrasse, fullHouse, chance, yatzi, total, bonus;
    boolean einerC, zweierC, dreierC, viererC, fünferC, sechserC, einPaarC, zweiPaarC, dreiGleicheC, vierGleicheC,
            kleineStrasseC, grosseStrasseC, fullHouseC, chanceC, yatziC, totalC, bonusC;

    public void totalBerechnen(){

        total = einer+zweier+dreier+vierer+fünfer+sechser+bonus+einPaar+zweiPaar+dreiGleiche+vierGleiche+kleineStrasse+
                grosseStrasse+fullHouse+chance+yatzi;


    }

    public void bonusBerechnen(){


        if (einer+zweier+dreier+vierer+fünfer+sechser >= 63) {bonus = 35;}
        else {bonus = 0;}


    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEiner() {
        return einer;
    }

    public void setEiner(int einer) {
        this.einer = einer;
    }

    public int getZweier() {
        return zweier;
    }

    public void setZweier(int zweier) {
        this.zweier = zweier;
    }

    public int getDreier() {
        return dreier;
    }

    public void setDreier(int dreier) {
        this.dreier = dreier;
    }

    public int getVierer() {
        return vierer;
    }

    public void setVierer(int vierer) {
        this.vierer = vierer;
    }

    public int getFünfer() {
        return fünfer;
    }

    public void setFünfer(int fünfer) {
        this.fünfer = fünfer;
    }

    public int getSechser() {
        return sechser;
    }

    public void setSechser(int sechser) {
        this.sechser = sechser;
    }

    public int getEinPaar() {
        return einPaar;
    }

    public void setEinPaar(int einPaar) {
        this.einPaar = einPaar;
    }

    public int getZweiPaar() {
        return zweiPaar;
    }

    public void setZweiPaar(int zweiPaar) {
        this.zweiPaar = zweiPaar;
    }

    public int getDreiGleiche() {
        return dreiGleiche;
    }

    public void setDreiGleiche(int dreiGleiche) {
        this.dreiGleiche = dreiGleiche;
    }

    public int getVierGleiche() {
        return vierGleiche;
    }

    public void setVierGleiche(int vierGleiche) {
        this.vierGleiche = vierGleiche;
    }

    public int getKleineStrasse() {
        return kleineStrasse;
    }

    public void setKleineStrasse(int kleineStrasse) {
        this.kleineStrasse = kleineStrasse;
    }

    public int getGrosseStrasse() {
        return grosseStrasse;
    }

    public void setGrosseStrasse(int grosseStrasse) {
        this.grosseStrasse = grosseStrasse;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getYatzi() {
        return yatzi;
    }

    public void setYatzi(int yatzi) {
        this.yatzi = yatzi;
    }

    public boolean isEinerC() {
        return einerC;
    }

    public void setEinerC(boolean einerC) {
        this.einerC = einerC;
    }

    public boolean isZweierC() {
        return zweierC;
    }

    public void setZweierC(boolean zweierC) {
        this.zweierC = zweierC;
    }

    public boolean isDreierC() {
        return dreierC;
    }

    public void setDreierC(boolean dreierC) {
        this.dreierC = dreierC;
    }

    public boolean isViererC() {
        return viererC;
    }

    public void setViererC(boolean viererC) {
        this.viererC = viererC;
    }

    public boolean isFünferC() {
        return fünferC;
    }

    public void setFünferC(boolean fünferC) {
        this.fünferC = fünferC;
    }

    public boolean isSechserC() {
        return sechserC;
    }

    public void setSechserC(boolean sechserC) {
        this.sechserC = sechserC;
    }

    public boolean isEinPaarC() {
        return einPaarC;
    }

    public void setEinPaarC(boolean einPaarC) {
        this.einPaarC = einPaarC;
    }

    public boolean isZweiPaarC() {
        return zweiPaarC;
    }

    public void setZweiPaarC(boolean zweiPaarC) {
        this.zweiPaarC = zweiPaarC;
    }

    public boolean isDreiGleicheC() {
        return dreiGleicheC;
    }

    public void setDreiGleicheC(boolean dreiGleicheC) {
        this.dreiGleicheC = dreiGleicheC;
    }

    public boolean isVierGleicheC() {
        return vierGleicheC;
    }

    public void setVierGleicheC(boolean vierGleicheC) {
        this.vierGleicheC = vierGleicheC;
    }

    public boolean isKleineStrasseC() {
        return kleineStrasseC;
    }

    public void setKleineStrasseC(boolean kleineStrasseC) {
        this.kleineStrasseC = kleineStrasseC;
    }

    public boolean isGrosseStrasseC() {
        return grosseStrasseC;
    }

    public void setGrosseStrasseC(boolean grosseStrasseC) {
        this.grosseStrasseC = grosseStrasseC;
    }

    public boolean isFullHouseC() {
        return fullHouseC;
    }

    public void setFullHouseC(boolean fullHouseC) {
        this.fullHouseC = fullHouseC;
    }

    public boolean isChanceC() {
        return chanceC;
    }

    public void setChanceC(boolean chanceC) {
        this.chanceC = chanceC;
    }

    public boolean isYatziC() {
        return yatziC;
    }

    public void setYatziC(boolean yatziC) {
        this.yatziC = yatziC;
    }

    public boolean isTotalC() {
        return totalC;
    }

    public void setTotalC(boolean totalC) {
        this.totalC = totalC;
    }

    public boolean isBonusC() {
        return bonusC;
    }

    public void setBonusC(boolean bonusC) {
        this.bonusC = bonusC;
    }
}
