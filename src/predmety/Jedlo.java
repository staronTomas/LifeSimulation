package predmety;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Potomok triedy Predmet
 *
 * Instancie tejto triedy doplnaju hracovi hlad a energiu
 *
 */
public class Jedlo extends Predmet {

    private int energyGain; // hodnota energie, ktorá sa má hráčovi pripočítať
    private int minusHlad; // hodnota o ktorp sa hráčovi zmenší hlad

    public Jedlo (String paNazov, double paCena, int paEnergyGain, int paMinusHlad) {
        //Parametrický konštruktor
        super(paNazov, paCena);
        this.energyGain = paEnergyGain;
        this.minusHlad = paMinusHlad;
    }

    @Override
    public String dajPopis() {
        return super.dajPopis();
    }

    @Override
    public String pouziPredmet() {
        return ("Dobrú chuť! Zjedol si - : " + super.getNazovpredmetu());
    }

    public int getEnergyGain() {
        return this.energyGain;
    }

    public int getMinusHlad() {
        return this.minusHlad;
    }
}