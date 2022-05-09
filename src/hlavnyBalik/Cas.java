package hlavnyBalik;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda ma na starosti riadenie času
 *
 *
 */
public class Cas {
    private int minuty;
    private int hodiny;
    private int den;
    private int mesiac;
    private int rok;


    public Cas() {
        //bez parametrický konštruktor
        Date date = new Date();

        this.hodiny = date.getHours();
        this.minuty = date.getMinutes();


        LocalDate currentdate = LocalDate.now();
        this.den = currentdate.getDayOfMonth();
        this.mesiac = Calendar.getInstance().get(Calendar.MONTH) + 1;
        this.rok = currentdate.getYear();
    }

    public void posunCas(int pocetHodin, int pocetMinut, int pocetDni, int pocetMesiacov, int pocetRokov) {
        //Metoda vykonáva posun času, dáva pozor nato, aby všetko bolo ako v reálnom živote
        // nepresiahne sa napr. počet minút 59
        this.minuty += pocetMinut;
        this.hodiny += pocetHodin;
        this.den += pocetDni;
        this.mesiac += pocetMesiacov;
        this.rok += pocetRokov;

        while (this.minuty >= 60) {
            this.hodiny++;
            this.minuty -= 60;
        }

        while (this.hodiny >= 24) {
            this.den++;
            this.hodiny -= 24;
        }

        while (this.den >= 31) {
            this.mesiac++;
            this.den -= 30;
        }

        while (this.mesiac >= 13) {
            this.rok++;
            this.mesiac -= 12;
        }

    }

    public int getMinuty() {
        return this.minuty;
    }

    public int getHodiny() {
        return this.hodiny;
    }

    public int getDen() {
        return this.den;
    }

    public int getMesiac() {
        return this.mesiac;
    }

    public int getRok() {
        return this.rok;
    }

    public String getTime() {
        return this.hodiny + "-" + this.minuty + "-" + this.den + "-" + this.mesiac + "-" + this.rok;
    }


    public void setMinuty(int minuty) {
        this.minuty = minuty;
    }

    public void setHodiny(int hodiny) {
        this.hodiny = hodiny;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public void setMesiac(int mesiac) {
        this.mesiac = mesiac;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }
}