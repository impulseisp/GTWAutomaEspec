package com.impulseisp.gtwautomaespecializado;

import android.graphics.drawable.Drawable;

public class Carta {
    private int accion;
    private int ayuda;
    private int numero;
    private boolean otorgaTrabajador;
    private boolean soloIngeniero;

    Carta() {
        accion = 0;
        ayuda = 0;
        numero = 0;
        otorgaTrabajador = false;
        soloIngeniero = false;
    }

    public Carta(int acc, int ay, int num) {
        accion = acc;
        ayuda = ay;
        numero = num;
        otorgaTrabajador = false;
        soloIngeniero = false;
    }

    public Carta(int acc, int ay, int num, boolean trab) {
        accion = acc;
        ayuda = ay;
        numero = num;
        otorgaTrabajador = trab;
        soloIngeniero = false;
    }

    public Carta(int acc, int ay, int num, boolean trab, boolean soloIng) {
        accion = acc;
        ayuda = ay;
        numero = num;
        otorgaTrabajador = trab;
        soloIngeniero = soloIng;
    }

    public int getAccion() {
        return accion;
    }

    public int getTextoAyuda() {
        return ayuda;
    }

    public boolean getOtorgaTrabajador() {
        return otorgaTrabajador;
    }

    public boolean getSoloIngeniero() {
        return soloIngeniero;
    }

    // TODO expansion
}
