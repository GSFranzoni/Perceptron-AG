
package Perceptron;

import java.util.ArrayList;

public class Neuron {
    
    public static Double sigma(ArrayList<Double> inputs, ArrayList<Double> weights) {
        double result = 0;
        for(int i=0; i<inputs.size(); i++) {
            result+=(inputs.get(i)*weights.get(i));
        }
        return result;
    }
}
