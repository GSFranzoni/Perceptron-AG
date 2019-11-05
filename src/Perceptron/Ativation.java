
package Perceptron;

public class Ativation {
    public static Double sign(Double x, Double threshold) {
        return x>=threshold? 1.0: -1.0;
    }
    
    public static Double step(Double x, Double threshold) {
        return x>=threshold? 1.0: 0.0;
    }
    
    public static Double sigmoid(Double x) {
        return 1.0/(1.0+Math.exp(-x));
    }
    
    public static Double linear(Double x) {
        return x;
    }
    
    public static Double tanh(Double x) {
        return Math.tanh(x);
    }
}
