package budovyAMiestnosti;

import aktivity.Aktivita;
import predmety.Predmet;

import java.util.ArrayList;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda vytvára inštancie, ktoré budú pridávane do polia Miestnosti Budov
 * Každá miestnosť má svoje vlastné aktivity
 *
 */
public class Miestnost {

    private String nazovMiestnosti;
    private ArrayList<Aktivita> zoznamAktivit;
    private ArrayList<Predmet> zoznamPredmetov;

    public Miestnost(String paNazov) {
        //Parametrický konštruktor
        this.nazovMiestnosti = paNazov;
        this.zoznamAktivit = new ArrayList<>();
        this.zoznamPredmetov = new ArrayList<>();
    }


    public String getNazovMiestnosti() {
        return this.nazovMiestnosti;
    }

    public ArrayList<Aktivita> getZoznamAktivit() {
        return this.zoznamAktivit;
    }

    public ArrayList<Predmet> getZoznamPredmetov() {
        return this.zoznamPredmetov;
    }

    public void pridajPredmet(Predmet predmet) {
        this.zoznamPredmetov.add(predmet);
    }

    public void pridajAktivitu(Aktivita aktivita) {
        this.zoznamAktivit.add(aktivita);
    }


}
