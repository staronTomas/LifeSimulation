package stavHraca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda má atributy zdravie, hlad, smäd a energia
 * trieda má na starosti tieto hodnoty a teda riadi stav hráča
 *
 */
public class StavHraca {

    private Zdravie zdravie;
    private Hlad hlad;
    private Smad smad;
    private Energia energia;


    public StavHraca() {
        this.zdravie = new Zdravie();
        this.hlad = new Hlad();
        this.smad = new Smad();
        this.energia = new Energia();
    }




    public Zdravie getZdravie() {
        return this.zdravie;
    }

    public Hlad getHlad() {
        return this.hlad;
    }

    public Smad getSmad() {
        return this.smad;
    }

    public Energia getEnergia() {
        return this.energia;
    }


}
