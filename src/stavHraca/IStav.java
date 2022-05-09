package stavHraca;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * interface využívaný pre atributy triedy StavHraca
 *
 */
public interface IStav {

    int pridaj(int pocet);
    int odober(int pocet);
    int getMnozstvo();
    void setMnozstvo(int paPocet);
}
