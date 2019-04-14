package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Jaką funkcję aproksymujemy?");
        String funkcja = s.next();
        Funkcja efodiks = new Funkcja(funkcja);
        System.out.println("Na jakim przedziale, proszę podać w formie początek:koniec");
        String przedzial = s.next();
        String[] tab = przedzial.split(":",2);
        double poczatek = Double.parseDouble(tab[0]);
        double koniec = Double.parseDouble(tab[1]);
        System.out.println("Wielomianem którego stopnia?");
        int stopien = s.nextInt();

        MacierzM macierzM = new MacierzM(koniec,poczatek,stopien+1);
        macierzM.test();
        WektorF wektorF = new WektorF(efodiks,stopien+1,koniec,poczatek);
        wektorF.test();
        UkladRownan ukladRownan = new UkladRownan(macierzM,wektorF);
        double[] wspolczynniki = ukladRownan.oblicz();

        for (int i = wspolczynniki.length - 1; i >= 0; i--) {
            System.out.print(wspolczynniki[i]+"*x^"+i+" + ");
        }
    }
}
