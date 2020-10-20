package com.impulseisp.gtwautomaespecializado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class Mazo {
    private Carta[] cartas;
    public boolean expansionActivada = false;

    Mazo() {
        Carta carta01 = new Carta(R.drawable.card_01_h192, R.string.hCard_01, 1, true);
        Carta carta02 = new Carta(R.drawable.card_02_h192, R.string.hCard_02, 2);
        Carta carta03 = new Carta(R.drawable.card_03_h192, R.string.hCard_03, 3);
        Carta carta04 = new Carta(R.drawable.card_04_h192, R.string.hCard_04, 4);
        Carta carta05 = new Carta(R.drawable.card_05_h192, R.string.hCard_05, 5);
        Carta carta06 = new Carta(R.drawable.card_06_h192, R.string.hCard_06, 6, true);
        Carta carta07 = new Carta(R.drawable.card_07_h192, R.string.hCard_07, 7);
        Carta carta08 = new Carta(R.drawable.card_08_h192, R.string.hCard_08, 8);
        Carta carta09 = new Carta(R.drawable.card_09_h192, R.string.hCard_09, 9);
        Carta carta10 = new Carta(R.drawable.card_10_h192, R.string.hCard_10, 10);
        Carta carta11 = new Carta(R.drawable.card_11_h192, R.string.hCard_11, 11, false,true);
        Carta carta12 = new Carta(R.drawable.card_12_h192, R.string.hCard_12, 12);
        Carta carta13 = new Carta(R.drawable.card_13_h192, R.string.hCard_13, 13);
        Carta carta14 = new Carta(R.drawable.card_14_h192, R.string.hCard_14, 14);
        Carta carta15 = new Carta(R.drawable.card_15_h192, R.string.hCard_15, 15);
        cartas = new Carta[0];
        List<Carta> list = new ArrayList<Carta>(Arrays.asList(cartas));
        list.add(carta01);
        list.add(carta02);
        list.add(carta03);
        list.add(carta04);
        list.add(carta05);
        list.add(carta06);
        list.add(carta07);
        list.add(carta08);
        list.add(carta09);
        list.add(carta10);
        list.add(carta11);
        list.add(carta12);
        list.add(carta13);
        list.add(carta14);
        list.add(carta15);
        cartas = list.toArray(cartas);
    }

    Mazo(boolean expAct) {
        expansionActivada = expAct;
        if (expansionActivada == true) {
            Carta carta01 = new Carta(R.drawable.card_01_h192, R.string.hCard_01, 1, true);
            Carta carta02 = new Carta(R.drawable.card_02_h192, R.string.hCard_02_exp, 2, false);
            Carta carta03 = new Carta(R.drawable.card_03_h192, R.string.hCard_03_exp, 3);
            Carta carta04 = new Carta(R.drawable.card_04_h192, R.string.hCard_04, 4);
            Carta carta05 = new Carta(R.drawable.card_05_h192, R.string.hCard_05, 5);
            Carta carta06 = new Carta(R.drawable.card_06_h192, R.string.hCard_06, 6, true);
            Carta carta07 = new Carta(R.drawable.card_07_h192, R.string.hCard_07_exp, 7);
            Carta carta08 = new Carta(R.drawable.card_08_h192, R.string.hCard_08, 8);
            Carta carta09 = new Carta(R.drawable.card_09_h192, R.string.hCard_09_exp, 9);
            Carta carta10 = new Carta(R.drawable.card_10_h192, R.string.hCard_10, 10);
            Carta carta11 = new Carta(R.drawable.card_11_h192, R.string.hCard_11, 11, false,true);
            Carta carta12 = new Carta(R.drawable.card_12_h192, R.string.hCard_12, 12);
            Carta carta13 = new Carta(R.drawable.card_13_h192, R.string.hCard_13, 13);
            Carta carta14 = new Carta(R.drawable.card_14_h192, R.string.hCard_14, 14);
            Carta carta15 = new Carta(R.drawable.card_15_h192, R.string.hCard_15, 15);
            cartas = new Carta[0];
            List<Carta> list = new ArrayList<Carta>(Arrays.asList(cartas));
            list.add(carta01);
            list.add(carta02);
            list.add(carta03);
            list.add(carta04);
            list.add(carta05);
            list.add(carta06);
            list.add(carta07);
            list.add(carta08);
            list.add(carta09);
            list.add(carta10);
            list.add(carta11);
            list.add(carta12);
            list.add(carta13);
            list.add(carta14);
            list.add(carta15);
            cartas = list.toArray(cartas);
        } else {
            cartas = new Mazo().cartas;
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public Carta robaUnaCarta() {
        if (cartas.length > 0) {
            Random rand = new Random();
            int n = rand.nextInt(cartas.length);
            Carta cartaSeleccionada = cartas[n];
            descartaCarta(n);
            return cartaSeleccionada;
        } else {
            resetearMazo();
            return robaUnaCarta();
        }
    }

    private void resetearMazo() {
        cartas = new Mazo(expansionActivada).cartas;
    }

    private void descartaCarta(int posArray) {
        List<Carta> list = new ArrayList<Carta>(Arrays.asList(cartas));
        list.remove(posArray);

        cartas = list.toArray(new Carta[list.size()]);
    }

    public int getCartasRestantes() { return cartas.length; }

}
