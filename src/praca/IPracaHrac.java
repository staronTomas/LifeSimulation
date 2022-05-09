package praca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Interface
 * Využívaný pre hráca, aby mohol využívať metody na Prácu
 *
 */
public interface IPracaHrac {

    boolean zamestnajSa(Praca praca);
    boolean dajVypoved();
    boolean chodDoPrace(int kolkoHodin);

}
