package hlavnyBalik;

import aktivity.Aktivita;
import budovyAMiestnosti.Budova;
import budovyAMiestnosti.Domov;
import budovyAMiestnosti.ObchodneStredisko;
import budovyAMiestnosti.Policia;
import budovyAMiestnosti.Miestnost;
import aktivity.Nakupovanie;
import praca.Bannik;
import praca.Praca;
import praca.Programator;
import praca.Ucitel;
import praca.Zlodej;
import predmety.Jedlo;
import predmety.Liek;
import predmety.Pitie;
import predmety.Predmet;


import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Inštancie tejto triedy je vytvorená Mainom pri spustení hry
 *
 * Trieda riadi samotný priebeh hry, má na starosti všetko základné
 *
 */
public class Hra {


    private Hrac hrac;
    private Cas cas;
    private Screen screen;
    private Budova[] zoznamBudov;
    private ArrayList<Praca> zoznamPrac;

    public Hra() {
        //Konštruktor
        //Defaultné údaje, ktoré sú nastavené pri zapnutí hry

        this.screen = new Screen();
        this.zoznamBudov = new Budova[3];
        this.zoznamBudov[0] = new Domov("Domov", 5, "Nábrežná 543/9"); // vstupna chodba, kupelna, kuchyna, obyvacka, spalen
        this.zoznamBudov[1] = new ObchodneStredisko("Obchodne stredisko", 4); // vstupna chodba, potraviny, lekaren, nabytok, zabavny park
        this.zoznamBudov[2] = new Policia("Policia", 3); //vstupna chodba, cela

        //Zoznam prác, ktoré v hre existujú
        this.zoznamPrac = new ArrayList<>();
        this.zoznamPrac.add(new Bannik("Bannik", 10, 8.5, 2));
        this.zoznamPrac.add(new Programator("Programator", 8, 10.25));
        this.zoznamPrac.add(new Ucitel("Ucitel", 9, 7.8));
        this.zoznamPrac.add(new Zlodej("Zlodej", 6, 20));
    }

