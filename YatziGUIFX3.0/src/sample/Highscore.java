package sample;

public class Highscore {
    private String vorname;
    private String nachname;
    private String score;
    private String datum;

    public Highscore(String vorname, String nachname, String score, String datum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.score = score;
        this.datum = datum;

    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
