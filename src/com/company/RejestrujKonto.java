package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/********************************************************
 * nazwa klasy: RejestrujKonto
 * parametry wejściowe: brak
 * wartość zwracana: brak
 * opis: kalsa do obsługi rejestracji konta
 * autor: 78901234567
 * ****************************************************/
public class RejestrujKonto {

    /********************************************************
     * nazwa funkcji: main
     * parametry wejściowe: args - tablica parametrów uruchomieniowych
     * wartość zwracana: brak
     * opis: główna metoda uruchomieniowa
     * autor: 78901234567
     * ****************************************************/
    public static void main(String[] args) {
        JFrame okno = new JFrame("Rejestruj konto");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(300, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));

        //definiuję margines
        EmptyBorder granica = new EmptyBorder(0, 10, 0, 0);

        //Tytuł
        JLabel lblTytul = new JLabel("Rejestruj konto");
        Font czcionka = new Font("TimesRoman", Font.BOLD, 30);
        lblTytul.setForeground(Color.WHITE);
        lblTytul.setFont(czcionka);
        lblTytul.setBackground(Color.GREEN);
        lblTytul.setBorder(granica);
        lblTytul.setOpaque(true);

        //definiuję font dla etykiet
        Font lblFont = new Font("Arial", Font.PLAIN, 20);
        //definiujemy font dla pól tekstowych
        Font txtFont = new Font("Arial", Font.ITALIC, 20 );
        //definiuję font dla komunikatu
        Font komunikatFont = new Font("Arial", Font.PLAIN, 14);

        //Podaj email
        JLabel lblEmail = new JLabel("Podaj e-mail:");
        lblEmail.setFont(lblFont);
        lblEmail.setBorder(granica);
        lblEmail.setOpaque(true);

        //email
        JTextField txtEmail = new JTextField("email");
        txtEmail.setFont(txtFont);
        txtEmail.setBorder(granica);
        txtEmail.setOpaque(true);

        //podaj hasło
        JLabel lblPodajHaslo = new JLabel("Podaj hasło:");
        lblPodajHaslo.setFont(lblFont);
        lblPodajHaslo.setBorder(granica);
        lblPodajHaslo.setOpaque(true);

        //hasło
        JPasswordField txtHaslo = new JPasswordField("");
        txtHaslo.setEchoChar('*');
        txtHaslo.setFont(txtFont);
        txtHaslo.setBorder(granica);
        txtHaslo.setOpaque(true);

        //powtorz hasło
        JLabel lblPowtorzHaslo = new JLabel("Powtórz hasło:");
        lblPowtorzHaslo.setFont(lblFont);
        lblPowtorzHaslo.setBorder(granica);
        lblPowtorzHaslo.setOpaque(true);

        //hasło powtórzone
        JPasswordField txtHasloPowtorzone = new JPasswordField("");
        txtHasloPowtorzone.setEchoChar('*');
        txtHasloPowtorzone.setFont(txtFont);
        txtHasloPowtorzone.setBorder(granica);
        txtHasloPowtorzone.setOpaque(true);

        //panel przycisku, w którym umieścimy przycisk
        JPanel panelPrzycisku = new JPanel();
        //zatwierdź
        JButton btnZatwierdz = new JButton("ZATWIERDŹ");
        btnZatwierdz.setFont(txtFont);
        btnZatwierdz.setSize(150, 30);
        btnZatwierdz.setOpaque(true);
        //do panelu rzycisku dodajemy przycisk
        panelPrzycisku.add(btnZatwierdz);

        //panel komunikatu
        JPanel panelKomunikatu = new JPanel();
        //komunikat
        JLabel lblKomunikat = new JLabel("Tu pojawi się wynik");
        lblKomunikat.setFont(komunikatFont);
        lblKomunikat.setOpaque(true);
        panelKomunikatu.add(lblKomunikat);

        /********************************************************
         * nazwa funkcji: brak
         * parametry wejściowe: e - obsługiwane zdarzenie
         * wartość zwracana: brak
         * opis: anonimowa metoda obsługująca naciśnięcie przycisku Zatwierdź
         * autor: 78901234567
         * ****************************************************/
        btnZatwierdz.addActionListener(e -> {
            String polecenie = e.getActionCommand();
            String komunikatStr = "";
            String emailStr = txtEmail.getText();
            if(emailStr.indexOf("@")<0){
                komunikatStr += "Nieprawidłowy adres e-mail.\n";
            };
            String hasloStr = txtHaslo.getText();
            String hasloPowtorzoneStr = txtHasloPowtorzone.getText();
            if(!hasloStr.equals(hasloPowtorzoneStr)){
                komunikatStr += "Hasła się różnią.\n";
            }
            if (komunikatStr.length()==0){
                komunikatStr = "Witaj " + emailStr;
            }
            lblKomunikat.setText(komunikatStr);
        });

        panel.add(lblTytul);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPodajHaslo);
        panel.add(txtHaslo);
        panel.add(lblPowtorzHaslo);
        panel.add(txtHasloPowtorzone);
        panel.add(panelPrzycisku);
        panel.add(panelKomunikatu);

        okno.add(panel);
        okno.setVisible(true);
    }
}
