package com.company;

public class MacierzM {
    final double[][] macierz;

    public MacierzM(double v,double u,int n) {
        macierz = new double[n][n];
        double[] vdoi = new double[2*n-1];
        double[] udoi = new double[2*n-1];

        //w komórce 0 przechowuję wartość v^1 itd.
        vdoi[0] = v;
        udoi[0] = u;
        for (int i = 1; i < vdoi.length; i++) {
            vdoi[i] = vdoi[i-1]*v;
            udoi[i] = udoi[i-1]*u;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {                               //macierz symetryczna względem przekątnej
                macierz[i][j] = (vdoi[i+j] - udoi[i+j]) / (i+j+1);      //w vdoi[i+j] jest v^(i+j+1)
                if (i != j) macierz[j][i] = macierz[i][j];
            }
        }
    }

    public void test() {                                    //test udany
        System.out.println("Macierz M");
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz.length; j++) {
                System.out.print(macierz[i][j]+"      ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
