package predmety;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Potomok triedy Predmet
 * Inštancie tejto triedy budú doplnať hráčovi hodnotu Zdravia
 *
 */
public class Liek extends Predmet {

    private int kolkoZdraviaPrida;

    public Liek(String nazov, double cena, int paKolkoZdraviaPrida) {
        //Parametrický konštruktor
        super(nazov, cena);
        this.kolkoZdraviaPrida = paKolkoZdraviaPrida;
    }

    @Override
    public String dajPopis() {
        return super.dajPopis() + "\n" + "Pridá zdravia: " + this.kolkoZdraviaPrida;
    }

    @Override
    public String pouziPredmet() {
        return super.pouziPredmet();
    }

    @Override
    public String getNazovpredmetu() {
        return super.getNazovpredmetu();
    }

    @Override
    public double dajCenu() {
        return super.dajCenu();
    }

    public int getKolkoZdraviaPrida() {
        return this.kolkoZdraviaPrida;
    }
}
