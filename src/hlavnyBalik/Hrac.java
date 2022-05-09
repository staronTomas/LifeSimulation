package hlavnyBalik;

import budovyAMiestnosti.Budova;
import budovyAMiestnosti.Miestnost;
import praca.IPracaHrac;
import praca.Praca;
import predmety.Predmet;
import stavHraca.StavHraca;

import java.util.ArrayList;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda má na starosti Stav hráča, jeho atribúty a vykonáva metody ako: napiť sa, najesť sa a potobne
 * Implementuje IPracaHrac aby hráč mohol pracovať a zarobiť hernú menu
 */
public class Hrac implements IPracaHrac {

    private String meno;
    private double peniaze;
    private ArrayList<Predmet> inventar;
    private Miestnost aktualnaMiestnost;
    private Budova aktualnaBudova;
    private Praca zamestnanie;
    private StavHraca stav;
    private boolean vodicskyPreukaz;


    public Hrac(String meno, Budova domov) {
        //Parametrický konštruktor
        this.meno = meno;
        this.aktualnaBudova = domov;
        this.aktualnaMiestnost = domov.getZoznamMiestnosti()[0];
        this.peniaze = 100.0;
        this.inventar = new ArrayList<Predmet>(); // Dorobit triedu Predmet
        this.stav = new StavHraca();

    }

    public void pridajPeniaze(double pocet) {
        // metoda prida hráčovi peniaze, ktoré sú určené v parametri
        this.peniaze += pocet;
    }

    public boolean odoberPeniaze(int pocet) {
        // metoda odoberie hráčovi peniaze, ktoré sú určene v parametri
        if (this.peniaze >= pocet) {
            this.peniaze -= pocet;
            return true;
        } else {
            return false;
        }
    }




    @Override
    public boolean zamestnajSa(Praca praca) {
        // Hráčovi sa zmení hodnota atribútu zamestnanie, dostane hodnotu v parametri metody
        if (this.zamestnanie == null) {
            this.zamestnanie = praca;
            return true;
        }
        return false;
    }

    @Override
    public boolean dajVypoved() {
        // atribut zamestnanie sa zmení na hodnotu null, Hráč nebude mať zamestnanie
        if (this.zamestnanie == null) {
            return false;
        }
        this.zamestnanie = null;
        return true;
    }


    @Override
    public boolean chodDoPrace(int kolkoHodin) {
        //Pokiaľ chce íst hrac pracovať, vokona sa tato metoda, kontroluje či máč hráč dosť energie atd
        //Riadi to kolko hrac zarobi, pripocitanie penazí, odpocítanie energie, hladu atd

        if (zamestnanie != null && this.stav.getEnergia().getMnozstvo() > kolkoHodin * zamestnanie.getNarocnostPraceEnergiaNaHodinu()) {  //kontrola či má hráč dosť energie na vykonanie práce
            int medziCislo = this.stav.getEnergia().odober(kolkoHodin * zamestnanie.getNarocnostPraceEnergiaNaHodinu()); //odpočíta energiu
            if (medziCislo < 0) { //prípadne upraví hodnotu zdravia ak energia klesla pod 0
                this.stav.getZdravie().odober(medziCislo);
                System.out.println("Pozor odbudlo ti zdravie, pretože máš málo energie, chod spať ak necheš zomrieť od únavy!");
            }

            this.pridajPeniaze(zamestnanie.dajVyplatu(kolkoHodin));
            System.out.println("Práca skončená.");
            System.out.println("Zarobil si: " + zamestnanie.dajVyplatu(kolkoHodin) + " eur.");
            return true;
        } else {
            if (zamestnanie == null) {
                System.out.println("najprv sa zamestnaj, potom môžeš ísť do práce!");
                return false;
            }
            System.out.println("Nemáš dosť energie na toľko práce, vyspi sa!");
            return false;
        }
    }







//Gettery



    public String getMeno() {
        return this.meno;
    }

    public double getPeniaze() {
        return this.peniaze;
    }

    public void odpocitajPeniaze(double peniaze) {
        this.peniaze -= peniaze;
    }

    public StavHraca getStavHraca() {
        return stav;
    }

    public ArrayList<Predmet> getInventar() {
        return this.inventar;
    }

    public Budova getAktualnaBudova() {
        return  this.aktualnaBudova;
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void setAktualnaMiestnost(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
    }

    public void setAktualnaBudova(Budova aktualnaBudova) {
        this.aktualnaBudova = aktualnaBudova;
    }

    public Praca getZamestnanie() {
        return this.zamestnanie;
    }

    public boolean getVodicskyPreukaz() {
        return this.vodicskyPreukaz;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setPeniaze(double peniaze) {
        this.peniaze = peniaze;
    }

    public void setZamestnanie(Praca zamestnanie) {
        this.zamestnanie = zamestnanie;
    }

    public void setStav(StavHraca stav) {
        this.stav = stav;
    }
}
