package hlavnyBalik;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 * Hlavná metoda
 * slúži na zapnutie hry a vytvorenie inštancie triedy Hra
 */
public class Main {
    private static Hra hra;

    public static void main(String[] args) {
        hra = new Hra();
        hra.hraj();
        System.exit(0);
    }
}
