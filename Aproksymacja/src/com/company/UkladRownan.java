package com.company;

public class UkladRownan {
    MacierzM wspolczynniki;
    WektorF wartosc;

    UkladRownan(MacierzM m, WektorF wartosc) {
        if (m.macierz[0].length == wartosc.f.length) {
            wspolczynniki = m;
            this.wartosc = wartosc;
        }
    }

    public double[] oblicz() {
        double[] a = new double[wartosc.f.length];
        double wyzGlowny = wyznacznik(wspolczynniki.macierz);

        for (int i = 0; i < a.length; i++) {
            a[i] = wyzZas(i) / wyzGlowny;
        }
        return a;
    }

    private double wyznacznik(double[][] macierz) {
        double wynik = 0;
        int stopien = macierz[0].length;

        switch (stopien) {
            case 1:
                wynik += macierz[0][0];
                break;
            case 2:
                wynik += macierz[0][0] * macierz[1][1] - macierz[0][1] * macierz[1][0];
                break;
            case 3:
                wynik += macierz[0][0] * macierz[1][1] * macierz[2][2] + macierz[1][0] * macierz[2][1] * macierz[0][2]
                        + macierz[2][0] * macierz[0][1] * macierz[1][2] - macierz[0][2] * macierz[1][1] * macierz[2][0]
                        - macierz[1][2] * macierz[2][1] * macierz[0][0] - macierz[2][2] * macierz[0][1] * macierz[1][0];
                break;
            default:
                for (int i = 0; i < stopien; i++) {
                    if (i % 2 == 0) {
                        wynik += macierz[0][i] * wyznacznik(pod(macierz,i));
                    } else {
                        wynik -= macierz[0][i] * wyznacznik(pod(macierz,i));
                    }
                }
                break;
        }
        return wynik;
    }

    private double[][] pod(double[][] macierz,int n) {
        int stopien = macierz[0].length;
        double[][] podmacierz = new double[stopien-1][stopien-1];

        for (int i = 1; i < stopien; i++) {
            for (int j = 0; j < stopien; j++) {
                if (j != n) {
                    if (j < n) {
                        podmacierz[i-1][j] = macierz[i][j]; //po lewej zostaną przessunięte o 1 w górę
                    } else {
                        podmacierz[i-1][j-1] = macierz[i][j];    //pozostałe po skosie
                    }
                }
            }
        }
        return podmacierz;
    }

    private double wyzZas(int n) {  //wyznacznik w którym współczynniki w kolumnie n zostały zastąpione wyrazami wolnymi
        double[][] zastepcza = new double[wartosc.f.length][wartosc.f.length];
        for (int i = 0; i < zastepcza.length; i++) {
            for (int j = 0; j < zastepcza.length; j++) {
                if (j == n) {
                    zastepcza[i][j] = wartosc.f[i];
                } else zastepcza[i][j] = wspolczynniki.macierz[i][j];
            }
        }
        //test podstawiania
        System.out.println("Macierz zastępcza nr "+n);
        for (int i = 0; i < zastepcza.length; i++) {
            for (int j = 0; j < zastepcza.length; j++) {
                System.out.print(zastepcza[i][j]+"      ");
            }
            System.out.println();
        }
        System.out.println();
        //koniec testu
        return wyznacznik(zastepcza);
    }
}
