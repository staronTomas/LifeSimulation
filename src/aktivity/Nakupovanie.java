package aktivity;

import predmety.Predmet;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 * Táto trieda je potomkom triedy Aktivita, využívaná je pokiaľ je nejaká Aktivita nakupovanie
 */
public class Nakupovanie extends Aktivita {

    private Predmet[] zoznamPredmetov;   // zoznam predmetov v nakupnom zozname

    public Nakupovanie(String nazov, int paEnergia, int cas, int paZvysenieHladu, int paZvysenieSmadu, Predmet[] zoznamPredmetov) {
        super(nazov, paEnergia, cas, paZvysenieHladu, paZvysenieSmadu);
        this.zoznamPredmetov = zoznamPredmetov;
    }



    public Predmet[] getZoznamPredmetov() {
        return this.zoznamPredmetov;
    }

    @Override
    public void vykonajAktivitu() {
        super.vykonajAktivitu();
    }

    @Override
    public String getNazovAktivity() {
        return super.getNazovAktivity();
    }

    @Override
    public int getPotrebnaEnergia() {
        return super.getPotrebnaEnergia();
    }

    @Override
    public int getKolkoCasuUbehneMinuty() {
        return super.getKolkoCasuUbehneMinuty();
    }

    @Override
    public int getZvysenieHladu() {
        return super.getZvysenieHladu();
    }

    @Override
    public int getZvysenieSmadu() {
        return super.getZvysenieSmadu();
    }
}
