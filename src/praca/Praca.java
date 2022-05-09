package praca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 * Trieda má na starosti zamestnanie hráča
 * Hráč sa môže zamestnať v jednom z prác potomkov tejto triedy
 *
 */
public abstract class Praca {

    private int narocnostPraceEnergiaNaHodinu;
    private double platZaHodinu;
    private String nazov;



    public Praca (String paNazov, int narocnost, double paPlat) {
        //Parametricky konštruktor
        this.nazov = paNazov;
        this.narocnostPraceEnergiaNaHodinu = narocnost;
        this.platZaHodinu = paPlat;
    }


    public double dajVyplatu(int pocetOdpracovanychHodin) {
        // metoda vrati double - hodnota penazi, ktorú hráč zarobil
        return (pocetOdpracovanychHodin * platZaHodinu);
    }

    public double getPlat() {
        return this.platZaHodinu;
    }

    public int getNarocnostPraceEnergiaNaHodinu() {
        return this.narocnostPraceEnergiaNaHodinu;
    }

    public String getNazov() {
        return this.nazov;
    }

}
