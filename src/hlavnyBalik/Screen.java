package hlavnyBalik;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;
import java.io.File;

/**
 * 29. 3. 2021 - 20:45
 *
 * @author Tomas Staron
 *
 * Trieda vytvorí Okno na ktorom budem zobrazovať hráčovi všetky informácie
 */
public class Screen {
    private static JFrame frame;
    private static JLabel zivot;
    private static JLabel energia;
    private static JLabel hlad;
    private static JLabel smad;
    private static JLabel peniaze;
    private static JLabel budova;
    private static JLabel miestnost;
    private static JLabel cas;
    private static JLabel obrazok;

    public Screen() {

        // V konštruktore si postupne vytvorím všetky komponenty okna, ktoré chcem aby boli zobrazene
        // upravujú sa nižšie v samostatných metodach

        frame = new JFrame();
        frame.setTitle("LifeSimulation");
        frame.setSize(1280, 720);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(60, 66, 74));

        //Ak by som chcel aby sa okno zobrazilo priamo na stred obrazovky
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setLayout(null);


        //NADPIS HRY
        JLabel label = new JLabel("L i f e   S i m u l a t i o n");
        label.setFont(new Font("MONOSPACED", Font.BOLD, 35));
        label.setForeground(Color.ORANGE);
        Dimension size = label.getPreferredSize();
        label.setForeground(Color.white);
        frame.add(label);
        label.setBounds(260, 25, size.width, size.height);


        // stav hraca
        label = new JLabel("Stav hráča");
        size = label.getPreferredSize();
        label.setForeground(Color.white);
        frame.add(label);

        label.setBounds(1115, 27, size.width, size.height);


        // Zobrazenie textu: zivot
        label = new JLabel("Život");
        label.setBounds(1055, 57, size.width, size.height);
        label.setForeground(Color.white);
        frame.add(label);

        // zobrezenie množstva Života hráča
        zivot = new JLabel("100");
        zivot.setBounds(1150, 57, size.width, size.height);
        zivot.setForeground(Color.green);
        frame.add(zivot);

        // Zobrazenie textu: Energia
        label = new JLabel("Energia");
        label.setBounds(1055, 77, size.width, size.height);
        label.setForeground(Color.white);
        frame.add(label);

        // zobrezenie množstva Energie hráča
        energia = new JLabel("100");
        energia.setBounds(1150, 77, size.width, size.height);
        energia.setForeground(Color.green);
        frame.add(energia);


        // Zobrazenie textu: Hlad
        label = new JLabel("Hlad");
        label.setBounds(1055, 97, size.width, size.height);
        label.setForeground(Color.white);
        frame.add(label);

        // zobrezenie množstva Hladu hráča
        hlad = new JLabel("15");
        hlad.setBounds(1150, 97, size.width, size.height);
        hlad.setForeground(Color.green);
        frame.add(hlad);


        // Zobrazenie textu: Smäd
        label = new JLabel("Smäd");
        label.setBounds(1055, 117, size.width, size.height);
        label.setForeground(Color.white);
        frame.add(label);

        // zobrezenie množstva Smädu hráča
        smad = new JLabel("15");
        smad.setBounds(1150, 117, size.width, size.height);
        smad.setForeground(Color.green);
        frame.add(smad);

        // Zobrazenie textu: Peniaze
        label = new JLabel("Peniaze");
        label.setBounds(1055, 137, size.width, size.height);
        label.setForeground(Color.white);
        frame.add(label);

        // zobrazenie mnozstva Penazi hraca
        peniaze = new JLabel("100.0");
        peniaze.setBounds(1150, 137, size.width, size.height);
        peniaze.setForeground(Color.white);
        frame.add(peniaze);

        // Zobrazenie textu: Domov
        budova = new JLabel("Budova: Domov");
        size = budova.getPreferredSize();
        budova.setBounds(1055, 187, size.width, size.height);
        budova.setForeground(Color.white);
        frame.add(budova);

        // Zobrazenie textu: Miestnost
        miestnost = new JLabel("Miestnost: vstupna chodba");
        size = miestnost.getPreferredSize();
        miestnost.setBounds(1055, 207, size.width, size.height);
        miestnost.setForeground(Color.white);
        frame.add(miestnost);

        cas = new JLabel("");
        size = cas.getPreferredSize();
        cas.setBounds(1055, 217, size.width, size.height);
        cas.setForeground(Color.white);
        frame.add(cas);


        // Zobrezenie malého obrázku mesta
        obrazok = new JLabel(new ImageIcon("D:\\UNIZA FRI\\2. semester\\Informatika 2\\Semestralna_Praca\\LifeSimulation\\src\\IMG\\city.jpg"));
        size = obrazok.getPreferredSize();
        obrazok.setBounds(1070, 330, size.width, size.height);
        frame.add(obrazok);