    public void hraj() {
        int vyberInt = 9999;
        JOptionPane.showMessageDialog(null, "Vitaj v hre LifeSimulation! :)");
        String meno = JOptionPane.showInputDialog("Zadaj svoje meno:" );
        this.hrac = new Hrac(meno, this.zoznamBudov[0]);
        this.cas = new Cas();
        this.nastavCas();


        this.hrac.getInventar().add(new Pitie("Coca-cola", 0.89, 4, 15 ));
        this.hrac.getInventar().add(new Jedlo("Kebab", 2.89, 3,  25));
        this.hrac.getInventar().add(new Predmet("Stolička", 15.89));
        this.hrac.getInventar().add(new Liek("Paralen", 15.89, 5));

        // Predmety vlozene iba pre skúsku




        this.cas = new Cas();
        while (true) {
            String vyber = JOptionPane.showInputDialog(null, "Zvoľ si možnosť: \n" +
                    "Zapnúť hru - 1 \n" +
                    "Ako hrať? - 2 \n" +
                    "Načítať uloženú hru - 3 \n" +
                    "Uložiť hru - 4 \n" +
                    "Ukončiť hru - 0");
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
            } else {
                JOptionPane.showMessageDialog(null, "Zamysli sa nad sebou či to čo si zadal je vôbec číslo, potom príď hrať túto hru.");
                continue;
            }
            switch (vyberInt) {
                case 1:
                    this.zapniHru();
                    break;
                case 2:
                    this.zobrazitInfo();
                    break;
                case 3:
                    this.nacitajHru();
                    break;
                case 4:
                    this.ulozHru();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Zvolil si neexistujúcu možnosť, prosím skús sa nad sebou zamyslieť.");
            }
        }
    }

    public void nacitajHru() {
        String nazovSuboru = JOptionPane.showInputDialog(null, "Napíš názov súboru, ktorý chceš načítať do hry.\n" +
                "Zatvoriť - 0");
        if (nazovSuboru.equals("0")) {
            return;
        }

        String cesta = "D:\\UNIZA FRI\\2. semester\\Informatika 2\\Semestralna_Praca\\LifeSimulation\\src\\SavedGames\\";
        cesta += nazovSuboru;
        cesta += ".txt";
        try {
            File myObj = new File(cesta);
            Scanner sc = new Scanner(myObj);
            String meno = sc.nextLine();
            this.hrac.setMeno(meno);
            int zivot = Integer.parseInt(sc.nextLine());
            this.hrac.getStavHraca().getZdravie().setMnozstvo(zivot);
            int energia = Integer.parseInt(sc.nextLine());
            this.hrac.getStavHraca().getEnergia().setMnozstvo(energia);
            int hlad = Integer.parseInt(sc.nextLine());
            this.hrac.getStavHraca().getHlad().setMnozstvo(hlad);
            int smad = Integer.parseInt(sc.nextLine());
            this.hrac.getStavHraca().getSmad().setMnozstvo(smad);
            double peniaze = Double.parseDouble(sc.nextLine());
            this.hrac.setPeniaze(peniaze);
            String praca = sc.nextLine();
            switch (praca) {
                case "Bannik":
                    this.hrac.setZamestnanie(this.zoznamPrac.get(0));
                    break;
                case "Programator":
                    this.hrac.setZamestnanie(this.zoznamPrac.get(1));
                    break;
                case "Ucitel":
                    this.hrac.setZamestnanie(this.zoznamPrac.get(2));
                    break;
                case "Zlodej":
                    this.hrac.setZamestnanie(this.zoznamPrac.get(3));
                    break;
                default:
                    this.hrac.setZamestnanie(null);
                    break;
            }

            String[] casSubor = sc.nextLine().split("-");

            this.cas.setMinuty(Integer.parseInt(casSubor[0]));
            this.cas.setHodiny(Integer.parseInt(casSubor[1]));
            this.cas.setDen(Integer.parseInt(casSubor[2]));
            this.cas.setMesiac(Integer.parseInt(casSubor[3]));
            this.cas.setRok(Integer.parseInt(casSubor[4]));
            this.nastavCas();
            this.zobrazNovyStavHraca();


            sc.close();


        } catch (FileNotFoundException e) {
            System.out.println("Súbor sa nepodarilo načítať, pravdepodobne neexistuje");
            e.printStackTrace();
            return;
        }
    }


    public void ulozHru() {
        String nazovSuboru = JOptionPane.showInputDialog(null, "Napíš názov súboru, do ktorého chceš uložiť svoju hru.\n" +
                "Zatvoriť - 0");
        if (nazovSuboru.equals("0")) {
            return;
        }

        String cesta = "D:\\UNIZA FRI\\2. semester\\Informatika 2\\Semestralna_Praca\\LifeSimulation\\src\\SavedGames\\";
        cesta += nazovSuboru;
        cesta += ".txt";
        try {
            File myObj = new File(cesta);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

                // text, kde napíšem čo chcem, aby sa uložilo
                String saveText = this.hrac.getMeno() + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getZdravie().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getEnergia().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getHlad().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getSmad().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getPeniaze()) + "\n";


                if (this.hrac.getZamestnanie() != null) {
                    saveText += this.hrac.getZamestnanie().getNazov() + "\n";
                } else {
                    saveText += "null\n";
                }

                saveText += String.valueOf(this.cas.getTime()) + "\n";

                PrintWriter writer = new PrintWriter(cesta);
                writer.print(saveText);
                writer.close();
            } else {
                System.out.println("Súbor s takýmto názvom už existuje.");
                // Spraviť sem prepis súboru
                int n1 = JOptionPane.showConfirmDialog(null, "Hra s takýmto názvom je už uložená, chceš ju prepísať?", "UPOZORNENIE !!!", JOptionPane.YES_NO_OPTION);
                if (n1 != 0) {
                    return;
                }
                PrintWriter writer = new PrintWriter(cesta);
                writer.print("");
                String saveText = this.hrac.getMeno() + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getZdravie().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getEnergia().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getHlad().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getStavHraca().getSmad().getMnozstvo()) + "\n";
                saveText += String.valueOf(this.hrac.getPeniaze()) + "\n";
                saveText += String.valueOf(this.cas.getTime());

                if (this.hrac.getZamestnanie() != null) {
                    saveText += this.hrac.getZamestnanie().getNazov() + "\n";
                } else {
                    saveText += "null";
                }

                writer.print(saveText);
                writer.close();

            }
        } catch (IOException e) {
            System.out.println("Nastala chyba!");
            e.printStackTrace();
            return;
        }
    }

    public void zobrazitInfo() {
        JOptionPane.showMessageDialog(null,  this.hrac.getMeno() + " tvojou úlohou je prežiť čo najdlhšie. " +
                "Musíš jesť, piť, a spať aby si doplnil svoje životné potreby. Hore vpravo máš zobrazené svoj momentálny stav, dávaj preto na seba pozor. \n" +
                "Máš svoj vlastný domov, inventár a prácu kde zarábaš peniaze na jedlo, pitie alebo iné zaujímavé predmety. \n" +
                "Za peniaze si môžeš kúpiť rôzne predmety a následne sa umiestnia do tvojho inventára, ktorý má 20 slotov. \n" +
                "V hre existuje niekoľko budov: Obchody, Nemocnica a Polícia. Pýtaš sa ako sa dostaneš na políciu? \n" +
                "Veľmi jednoducho. Napríklad... Existuje šanca, že pri ceste do práce prekročíš povolenú rýchlosť a budeš musieť na polícií zaplatiť pokutu, \ninak ťa nepustia. " +
                "Hra skončí ked zomrieš alebo nemáš za čo zaplatiť neiktoré z poplatkov." );
    }






    public void zapniHru() {
        int vyberInt = 9999;
        boolean koniec = false;
        while (!koniec) {
            String message = "Zvoľ si možnosť: \n" +
                    "Zobraziť inventár - 1 \n" +
                    "Zobraziť aktivity v miestnosti - 2 \n" +
                    "Zobraziť miestnosti v budove- 3 \n" +
                    "Zobraziť budovy kam môžem ísť - 4 \n" +
                    "Ísť do práce - 5 \n";
            if (this.getHrac().getZamestnanie() != null)  {
                message += "Daj v práci výpoveď - 6 \n" + "\n";
            }
            message += "Hlavné menu - 0";
            String vyber = JOptionPane.showInputDialog(null, message);
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
            } else {
                JOptionPane.showMessageDialog(null, "Zamysli sa nad sebou či to čo si zadal je vôbec číslo, potom príď hrať túto hru.");
                continue;
            }
            switch (vyberInt) {
                case 1:
                    this.otvorInventar();
                    break;
                case 2:
                    this.dajZoznamAktivit();
                    break;
                case 3:
                    this.dajMiestnostiBudovy();
                    break;
                case 4:
                    this.dajKamIst();
                    break;
                case 5:
                    this.chodDoPrace();
                    break;
                case 6:
                    this.hrac.dajVypoved();
                    JOptionPane.showMessageDialog(null, "Dal si v práci výpoveď.");
                    this.zapniHru();
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Zvolil si neexistujúcu možnosť, prosím skús sa nad sebou zamyslieť.");
            }
        }
    }



    private void chodDoPrace() {

        // kontrola či je hráč zamestnaný alebo nie
        if (this.hrac.getZamestnanie() == null) {
            JOptionPane.showMessageDialog(null, "Nie si zamestaný, musíš sa najprv zamestnať!");
            if (this.najdiZamestnanie()) {
                JOptionPane.showMessageDialog(null, "Gratulujem, zamestnal si sa!");
            } else {
                this.zapniHru();
            }
        }


        // samotné vykonanie práce
        int potrebnaEnergia = 0;
        String vyber = JOptionPane.showInputDialog(null, "Koľko hodín chceš odpracovať? \nZrušiť ponuku - 0");
        int intVyber = Integer.parseInt(vyber);
        if (intVyber == 0) {
            this.zapniHru();
        }

        // potrebna energia na vykonanie prace
        potrebnaEnergia = intVyber * this.getHrac().getZamestnanie().getNarocnostPraceEnergiaNaHodinu();

        //overenie či sa hráč nezabije toľkým počtom hodín
        if (((this.getHrac().getStavHraca().getEnergia().getMnozstvo() + this.getHrac().getStavHraca().getZdravie().getMnozstvo()) - potrebnaEnergia) <= 0) {
            int n1 = JOptionPane.showConfirmDialog(null, "Robíš si srandu? Takáto dlhá pracovná doba by ťa zabila!\n" +
                    "Dávam ti poslednú možnosť či chceš naozaj pracovať " + intVyber + " hodín.", "UPOZORNENIE !!!", JOptionPane.YES_NO_OPTION);
            if (n1 != 0) {
                this.chodDoPrace();
            }
        }

        if (potrebnaEnergia > (this.getHrac().getStavHraca().getEnergia().getMnozstvo())) {
            int n1 = JOptionPane.showConfirmDialog(null, "Nemáš dostatok energie nato, aby si mohol tak dlho pracovať,\n" +
                    "ako dôsledok toho sa ti zníži zdravie. \n" +
                    "Určite chceš aj tak odpracovať toľko veľa hodín?", "UPOZORNENIE !!!", JOptionPane.YES_NO_OPTION);
            if (n1 != 0) {
                this.chodDoPrace();
            }
        }

        // 10% šanca, že ak má človek povolanie Zlodej tak ho chytí polícia
        if (this.hrac.getZamestnanie() instanceof Zlodej) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (num <= 10) {
                this.chodDoVazenia();
            }
        }


        this.overCiNemaKlesnutZdravie(this.hrac.getStavHraca().getEnergia().odober(potrebnaEnergia));
        this.overCiNemaKlesnutZdravie(this.hrac.getStavHraca().getHlad().pridaj(intVyber * 5));
        this.overCiNemaKlesnutZdravie(this.hrac.getStavHraca().getSmad().pridaj(intVyber * 5));
        double vyplata = this.hrac.getZamestnanie().dajVyplatu(intVyber);
        this.hrac.pridajPeniaze(vyplata);
        this.cas.posunCas(intVyber, 0, 0, 0, 0);
        this.nastavCas();
        this.zobrazNovyStavHraca();


    }


    private boolean najdiZamestnanie() {
        String zoznam = "";
        for (int i = 0; i < this.zoznamPrac.size(); i++) {
            zoznam += this.zoznamPrac.get(i).getNazov() + " - vyplata: " + this.zoznamPrac.get(i).getPlat() + " ... energia/hodina: " + this.zoznamPrac.get(i).getNarocnostPraceEnergiaNaHodinu() + "    - " + (i + 1) + "\n";
        }
        zoznam += "Zatvoriť ponuku práce - 0 ";
        String vyber = JOptionPane.showInputDialog(null, zoznam);
        if (vyber.equals("0")) {
            return false;
        }
        this.getHrac().zamestnajSa(zoznamPrac.get((Integer.parseInt(vyber) - 1)));
        return true;
    }


    private void dajKamIst() {
        int vyberInt = 999;
        String zoznam = "Zoznam budov kam sa môžeš presunúť: \n"; // do tohto Stringu sa ulozi vypis inventara

        for (int i = 1; i < this.zoznamBudov.length + 1; i++) {
            zoznam += this.zoznamBudov[i - 1].getNazovBudovy() + " - " + i + "\n";
        }
        zoznam += "Zatvoriť - 0";
        while (true) {
            this.cas.posunCas( 0, 1, 0, 0, 0);
            this.nastavCas();
            String vyber = JOptionPane.showInputDialog(null, zoznam);
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Zamysli sa nad sebou či to čo si zadal je vôbec číslo, potom príď hrať túto hru.");
                continue;
            }
        }
        if (vyberInt == 0) {
            this.zapniHru();
        }
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high - low) + low;

        if (result <= 20) {
            this.getHrac().setAktualnaBudova(this.zoznamBudov[2]);
            this.zmenBudovuMiestnost(this.zoznamBudov[2], this.zoznamBudov[2].getZoznamMiestnosti()[2]);
            this.getHrac().setAktualnaMiestnost(this.zoznamBudov[2].getZoznamMiestnosti()[2]);
            this.chodDoVazenia();
        }

        switch (vyberInt) {
            case 1:
                this.getHrac().setAktualnaBudova(this.zoznamBudov[0]);
                this.zmenBudovuMiestnost(this.zoznamBudov[0], this.zoznamBudov[0].getZoznamMiestnosti()[0]);
                this.getHrac().setAktualnaMiestnost(this.zoznamBudov[0].getZoznamMiestnosti()[0]);
                break;

            case 2:
                this.getHrac().setAktualnaBudova(this.zoznamBudov[1]);
                this.getHrac().setAktualnaMiestnost(this.zoznamBudov[1].getZoznamMiestnosti()[0]);
                this.zmenBudovuMiestnost(this.zoznamBudov[1], this.zoznamBudov[1].getZoznamMiestnosti()[0]);
                break;

            case 3:
                this.getHrac().setAktualnaBudova(this.zoznamBudov[2]);
                this.getHrac().setAktualnaMiestnost(this.zoznamBudov[2].getZoznamMiestnosti()[0]);
                this.zmenBudovuMiestnost(this.zoznamBudov[2], this.zoznamBudov[2].getZoznamMiestnosti()[0]);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Prosím zadaj id budovy zo zoznamu");
                break;
        }

    }

    private void chodDoVazenia() {
        Policia policia = (Policia)this.zoznamBudov[2];
        JOptionPane.showMessageDialog(null, "Bohužiaľ počas cesty do vybranej budovy si prekročil rýchlosť\na polícia ťa zavrela do väzenia. " +
                "Musíš zaplatiť pokutu vo výške: " + policia.getVyskaKaucie() + " €.");
        if (this.getHrac().getPeniaze() < policia.getVyskaKaucie()) {
            JOptionPane.showMessageDialog(null, "GAME OVER !!!\n" +
                    "Po prepocitaní tvojich financii sme zistili, že nemas tolko penazi, aby si mohol zaplatit kauciu. \n" +
                    "Bohužiaľ tu hra pre teba končí.");
            System.exit(0);
        }
        boolean zaplatene = false;
        while (!zaplatene) {
            overCiNemaKlesnutZdravie(this.getHrac().getStavHraca().getEnergia().odober(5));
            overCiNemaKlesnutZdravie(this.getHrac().getStavHraca().getHlad().pridaj(10));
            overCiNemaKlesnutZdravie(this.getHrac().getStavHraca().getSmad().pridaj(10));
            this.zobrazNovyStavHraca();

            this.cas.posunCas(1, 0, 0, 0, 0);
            this.nastavCas();

            JOptionPane.showMessageDialog(null, "Kľudne tu aj zomri od hladu a smädu, ale kým nezaplatíš pokutu tak odtiaľto neodídeš!");
            int n1 = JOptionPane.showConfirmDialog(null, "Zaplatiť pokutu?", "Pokuta" + policia.getVyskaKaucie(), JOptionPane.YES_NO_OPTION);
            if (n1 == 0) {
                zaplatene = true;
            }
        }
        this.getHrac().odoberPeniaze(policia.getVyskaKaucie());
        this.getHrac().setAktualnaBudova(this.zoznamBudov[0]);
        this.getHrac().setAktualnaMiestnost(this.zoznamBudov[0].getZoznamMiestnosti()[0]);
        this.zmenBudovuMiestnost(this.zoznamBudov[0], this.zoznamBudov[0].getZoznamMiestnosti()[0]);
        this.zobrazNovyStavHraca();


        JOptionPane.showMessageDialog(null, "Super, že si sa rozhodol zaplatiť pokutu!");

    }


    public void otvorInventar() {
        int vyberInt = 999;
        String inventar = ""; // do tohto Stringu sa ulozi vypis inventara
        for (int i = 0; i < this.getHrac().getInventar().size(); i++) {
            inventar += this.getHrac().getInventar().get(i).getNazovpredmetu() + " - " + (i + 1) + "\n";
        }
        inventar += "zatvoriť inventár - 0";
        while (true) {
            this.cas.posunCas( 0, 1, 0, 0, 0);
            this.nastavCas();
            String vyber = JOptionPane.showInputDialog(null, inventar);
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Zamysli sa nad sebou či to čo si zadal je vôbec číslo, potom príď hrať túto hru.");
                continue;
            }

        }
        if (vyberInt == 0) {
            return;
        }
        for (int i = 0; i < this.getHrac().getInventar().size(); i++) {
            if ((i + 1) == vyberInt) {
                // SEM POJDE POPIS PREDMETU a možnosti čo sa s ním dá robiť
                String vypis = this.getHrac().getInventar().get(i).dajPopis() + "\n";
                if (this.getHrac().getInventar().get(i) instanceof Pitie) {
                    vypis += "Vypiť nápoj - 1";
                } else if (this.getHrac().getInventar().get(i) instanceof Jedlo) {
                    vypis += "Zjest jedlo - 1";
                } else if (this.getHrac().getInventar().get(i) instanceof Liek) {
                    vypis += "Použi liek - 1";
                } else {
                    vypis += "Použiť predmet - 1";
                }
                vypis += "\n";
                vypis += "Predať - 2 \n";
                vypis += "Zahodiť predmet - 3 \n";
                vypis += "Zatvoriť inventár - 0";
                while (true) {
                    String vyber = JOptionPane.showInputDialog(null, vypis);
                    if (this.kontrolaCiJeToCislo(vyber)) {
                        vyberInt = Integer.parseInt(vyber);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Musíš zadať číslo!");
                        continue;
                    }
                }

                switch (vyberInt) {
                    case 0:
                        return;
                    case 1:
                        // Z Inventara hráča si zoberiem objekt typu Predmet a zistujem potom aký jeho potomok to je a na základe toho zmením atribúty hráča
                        if (this.getHrac().getInventar().get(i) instanceof Pitie) {
                            this.getHrac().getStavHraca().getSmad().odober(((Pitie)this.getHrac().getInventar().get(i)).getMinusSmad());
                            this.getHrac().getStavHraca().getEnergia().pridaj(((Pitie)this.getHrac().getInventar().get(i)).getEnergyGain());
                            this.zobrazNovyStavHraca();
                            JOptionPane.showMessageDialog(null, this.hrac.getInventar().get(i).pouziPredmet());
                            this.hrac.getInventar().remove(i);
                        } else if (this.getHrac().getInventar().get(i) instanceof Jedlo) {
                            this.getHrac().getStavHraca().getHlad().odober(((Jedlo)this.getHrac().getInventar().get(i)).getMinusHlad());
                            this.getHrac().getStavHraca().getEnergia().pridaj(((Jedlo)this.getHrac().getInventar().get(i)).getEnergyGain());
                            this.zobrazNovyStavHraca();
                            JOptionPane.showMessageDialog(null, this.hrac.getInventar().get(i).pouziPredmet());
                            this.hrac.getInventar().remove(i);
                        } else if (this.getHrac().getInventar().get(i) instanceof Liek) {
                            this.getHrac().getStavHraca().getZdravie().pridaj(((Liek)this.getHrac().getInventar().get(i)).getKolkoZdraviaPrida());
                            this.zobrazNovyStavHraca();
                            JOptionPane.showMessageDialog(null, this.hrac.getInventar().get(i).pouziPredmet());
                            this.hrac.getInventar().remove(i);
                        } else {
                            JOptionPane.showMessageDialog(null, this.hrac.getInventar().get(i).pouziPredmet());
                        }
                        this.otvorInventar();
                        break;

                    case 2:
                        int n = JOptionPane.showConfirmDialog(null, "Naozaj chceš túto položku predať?", "Potvrdenie akcie", JOptionPane.YES_NO_OPTION);
                        if (n == 0) {
                            this.getHrac().pridajPeniaze(this.getHrac().getInventar().get(i).dajCenu());
                            this.zobrazNovyStavHraca();
                            JOptionPane.showMessageDialog(null, "Predal si ho za : " + this.getHrac().getInventar().get(i).dajCenu() + " €");
                            this.getHrac().getInventar().remove(i);
                        }
                        this.otvorInventar();
                        break;

                    case 3:
                        int n1 = JOptionPane.showConfirmDialog(null, "Naozaj chceš túto položku zahodiť?", "Potvrdenie akcie", JOptionPane.YES_NO_OPTION);
                        if (n1 == 0) {
                            this.getHrac().getInventar().remove(i);
                        }
                        this.otvorInventar();
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Zadaj číslo, ktoré zodpovedá príkazu!");
                        continue;
                }


                break; // ak sa nájde daný predmet s indexom, ktorý zadal používateľ, tak sa ukončí for po vykonaní všetkého
            }
            if (i == this.getHrac().getInventar().size()) {
                JOptionPane.showMessageDialog(null, "Zvolil si neexistujúcu možnosť.");
            }
        }
    }




    public void dajZoznamAktivit() {
        //metoda vrati zoznam aktivit v danej miestnosti
        ArrayList<Aktivita> aktivity = this.getHrac().getAktualnaMiestnost().getZoznamAktivit();
        int vyberInt = 999;
        String zoznamAktivit = "";

        // kontrola ci su k dispozicii nejake aktivity, ak nie tak to oznami a vrati do predoslej metody
        if (aktivity.size() == 0) {
            JOptionPane.showMessageDialog(null, "Žiadne aktivity tu nemôžeš vykonať.");
            this.zapniHru();
        }
        for (int i = 0; i < aktivity.size(); i++) {
            zoznamAktivit += aktivity.get(i).getNazovAktivity() + " - " + (i + 1) + "\n";
        }
        zoznamAktivit += "Zatvoriť zoznam aktivit - 0";
        while (true) {
            this.cas.posunCas( 0, 1, 0, 0, 0);
            this.nastavCas();
            String vyber = JOptionPane.showInputDialog(null, zoznamAktivit);
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Musíš zadať číslo!");
                continue;
            }

        }
        if (vyberInt == 0) {
            return;
        }
        for (int i = 0; i < this.getHrac().getAktualnaMiestnost().getZoznamAktivit().size(); i++) {
            if ((vyberInt - 1) == i) {
                Aktivita aktivita = this.getHrac().getAktualnaMiestnost().getZoznamAktivit().get(i);

                if (aktivita instanceof Nakupovanie) {
                    this.dajZoznamTovaruVObchode((Nakupovanie)aktivita);
                } else {
                    aktivita.vykonajAktivitu();
                }


                overCiNemaKlesnutZdravie(this.getHrac().getStavHraca().getEnergia().odober(aktivita.getPotrebnaEnergia()));
                overCiNemaKlesnutZdravie(this.getHrac().getStavHraca().getHlad().pridaj(aktivita.getZvysenieHladu()));
                overCiNemaKlesnutZdravie(this.getHrac().getStavHraca().getSmad().pridaj(aktivita.getZvysenieSmadu()));
                this.cas.posunCas(0, aktivita.getKolkoCasuUbehneMinuty(), 0, 0, 0);
                this.nastavCas();
                this.zobrazNovyStavHraca();

            }
        }
    }

    private void dajZoznamTovaruVObchode(Nakupovanie nakupovanie) {
        //Vráti zoznam tovaru v obchode
        int vyberInt = 999;
        while (true) {
            String zoznam = "Zoznam Predmetov na zakúpenie\n";
            for (int i = 0; i < nakupovanie.getZoznamPredmetov().length; i++) {
                zoznam += nakupovanie.getZoznamPredmetov()[i].dajPopis() + "   - " + (i + 1) + "\n";
            }
            zoznam += "\n";
            zoznam += "Zavrieť zoznam - 0";
            String vyber = JOptionPane.showInputDialog(null, zoznam);
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Musíš zadať číslo!");
                continue;
            }
        }
        if (vyberInt == 0) {
            return;
        }

        if (vyberInt >= 1 && vyberInt <= nakupovanie.getZoznamPredmetov().length) {
            Predmet predmet = nakupovanie.getZoznamPredmetov()[vyberInt - 1];
            if (predmet.dajCenu() > getHrac().getPeniaze()) {
                JOptionPane.showMessageDialog(null, "Nedostatok penazi!");
            } else {
                int n1 = JOptionPane.showConfirmDialog(null, predmet.getNazovpredmetu() + "Naozaj chceš túto položku kúpiť?", "Potvrdenie akcie", JOptionPane.YES_NO_OPTION);
                if (n1 == 0) {
                    this.getHrac().getInventar().add(predmet);
                    this.getHrac().odpocitajPeniaze(predmet.dajCenu());
                    this.zobrazNovyStavHraca();
                }
            }
            this.dajZoznamTovaruVObchode(nakupovanie);
        }
        JOptionPane.showMessageDialog(null, "Prosím zvoľ id tovaru, ktorý je v zozname. \nID nájdeš na konci riadku pri každom tovare!");
        this.dajZoznamTovaruVObchode(nakupovanie);
    }


    public void dajMiestnostiBudovy() {
        //vráti zoznam miestnosti v budove a čaká aby hráč vybral kam chce vstúpiť

        int kolkoMiestnostiMinus = 0;

        Miestnost[] zoznamMiestnosti = this.getHrac().getAktualnaBudova().getZoznamMiestnosti();
        int vyberInt = 999;
        String zoznam = "";

        // kontrola ci su k dispozicii nejake miestnosti, ak nie tak to oznami a vrati do predoslej metody
        if (zoznamMiestnosti.length == 0) {
            JOptionPane.showMessageDialog(null, "Žiadne Miestnosti sa tu nenechádzajú.");
            this.zapniHru();
        }
        for (int i = 0; i < zoznamMiestnosti.length; i++) {
            if (!zoznamMiestnosti[i].getNazovMiestnosti().equals("Väzenie")) {
                zoznam += this.getHrac().getAktualnaBudova().getZoznamMiestnosti()[i].getNazovMiestnosti() + " - " + (i + 1) + "\n";
            } else {
                kolkoMiestnostiMinus++;
            }
        }
        zoznam += "Zatvoriť zoznam miestnosti - 0";
        while (true) {
            this.cas.posunCas( 0, 1, 0, 0, 0);
            this.nastavCas();
            String vyber = JOptionPane.showInputDialog(null, zoznam);
            if (this.kontrolaCiJeToCislo(vyber)) {
                vyberInt = Integer.parseInt(vyber);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Musíš zadať číslo!");
                continue;
            }

        }
        if (vyberInt == 0) {
            return;
        }
        for (int i = 0; i < zoznamMiestnosti.length - kolkoMiestnostiMinus; i++) {
            if ((vyberInt - 1) == i) {
                this.getHrac().setAktualnaMiestnost(zoznamMiestnosti[i]);
                this.cas.posunCas(0, 2, 0, 0, 0);
                this.nastavCas();
                this.zmenBudovuMiestnost(this.getHrac().getAktualnaBudova(), zoznamMiestnosti[i]);
                this.dajZoznamAktivit();
                return;
            }
        }
        System.out.println(vyberInt);
        JOptionPane.showMessageDialog(null, "Prosím zvoľ id miestnosti zo zoznamu!");
        this.dajMiestnostiBudovy();
    }





    public Hrac getHrac() {
        return this.hrac;
    }

    public void zobrazNovyStavHraca() {
        //metoda zabezpečuje zobrazenie nového stavu hráča (zdravie, hlad...)
        System.out.println(this.getHrac().getStavHraca().getZdravie().getMnozstvo());
        this.screen.vypisStavHraca(this.getHrac().getStavHraca().getZdravie().getMnozstvo(), this.getHrac().getStavHraca().getEnergia().getMnozstvo(),
                this.getHrac().getStavHraca().getHlad().getMnozstvo(), this.getHrac().getStavHraca().getSmad().getMnozstvo(), this.getHrac().getPeniaze());
    }

    public void nastavCas() {
        //metoda nastaví aktuálny čas a zobrazí ho
        String aktualnyCas = "";

        int hodiny = this.cas.getHodiny();
        if (hodiny < 10) {
            aktualnyCas += "0";
        }

        aktualnyCas += hodiny + ":";
        int minuty = this.cas.getMinuty();
        if (minuty < 10) {
            aktualnyCas += "0";
        }

        aktualnyCas += minuty + "   ";
        int den = this.cas.getDen();
        if (den < 10) {
            aktualnyCas += "0";
        }

        aktualnyCas += den + ".";
        int mesiac = this.cas.getMesiac();
        if (mesiac < 10) {
            aktualnyCas += "0";
        }
        aktualnyCas += mesiac + ".";

        int rok = this.cas.getRok();
        if (rok < 10) {
            aktualnyCas += "0";
        }
        aktualnyCas += rok;

        this.screen.nastavCas(aktualnyCas);
    }

    public void zmenBudovuMiestnost(Budova budova, Miestnost miestnost) {
        //zmeni budovu kde sa hráč nachádzať na okne
        String nazovBudovy = budova.getNazovBudovy();
        String nazovMiestnosti = miestnost.getNazovMiestnosti();

        this.screen.napisPolohu(nazovBudovy, nazovMiestnosti);
    }


    public boolean kontrolaCiJeToCislo(String strNum) {
        //pomocna metoda pre kontrolu vstupov či hráč zadal číslo
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public void overCiNemaKlesnutZdravie(int mnozstvo) {
        //Metoda overuje či nemá klesnúť zdravie
        if (mnozstvo < 0) {
            mnozstvo *= -1;
            this.getHrac().getStavHraca().getZdravie().odober(mnozstvo);
        }
        if (mnozstvo > 100) {
            this.getHrac().getStavHraca().getZdravie().odober(mnozstvo - 100);
        }
        this.zobrazNovyStavHraca();
        return;
    }
}
