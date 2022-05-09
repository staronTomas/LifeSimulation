package predmety;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda má na starosti predmety hry
 *
 */
public class Predmet {

    private String nazovPredmetu;
    private double cena;

    public Predmet(String nazov, double cena) {
        //Parametrický konštruktor
        this.nazovPredmetu = nazov;
        this.cena = cena;
    }

    public String dajPopis() {
        return (this.nazovPredmetu + " Cena: " + this.cena + " eur");
    }

    public String pouziPredmet() {
        return "použil si predmet: " + this.nazovPredmetu;
    }

    public String getNazovpredmetu() {
        return this.nazovPredmetu;
    }

    public double dajCenu() {
        return this.cena;
    }
}
