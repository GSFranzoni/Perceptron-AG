package Perceptron;

import AG.Cromossomo;
import View.FileScreen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Perceptron {

    private static ArrayList<ArrayList<Double>> inputs = null;
    private static ArrayList<Double> outputs = null;
    public static String ativfunction = "Sigmoid";

    public Perceptron() {
        this.readFile();
    }

    public final void readFile() {
        BufferedReader reader = null;
        try {
            this.inputs = new ArrayList<>();
            this.outputs = new ArrayList<>();
            reader = new BufferedReader(new FileReader(FileScreen.path));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] in = line.split(";")[0].trim().split(" ");
                String out = line.split(";")[1].trim();
                ArrayList<Double> input = new ArrayList<>();
                for (String i : in) {
                    input.add(Double.parseDouble(i));
                }
                input.add(-1.0);
                this.inputs.add(input);
                this.outputs.add(Double.parseDouble(out));
            }
            reader.close();
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double getErro(Cromossomo cromossomo) {

        Double erro = 0.0;
        ArrayList<Double> weights = new ArrayList<>(cromossomo.getGenes().subList(0, cromossomo.getTamanho()));
        Double threshold = cromossomo.getGenes().get(cromossomo.getTamanho() - 1);

        for (int i = 0; i < Perceptron.inputs.size(); i++) {
            ArrayList<Double> input = Perceptron.inputs.get(i);
            Double output = Perceptron.outputs.get(i);
            switch (Perceptron.ativfunction) {
                case "Passo":
                    erro += Math.abs(Util.MathUtil.erroQuadratico(Perceptron.outputs.get(i), Ativation.step(Neuron.sigma(input, weights), threshold), Perceptron.inputs.size()));
                    break;
                case "Sinal":
                    erro += Math.abs(Util.MathUtil.erroQuadratico(Perceptron.outputs.get(i), Ativation.sign(Neuron.sigma(input, weights), threshold), Perceptron.inputs.size()));
                    break;
                case "Sigmoid":
                    erro += Math.abs(Util.MathUtil.erroQuadratico(Perceptron.outputs.get(i), Ativation.sigmoid(Neuron.sigma(input, weights)), Perceptron.inputs.size()));
                    break;
                case "Tangente":
                    erro += Math.abs(Util.MathUtil.erroQuadratico(Perceptron.outputs.get(i), Ativation.tanh(Neuron.sigma(input, weights)), Perceptron.inputs.size()));
                    break;
                case "Linear":
                    erro += Math.abs(Util.MathUtil.erroQuadratico(Perceptron.outputs.get(i), Ativation.linear(Neuron.sigma(input, weights)), Perceptron.inputs.size()));
                    break;
            }
        }
        return erro;
    }

    public static double getOutput(Cromossomo cromossomo, ArrayList<Double> input) {
        input.add(-1.0);
        ArrayList<Double> weights = new ArrayList<>(cromossomo.getGenes().subList(0, cromossomo.getTamanho()-1));
        Double threshold = cromossomo.getGenes().get(cromossomo.getTamanho() - 1);
        
        switch (Perceptron.ativfunction) {
            case "Passo":
                return Ativation.step(Neuron.sigma(input, weights), threshold);
            case "Sinal":
                return Ativation.sign(Neuron.sigma(input, weights), threshold);
            case "Sigmoid":
                return Ativation.sigmoid(Neuron.sigma(input, weights));
            case "Tangente":
                return Ativation.tanh(Neuron.sigma(input, weights));
            case "Linear":
                return Ativation.linear(Neuron.sigma(input, weights));
        }
        return -1;
    }

    public static int getFileSize() {
        return Perceptron.inputs.get(0).size();
    }

}
