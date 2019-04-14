package com.company;
import org.mariuszgromada.math.mxparser.*;

public class Funkcja {

    private final String funkcja;

    public Funkcja(String funkcja) {
        this.funkcja = funkcja;
        }

    public double oblicz(double arg) {
        Argument x = new Argument("x",arg);
        Expression e = new Expression(funkcja,x);
        return e.calculate();
        }

    /*public double oblicz(double arg) {
        double y = arg * arg + 1;
        return y;
    }*/

}
