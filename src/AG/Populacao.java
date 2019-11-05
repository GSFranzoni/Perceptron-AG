
package AG;

import Perceptron.Perceptron;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Populacao {
    
    private Double taxaDeMutacao = 0.0, taxaDeReproducao = 0.0;
    private Perceptron perceptron = null;
    private final int tamanho;
    private ArrayList<Cromossomo> cromossomos = null;
    private Cromossomo melhor = null;

    public Populacao(int tamanho, Double taxaDeMutacao, Double taxaDeReproducao) {
        this.taxaDeMutacao = taxaDeMutacao;
        this.taxaDeReproducao = taxaDeReproducao;
        this.tamanho = tamanho;
        this.cromossomos = new ArrayList<>();
        this.perceptron = new Perceptron();
        this.gerar();
    }
    
    public final void gerar() {
        for(int i=0; i<this.tamanho; i++) {
            this.cromossomos.add(new Cromossomo());
        }
    }
    
    // elitismo
    public void selecao() {
        this.cromossomos.sort(Comparator.comparing(Cromossomo::fitness));
        this.cromossomos = new ArrayList<>(this.cromossomos.subList(0, this.tamanho));
        this.melhor = this.cromossomos.get(0);
    }
    
    public void reproducao() {
        for(int i=0; i<(int)(this.taxaDeReproducao*this.tamanho); i++) {
            
            int point = new Random().nextInt(this.cromossomos.get(0).getTamanho());
                                                                        
            Cromossomo pai = this.cromossomos.get(new Random().nextInt(this.cromossomos.size()));
            Cromossomo mae = this.cromossomos.get(new Random().nextInt(this.cromossomos.size()));
            
            ArrayList<Double> genesFilho = new ArrayList<>();
            genesFilho.addAll(new ArrayList<>(pai.getGenes().subList(0, point)));
            genesFilho.addAll(new ArrayList<>(mae.getGenes().subList(point, this.cromossomos.get(0).getTamanho())));
                        
            ArrayList<Double> genesFilha = new ArrayList<>();
            genesFilha.addAll(new ArrayList<>(mae.getGenes().subList(0, point)));
            genesFilha.addAll(new ArrayList<>(pai.getGenes().subList(point, this.cromossomos.get(0).getTamanho())));
            
            this.cromossomos.add(new Cromossomo(genesFilho));
            this.cromossomos.add(new Cromossomo(genesFilha));
        }
    }
    
    public void mutacao() {
        for(int i=0; i<(int)(this.taxaDeMutacao*this.cromossomos.size()); i++) {
            this.cromossomos.get(1+new Random().nextInt(this.cromossomos.size()-1)).mutar();
        }
    }
    
    public double iterar() {
        this.selecao();
        this.reproducao();
        this.mutacao();
        
        Double erro = 0.0;
        for(Cromossomo cromossomo: this.cromossomos) {
            erro+=cromossomo.fitness();
        }
        return erro/this.cromossomos.size();
    }
    
    public Cromossomo getMelhor() {
        return this.melhor;
    }

    public Perceptron getPerceptron() {
        return perceptron;
    }

}
