package budovyAMiestnosti;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * trieda bude vytvárať budovy a narábať s nimi
 */
public abstract class Budova {

    private Miestnost[] zoznamMiestnosti;
    private String nazovBudovy;

    public Budova(String paMeno, int pocetMiestnosti) {
        //Parametrický konštruktor

        this.nazovBudovy = paMeno;
        this.zoznamMiestnosti = new Miestnost[pocetMiestnosti];
    }

    public String getNazovBudovy() {
        return this.nazovBudovy;
    }

    public Miestnost[] getZoznamMiestnosti() {
        return this.zoznamMiestnosti;
    }


}
