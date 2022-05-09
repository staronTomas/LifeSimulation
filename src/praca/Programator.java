package praca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * potomok triedy Praca
 *
 * samostatne zamestnanie
 *
 */
public class Programator extends Praca {

    public Programator(String paNazov, int narocnost, double paPlat) {
        // parametricky konštruktor
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
