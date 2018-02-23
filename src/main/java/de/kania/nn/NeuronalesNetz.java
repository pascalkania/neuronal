package de.kania.nn;

import java.util.LinkedList;
import java.util.List;

public class NeuronalesNetz {

    private List<Neuron> neuronList;


    public NeuronalesNetz(int input) {
        this.neuronList = new LinkedList<Neuron>();

        for (int i = 0; i < input; i++) {
            neuronList.add(new Neuron());
        }
    }

    public void setzeEingaenge(LinkedList<Integer> eingaenge){
        for (Neuron neuron : neuronList) {
            neuron.setEingaenge(eingaenge);
        }
    }

    public LinkedList<Double> getWerte(){
        LinkedList<Double> werte = new LinkedList<>();
        for (Neuron neuron : neuronList) {
            werte.add(neuron.getWert());
        }
        return werte;
    }

    public void trainiereNeuronenAnhandGuterWerte(LinkedList<Double> guteWerte){
        for (int i = 0; i < neuronList.size(); i++) {
            double delta = guteWerte.get(i) - neuronList.get(i).getWert();
            neuronList.get(i).berechneGewichteNeu(delta);
        }
    }

}
