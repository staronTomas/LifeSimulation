package budovyAMiestnosti;

import aktivity.Nakupovanie;
import predmety.Jedlo;
import predmety.Liek;
import predmety.Pitie;
import predmety.Predmet;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Potomok triedy Budova, Hráč môže vstupiť do inštancie tejto triedy a nakupovťa v miestnostiach predmety
 *
 */
public class ObchodneStredisko extends Budova {

    public ObchodneStredisko(String paMeno, int pocetMiestnosti) {
        super(paMeno, pocetMiestnosti);
        super.getZoznamMiestnosti()[0] = new Miestnost("Vstupna hala");
        super.getZoznamMiestnosti()[1] = new Miestnost("Drogeria");
        super.getZoznamMiestnosti()[2] = new Miestnost("Potraviny");
        super.getZoznamMiestnosti()[3] = new Miestnost("Lekaren");


        //aktivity v drogerii
        Predmet[] zoznamPredmetovDrogeria = new Predmet[7];
        zoznamPredmetovDrogeria[0] = new Predmet("Sprchovy gel", 2.49);
        zoznamPredmetovDrogeria[1] = new Predmet("Zubna kefka", 4.99);
        zoznamPredmetovDrogeria[2] = new Predmet("Zubna pasta", 3.80);
        zoznamPredmetovDrogeria[3] = new Predmet("Antiperspirant", 1.89);
        zoznamPredmetovDrogeria[4] = new Predmet("Papierové vreckovky", 0.89);
        zoznamPredmetovDrogeria[5] = new Predmet("Rúž", 3.29);
        zoznamPredmetovDrogeria[6] = new Predmet("Vrece na odpad", 0.49);

        super.getZoznamMiestnosti()[1].pridajAktivitu(new Nakupovanie("Nakupovať v " + super.getZoznamMiestnosti()[1].getNazovMiestnosti(), 10, 30, 7, 8, zoznamPredmetovDrogeria));

        //aktivity v Potravinach
        Predmet[] zoznamPredmetovPotraviny = new Predmet[8];
        zoznamPredmetovPotraviny[0] = new Jedlo("Žemľa", 0.19, 3, 15);
        zoznamPredmetovPotraviny[1] = new Jedlo("Kebab", 2.89, 5, 25);
        zoznamPredmetovPotraviny[2] = new Jedlo("Jablko", 0.99, 3, 7);
        zoznamPredmetovPotraviny[3] = new Jedlo("Obložená bageta s dresingom", 5.59, 6, 26);
        zoznamPredmetovPotraviny[4] = new Pitie("Čistá voda", 1.59, 0, 15);
        zoznamPredmetovPotraviny[5] = new Pitie("Coca-Cola", 1.59, 4, 10);
        zoznamPredmetovPotraviny[6] = new Pitie("Fanta", 2.59, 2, 13);
        zoznamPredmetovPotraviny[7] = new Pitie("Pivo", 2.59, 3, 11);
        super.getZoznamMiestnosti()[2].pridajAktivitu(new Nakupovanie("Nakupovať v " + super.getZoznamMiestnosti()[2].getNazovMiestnosti(), 10, 30, 7, 8, zoznamPredmetovPotraviny));

        //aktivity v Lekarni
        Predmet[] zoznamPredmetovLekaren = new Predmet[5];
        zoznamPredmetovLekaren[0] = new Liek("Paralen", 15.8, 3);
        zoznamPredmetovLekaren[1] = new Liek("Mucosolvan Retard", 45.8, 8);
        zoznamPredmetovLekaren[2] = new Liek("Ibuprofen 2000mg", 26.8, 5);
        zoznamPredmetovLekaren[3] = new Liek("Ultra rýchly liek", 1000, 100);
        super.getZoznamMiestnosti()[3].pridajAktivitu(new Nakupovanie("Nakupovať v " + super.getZoznamMiestnosti()[3].getNazovMiestnosti(), 10, 30, 7, 8, zoznamPredmetovLekaren));

    }

    @Override
    public String getNazovBudovy() {
        return super.getNazovBudovy();
    }

    @Override
    public Miestnost[] getZoznamMiestnosti() {
        return super.getZoznamMiestnosti();
    }
}
