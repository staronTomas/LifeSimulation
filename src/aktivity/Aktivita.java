package aktivity;

import javax.swing.JOptionPane;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 * Trieda využívaná na vytvorenie aktivity, ktoré bude hráč vykonávať
 */
public class Aktivita {

    private String nazovAktivity;
    private int potrebnaEnergia;
    private int casKtoryUbehneMinuty;
    private int zvysenieHladu;
    private int zvysenieSmadu;


    public Aktivita(String nazov, int paEnergia, int cas, int paZvysenieHladu, int paZvysenieSmadu) {
        // Parametrický konštruktor
        this.nazovAktivity = nazov;
        this.potrebnaEnergia = paEnergia;
        this.casKtoryUbehneMinuty = cas;
        this.zvysenieHladu = paZvysenieHladu;
        this.zvysenieSmadu = paZvysenieSmadu;
    }


    public String getNazovAktivity() {
        return this.nazovAktivity;
    }

    public void vykonajAktivitu() {
        JOptionPane.showMessageDialog(null, "Vykonal si túto aktivitu.");
    }

    public int getKolkoCasuUbehneMinuty() {
        return this.casKtoryUbehneMinuty;
    }

    public int getPotrebnaEnergia() {
        return this.potrebnaEnergia;
    }

    public int getZvysenieHladu() {
        return this.zvysenieHladu;
    }

    public int getZvysenieSmadu() {
        return this.zvysenieSmadu;
    }
}
