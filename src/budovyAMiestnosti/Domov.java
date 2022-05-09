package budovyAMiestnosti;
import aktivity.Aktivita;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * trieda je potomkom triedy Budova, obsahuje metody, ktore neobsahuje trieda budova
 */
public class Domov extends Budova {

    private String adresa;


    public Domov(String paMeno, int pocetMiestnosti, String paAdresa) {
        //Parametrický konštruktor

        super(paMeno, pocetMiestnosti);
        super.getZoznamMiestnosti()[0] = new Miestnost("Vstupna chodba");
        super.getZoznamMiestnosti()[1] = new Miestnost("obyvacka");
        super.getZoznamMiestnosti()[2] = new Miestnost("kuchyna");
        super.getZoznamMiestnosti()[3] = new Miestnost("spalen");
        super.getZoznamMiestnosti()[4] = new Miestnost("kupelna");
        this.adresa = paAdresa;


        //aktivity v obyvacke
        super.getZoznamMiestnosti()[1].pridajAktivitu(new Aktivita("Pustiť si Tv na 1 hodinu", 10, 60, 10, 10));
        super.getZoznamMiestnosti()[1].pridajAktivitu(new Aktivita("Surfovať na internete na 1 hodinu", 10, 60 , 8, 9));
        super.getZoznamMiestnosti()[1].pridajAktivitu(new Aktivita("Cvičiť jógu na 30 minut", 9, 30 , 11, 15));

        //aktivity v kuchyni
        super.getZoznamMiestnosti()[2].pridajAktivitu(new Aktivita("Umyť riad", 3, 5, 2, 2));

        //aktivity v spalni
        super.getZoznamMiestnosti()[3].pridajAktivitu(new Aktivita("Choď  spať na 5 hodín", -50, 300, 30, 30));

        //aktivity v kupelni
        super.getZoznamMiestnosti()[4].pridajAktivitu(new Aktivita("Choď na WC", 1, 2, 1, 1));
        super.getZoznamMiestnosti()[4].pridajAktivitu(new Aktivita("Osprchuj sa", 5, 15, 3, 4));
    }

    @Override
    public String getNazovBudovy() {
        return super.getNazovBudovy();
    }

    @Override
    public Miestnost[] getZoznamMiestnosti() {
        return super.getZoznamMiestnosti();
    }

    public String getAdresa() {
        return this.adresa;
    }
}
