package de.kania.nn;

import java.util.LinkedList;

public class Neuron {

  private static final int BIAS = 1;
  private static final double LERNRATE = 0.1;

  private LinkedList<Integer> eingaenge;
  private LinkedList<Double> gewichte;
  private double biasGewicht;
  private double wert;

  public Neuron(){
      this.eingaenge = new LinkedList<Integer>();
      this.gewichte = new LinkedList<Double>();
      this.biasGewicht = Math.random();
  }


    public void setEingaenge(LinkedList<Integer> eingaenge) {
      if(this.gewichte.size() == 0){ //Damit vorhandene gewichte nicht ueberschrieben werden
          this.eingaenge = new LinkedList<Integer>(eingaenge);
          generiereZufallsGewichteFuerEingaenge();
      }
      this.eingaenge = new LinkedList<Integer>(eingaenge);
    }

    private void generiereZufallsGewichteFuerEingaenge() {
        eingaenge.forEach(e -> gewichte.add(Math.random()));
    }


    public void berechneWert(){
      double summe = 0;
        for (int i = 0; i < eingaenge.size(); i++) {
            summe += eingaenge.get(i) * gewichte.get(i); //Eingangswert * Gewicht
        }
        summe += BIAS * biasGewicht; //Bias noch draufrechnen
        wert = berechneSigmoid(summe);
    }

    public double getWert() {
        berechneWert();
        return wert;
    }

    public void berechneGewichteNeu(double delta){
        for (int i = 0; i < eingaenge.size(); i++) {
            double d = gewichte.get(i);
            d+= LERNRATE * delta * eingaenge.get(i);
            gewichte.set(i, d);
        }
        biasGewicht += LERNRATE * delta * BIAS;
    }

    /**
     * Aktivierungsfunktion SIGMOID
     */
    public static double berechneSigmoid(Double summe) {
        return (1 / (1 + Math.exp(-summe))); //Sehr kleiner Wert = 0 | Sehr großer Wert 1
    }



}
