package com.company;

public class WektorF {
    double[] f;

    public WektorF(Funkcja efodiks, int n, double v, double u) {
        f = new double[n];
        WekWarFun efrazyxdoi = new WekWarFun(u,0.0001,v,efodiks);    //tutaj można wpłynąć na dokładność całki
        f[0] = efrazyxdoi.calkaParab();                             //całka z f(x)

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < efrazyxdoi.x.length; j++) efrazyxdoi.y[j] *= efrazyxdoi.x[j];
            f[i] = efrazyxdoi.calkaParab();
        }
    }

    public void test() {                        //test udany
        System.out.println("Wektor F");
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] +"     ");
        }
        System.out.println();
    }
}
