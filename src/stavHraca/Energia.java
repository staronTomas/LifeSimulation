package stavHraca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda implementuje interface IStav
 *
 * Riadi Energiu hráča
 */
public class Energia implements IStav {

    private int mnozstvo;

    public Energia() {
        this.mnozstvo = 100;
    }


    @Override
    public int pridaj(int pocet) {
        this.mnozstvo += pocet;
        if (this.mnozstvo > 100) {
            this.mnozstvo = 100;
        }
        return 0;
    }

    @Override
    // bude vraciat číslo... v prípade, že by hodnota hladu/energie/smadu
    // klesla pod 0 tak sa nezvýši na minusovu hodnotu, ale zvyšok sa odpočíta od hodnoty zdravia
    // to co je v returne sa ma vzdy odcitat od zdravia
    public int odober(int pocet) {
        this.mnozstvo -= pocet;
        int medziCislo = 0;
        if (this.mnozstvo < 0) {
            medziCislo = this.mnozstvo;
            this.mnozstvo = 0;
            return medziCislo;
        }

        if (this.mnozstvo > 100) {
            this.mnozstvo = 100;
        }
        return medziCislo;
    }

    @Override
    public int getMnozstvo() {
        return this.mnozstvo;
    }

    @Override
    public void setMnozstvo(int paPocet) {
        this.mnozstvo = paPocet;
    }
}