        // Gif do pozadia hry, ktorý bude stále zobrazený
        obrazok = new JLabel(new ImageIcon("D:\\UNIZA FRI\\2. semester\\Informatika 2\\Semestralna_Praca\\LifeSimulation\\src\\IMG\\bg_Gif.gif"));
        size = obrazok.getPreferredSize();
        obrazok.setBounds(-280, 0, 1300, 680);
        frame.add(obrazok);

        frame.setVisible(true);

        // metoda, ktorá spustí hudbu
        playMusic("D:\\UNIZA FRI\\2. semester\\Informatika 2\\Semestralna_Praca\\LifeSimulation\\src\\Sounds\\PayDay_BG.wav");
    }


    public void vypisStavHraca(int paZivot, int paEnergia, int paHlad, int paSmad, double paPeniaze) {
        // V tejto metóde vypíšem stavHraca na

        // Zmena Zivota
        frame.remove(zivot);
        zivot = new JLabel(String.valueOf(paZivot));
        Dimension size = zivot.getPreferredSize();
        zivot.setBounds(1150, 57, size.width, size.height);
        zivot.setForeground(Color.white);
        frame.add(zivot);

        if (paZivot > 75) {
            zivot.setForeground(Color.green);
        } else if (paZivot > 40) {
            zivot.setForeground(Color.orange);
        } else {
            zivot.setForeground(Color.red);
        }




        // Zmena energie


        frame.remove(energia);
        energia = new JLabel(String.valueOf(paEnergia));
        size = energia.getPreferredSize();
        energia.setBounds(1150, 77, size.width, size.height);
        if (paEnergia > 75) {
            energia.setForeground(Color.green);
        } else if (paEnergia > 40) {
            energia.setForeground(Color.orange);
        } else {
            energia.setForeground(Color.red);
        }
        frame.add(energia);



        //zmena Hladu

        frame.remove(hlad);
        hlad = new JLabel(String.valueOf(paHlad));
        size = hlad.getPreferredSize();
        hlad.setBounds(1150, 97, size.width, size.height);
        if (paHlad < 25) {
            hlad.setForeground(Color.green);
        } else if (paHlad < 60) {
            hlad.setForeground(Color.orange);
        } else {
            hlad.setForeground(Color.red);
        }
        frame.add(hlad);









        //zmena Smadu

        frame.remove(smad);
        smad = new JLabel(String.valueOf(paSmad));
        size = smad.getPreferredSize();
        smad.setBounds(1150, 117, size.width, size.height);
        if (paSmad < 25) {
            smad.setForeground(Color.green);
        } else if (paSmad < 60) {
            smad.setForeground(Color.orange);
        } else {
            smad.setForeground(Color.red);
        }
        frame.add(smad);








        //zmena Penazi

        frame.remove(peniaze);
        peniaze = new JLabel(String.valueOf(paPeniaze));
        size = peniaze.getPreferredSize();
        peniaze.setBounds(1150, 137, size.width, size.height);
        peniaze.setForeground(Color.white);
        frame.add(peniaze);


        // refresh Frame-u
        frame.setVisible(false);
        frame.setVisible(true);
    }

    public void napisPolohu(String paPoloha, String paMiestnost) {

        frame.remove(budova);
        budova = new JLabel("Budova: " + paPoloha);
        Dimension size = budova.getPreferredSize();
        budova.setBounds(1055, 187, size.width, size.height);
        budova.setForeground(Color.white);
        frame.add(budova);


        frame.remove(miestnost);
        miestnost = new JLabel("Miestnost: " + paMiestnost);
        size = miestnost.getPreferredSize();
        miestnost.setBounds(1055, 207, size.width, size.height);
        miestnost.setForeground(Color.white);
        frame.add(miestnost);

        frame.setVisible(false);
        frame.setVisible(true);
    }

    public void nastavCas(String paCas) {
        //Metoda nastaví zobrazenie aktuálneho času v hre
        frame.remove(cas);
        cas = new JLabel("Dátum a čas:    " + paCas);
        Dimension size = cas.getPreferredSize();
        cas.setBounds(1065, 660, size.width, size.height);
        cas.setForeground(Color.white);
        frame.add(cas);

        frame.setVisible(false);
        frame.setVisible(true);
    }

    public static void playMusic(String cesta) {
        // Tato metoda spustí hudbu do pozadia hry

        try {
            File music = new File(cesta);

            if (music.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Nemôžem nájsť subor");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
