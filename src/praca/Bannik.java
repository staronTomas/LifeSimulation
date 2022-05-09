package praca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda je potomkom triedy Praca
 *
 * samostanne zamestnanie, ktoré môže mať hráč
 *
 */
public class Bannik extends Praca {

    private int poskodenieZdraviaPracou = 0;


    public Bannik(String paNazov, int narocnost, double paPlat, int paPoskodenieZdraviaPracou) {
        super(paNazov, narocnost, paPlat);
        this.poskodenieZdraviaPracou = paPoskodenieZdraviaPracou;
    }


    @Override
    public double dajVyplatu(int pocetOdpracovanychHodin) {
        return super.dajVyplatu(pocetOdpracovanychHodin);
    }

    @Override
    public int getNarocnostPraceEnergiaNaHodinu() {
        return super.getNarocnostPraceEnergiaNaHodinu();
    }

    public int getPoskodenieZdraviaPracou() {
        return this.poskodenieZdraviaPracou;
    }

    @Override
    public String getNazov() {
        return super.getNazov();
    }

}
