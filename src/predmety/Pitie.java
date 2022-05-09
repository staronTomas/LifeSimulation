package predmety;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Potomok triedy Predmet
 * Inštancie tejto triedy budú nápoje, ktoré doplnia hráčovi jeho atribut Smäd a z časti aj energiu
 *
 */
public class Pitie extends Predmet {

    private int energyGain; // hodnota energie, ktorú hráč získa
    private int minusSmad; // hodnota o ktorú sa zníži smäd

    public Pitie (String paNazov, double paCena, int paEnergyGain, int paMinusSmad) {
        // Parametrický konštruktor
        super(paNazov, paCena);
        this.energyGain = paEnergyGain;
        this.minusSmad = paMinusSmad;
    }

    @Override
    public String dajPopis() {
        return super.dajPopis();
    }

    @Override
    public String pouziPredmet() {
        return ("Nazdravie! Napil si sa nápoja - : " + super.getNazovpredmetu());
    }

    public int getEnergyGain() {
        return this.energyGain;
    }

    public int getMinusSmad() {
        return this.minusSmad;
    }
}
