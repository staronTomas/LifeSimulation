package budovyAMiestnosti;

import aktivity.Nakupovanie;
import predmety.Predmet;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Potom triedy Budova, hráč môže skončiť v miestnosti väzenie inštancie tejto triedy, pokiaľ urobí nejaký priestupok
 *
 *
 */
public class Policia extends Budova {

    private static final int KAUCIA = 1000; // Suma, ktorú musí hráč zaplatiť, pokiaľ chce ísť von z väzenia

    public Policia(String paMeno, int pocetMiestnosti) {
        //Parametrický konštruktor

        super(paMeno, pocetMiestnosti);
        super.getZoznamMiestnosti()[0] = new Miestnost("Vstupna hala");
        super.getZoznamMiestnosti()[1] = new Miestnost("Úradná miestnosť");
        super.getZoznamMiestnosti()[2] = new Miestnost("Väzenie");




        Predmet[] zoznamPredmetovUrad = new Predmet[2];
        zoznamPredmetovUrad[0] = new Predmet("Vodičsky preukaz", 500);
        super.getZoznamMiestnosti()[1].pridajAktivitu(new Nakupovanie("Nakupovať v " + super.getZoznamMiestnosti()[1].getNazovMiestnosti(), 19, 120, 15, 10, zoznamPredmetovUrad));

        super.getZoznamMiestnosti()[2].pridajAktivitu(new Nakupovanie("Nakupovať v " + super.getZoznamMiestnosti()[2].getNazovMiestnosti(), 40, 15000, 20, 20, null));
    }


    public int getVyskaKaucie() {
        return KAUCIA;
    }


}
