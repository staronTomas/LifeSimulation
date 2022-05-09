package stavHraca;

import javax.swing.JOptionPane;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda implementuje interface IStav
 * Určuje zdravie hráča, kontroluje či hodnota zdravia neklesla pod 0 atd
 *
 */
public class Zdravie implements IStav {

    private int mnozstvo;


    public Zdravie() {
        this.mnozstvo = 100;
    }


    @Override
    public int pridaj(int pocet) {
        this.mnozstvo += pocet;
        if (this.mnozstvo > 100) {
            this.mnozstvo = 100;
        }
        // pri zdravi nepotrebujem nič špecialne returnut
        return this.mnozstvo;
    }

    @Override
    public int odober(int pocet) {
        this.mnozstvo -= pocet;
        if (this.mnozstvo < 0) {
            this.skonciHru();
        }
        return this.mnozstvo;
    }

    @Override
    public int getMnozstvo() {
        return this.mnozstvo;
    }

    @Override
    public void setMnozstvo(int paPocet) {
        this.mnozstvo = paPocet;
    }

    public void skonciHru() {
        // pokiaľ zdravie kleslo pod hodnotu 0, vykoná sa táto metóda a hra sa skončí
        this.mnozstvo = 0;
        JOptionPane.showMessageDialog(null, "GAME OVER!!! \n Zomrel si, pretože tvoje zdravie kleslo na NULU.");
        System.exit(0);
    }
}
