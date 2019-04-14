package com.company;

public class WekWarFun {
    double[] x;
    double[] y;
    double krok;
    Funkcja efodiks;

    public WekWarFun(String przedzial, Funkcja efodiks) {
        this.efodiks = efodiks;
        String[] tab = przedzial.split(":",3);
        double poczatek = Double.parseDouble(tab[0]);
        krok = Double.parseDouble(tab[1]);
        double koniec = Double.parseDouble(tab[2]);

        int dlugosc = (int) (((koniec - poczatek) / krok) + 1);
        x = new double[dlugosc];
        y = new double[dlugosc];

        for (int i = 0; i < dlugosc; i++) {
            x[i] = poczatek;
            y[i] = efodiks.oblicz(x[i]);
            poczatek += krok;
        }
    }

    public WekWarFun(double poczatek, double krok, double koniec, Funkcja efodiks) {
        this.efodiks = efodiks;
        this.krok = krok;

        int dlugosc = (int) (((koniec - poczatek) / krok) + 1);
        x = new double[dlugosc];
        y = new double[dlugosc];

        for (int i = 0; i < dlugosc; i++) {
            x[i] = poczatek;
            y[i] = efodiks.oblicz(x[i]);
            poczatek += krok;
        }
    }

    public double calkaProst() {
        double calka = 0;
        for (int i = 1; i < y.length; i++) {
            calka += y[i];
        }
        calka *= krok;
        return calka;
    }

    public double calkaTrap() {
        double calka = 0;
        for (int i = 1; i < y.length; i++) {
            calka += (y[i-1] + y[i]);
        }
        calka *= (krok/2);
        return calka;
    }

    public double calkaParab() {
        double calka = 0;
        for (int i = 2; i < y.length; i+=2) {
            calka += (y[i-2] + 4 * y[i-1] + y[i]);
        }
        calka *= (krok/3);
        return calka;
    }

}
