package de.kania.nn;

import java.util.Arrays;
import java.util.LinkedList;

public class Start {
    public static void main(String[] args) {

        NeuronalesNetz netz = new NeuronalesNetz(2);

        LinkedList<Integer> werte1 = new LinkedList<>(Arrays.asList(0,0));
        LinkedList<Integer> werte2 = new LinkedList<>(Arrays.asList(0,1));
        LinkedList<Integer> werte3 = new LinkedList<>(Arrays.asList(1,0));
        LinkedList<Integer> werte4 = new LinkedList<>(Arrays.asList(1,1));

        //OHNE TRAINIEREN
        System.out.println("AUSWERTEN OHNE TRAINING");
        netz.setzeEingaenge(werte1);
        netz.getWerte().forEach(e -> System.out.println("0 | 0: " + e));
        netz.setzeEingaenge(werte2);
        netz.getWerte().forEach(e -> System.out.println("0 | 1: " + e));
        netz.setzeEingaenge(werte3);
        netz.getWerte().forEach(e -> System.out.println("1 | 0: " + e));
        netz.setzeEingaenge(werte4);
        netz.getWerte().forEach(e -> System.out.println("1 | 1: " + e));


        //MIT TRAINIEREN
        for (int i = 0; i < 1000000; i++) {
            netz.setzeEingaenge(werte1);
            netz.trainiereNeuronenAnhandGuterWerte(new LinkedList<>(Arrays.asList(1.0, 0.0)));
        }

        for (int i = 0; i < 1000000; i++) {
            netz.setzeEingaenge(werte2);
            netz.trainiereNeuronenAnhandGuterWerte(new LinkedList<>(Arrays.asList(0.0, 0.0)));
        }

        for (int i = 0; i < 1000000; i++) {
            netz.setzeEingaenge(werte3);
            netz.trainiereNeuronenAnhandGuterWerte(new LinkedList<>(Arrays.asList(0.0, 0.0)));
        }
        for (int i = 0; i < 1000000; i++) {
            netz.setzeEingaenge(werte4);
            netz.trainiereNeuronenAnhandGuterWerte(new LinkedList<>(Arrays.asList(0.0, 0.0)));
        }

        //AUSWERTEN NACH 4 TRAININGSRUNDEN
        System.out.println("AUSWERTEN NACH 10 TRAININGSRUNDEN");
        netz.setzeEingaenge(werte1);
        netz.getWerte().forEach(e -> System.out.println("0 | 0: " + e));
        netz.setzeEingaenge(werte1);
        netz.getWerte().forEach(e -> System.out.println("0 | 0: " + e));
        netz.setzeEingaenge(werte2);
        netz.getWerte().forEach(e -> System.out.println("0 | 1: " + e));
        netz.setzeEingaenge(werte3);
        netz.getWerte().forEach(e -> System.out.println("1 | 0: " + e));
        netz.setzeEingaenge(werte4);
        netz.getWerte().forEach(e -> System.out.println("1 | 1: " + e));

    }
}
