
package AG;

import Perceptron.Perceptron;
import java.util.ArrayList;
import java.util.Random;

public class Cromossomo {
    
    private int tamanho;
    private ArrayList<Double> genes = null;

    public Cromossomo() {
        this.tamanho = Perceptron.getFileSize()+1;
        this.gerar();
    }
    
    public Cromossomo(ArrayList<Double> genes) {
        this.genes = genes;
        this.tamanho = genes.size();
    }
    
    public final void gerar() {
        this.genes = new ArrayList<>();
        for(int i=0; i<this.tamanho; i++) {
            this.genes.add((new Random().nextDouble()-0.5)*(new Random().nextInt(1000)));
        }
    }
    
    public Double fitness() {
        return Math.abs(Perceptron.getErro(this));
    }
    
    public void mutar() {
        int pos[] = {
            new Random().nextInt(this.tamanho),
            new Random().nextInt(this.tamanho) 
        };
        double aux = this.genes.get(pos[0]);
        this.genes.set(pos[0], this.genes.get(pos[1]));
        this.genes.set(pos[1], aux);
    }

    public ArrayList<Double> getGenes() {
        return genes;
    }

    public void setGenes(ArrayList<Double> genes) {
        this.genes = genes;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
