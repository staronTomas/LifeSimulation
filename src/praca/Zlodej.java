package praca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda je potomkom triedy Praca
 *
 * Samostatne zamestnanie
 *
 */
public class Zlodej extends Praca {

    public Zlodej(String paNazov, int narocnost, double paPlat) {
        super(paNazov, narocnost, paPlat);
    }


    @Override
    public double dajVyplatu(int pocetOdpracovanychHodin) {
        return super.dajVyplatu(pocetOdpracovanychHodin);
    }

    @Override
    public int getNarocnostPraceEnergiaNaHodinu() {
        return super.getNarocnostPraceEnergiaNaHodinu();
    }

    @Override
    public String getNazov() {
        return super.getNazov();
    }
}
