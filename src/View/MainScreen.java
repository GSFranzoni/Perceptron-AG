package View;

import AG.Cromossomo;
import AG.Populacao;
import Perceptron.Perceptron;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class MainScreen extends javax.swing.JFrame implements Runnable {
    
    Thread thread = null;
    JFreeChart chart = null;
    SetDataScreen dataScreen = null;
    public DefaultCategoryDataset dataset = null;
    Populacao populacao = null;

    public MainScreen() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.jRadioButtonPasso.setActionCommand("Passo");
        this.jRadioButtonSinal.setActionCommand("Sinal");
        this.jRadioButtonTan.setActionCommand("Tangente");
        this.jRadioButtonSigmoid.setActionCommand("Sigmoid");
        this.jRadioButtonLinear.setActionCommand("Linear");

        createChart();
    }

    public void createChart() {
        this.dataset = new DefaultCategoryDataset();
        this.chart = ChartFactory.createLineChart(
                "Evolução da população",
                "Gerações",
                "Fitness",
                dataset
        );
        this.chart.getPlot().setBackgroundPaint(new ChartColor(255, 255, 255));
        this.jPanelGrafico.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        this.jPanelGrafico.add(CP, BorderLayout.CENTER);
        this.jPanelGrafico.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAtivacao = new javax.swing.ButtonGroup();
        jPanelBg = new javax.swing.JPanel();
        jPanelGrafico = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaFilePath = new javax.swing.JTextArea();
        jLabelOutput = new javax.swing.JLabel();
        jTextFieldOutput = new javax.swing.JTextField();
        jButtonGetOutput = new javax.swing.JButton();
        jLabelTamanhoPopulacao = new javax.swing.JLabel();
        jButtonConjuntoTreinamento = new javax.swing.JButton();
        jTextFieldTamanhoPop = new javax.swing.JTextField();
        jRadioButtonPasso = new javax.swing.JRadioButton();
        jTextFieldTaxaMut = new javax.swing.JTextField();
        jRadioButtonSinal = new javax.swing.JRadioButton();
        jLabelErroMinimo2 = new javax.swing.JLabel();
        jLabelAtivacao = new javax.swing.JLabel();
        jLabelErroMinimo3 = new javax.swing.JLabel();
        jTextFieldTaxaCruz = new javax.swing.JTextField();
        jTextFieldErro = new javax.swing.JTextField();
        jLabelErroMinimo = new javax.swing.JLabel();
        jRadioButtonSigmoid = new javax.swing.JRadioButton();
        jRadioButtonTan = new javax.swing.JRadioButton();
        jButtonTreinarParar = new javax.swing.JButton();
        jRadioButtonLinear = new javax.swing.JRadioButton();
        jButtonTreinar = new javax.swing.JButton();
        jLabelInput = new javax.swing.JLabel();
        jButtonOpenFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInput = new javax.swing.JTextArea();
        jLabelAtual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelFitnessMedio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelFitnessMaior = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perceptron");

        jPanelBg.setForeground(new java.awt.Color(255, 255, 255));

        jPanelGrafico.setEnabled(false);

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextAreaFilePath.setEditable(false);
        jTextAreaFilePath.setColumns(20);
        jTextAreaFilePath.setRows(5);
        jTextAreaFilePath.setText("input.txt");
        jScrollPane2.setViewportView(jTextAreaFilePath);

        jLabelOutput.setText("Output");

        jTextFieldOutput.setEditable(false);

        jButtonGetOutput.setText("Gerar saída");
        jButtonGetOutput.setEnabled(false);
        jButtonGetOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetOutputActionPerformed(evt);
            }
        });

        jLabelTamanhoPopulacao.setText("Tamanho população");

        jButtonConjuntoTreinamento.setText("Editar arquivo");
        jButtonConjuntoTreinamento.setToolTipText("Setar os dados para o treinamento");
        jButtonConjuntoTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConjuntoTreinamentoActionPerformed(evt);
            }
        });

        jTextFieldTamanhoPop.setText("1000");
        jTextFieldTamanhoPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTamanhoPopActionPerformed(evt);
            }
        });
        jTextFieldTamanhoPop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTamanhoPopKeyTyped(evt);
            }
        });

        buttonGroupAtivacao.add(jRadioButtonPasso);
        jRadioButtonPasso.setSelected(true);
        jRadioButtonPasso.setText("Passo");
        jRadioButtonPasso.setName("Passo"); // NOI18N

        jTextFieldTaxaMut.setText(".001");
        jTextFieldTaxaMut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTaxaMutKeyTyped(evt);
            }
        });

        buttonGroupAtivacao.add(jRadioButtonSinal);
        jRadioButtonSinal.setText("Sinal");
        jRadioButtonSinal.setName("Sinal"); // NOI18N

        jLabelErroMinimo2.setText("Taxa de mutação");

        jLabelAtivacao.setText("Função de ativação");

        jLabelErroMinimo3.setText("Taxa de cruzamento");

        jTextFieldTaxaCruz.setText(".7");
        jTextFieldTaxaCruz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTaxaCruzKeyTyped(evt);
            }
        });

        jTextFieldErro.setText(".001");
        jTextFieldErro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldErroKeyTyped(evt);
            }
        });

        jLabelErroMinimo.setText("Erro mínimo");

        buttonGroupAtivacao.add(jRadioButtonSigmoid);
        jRadioButtonSigmoid.setText("Sigmoid");
        jRadioButtonSigmoid.setName("Sigmoid"); // NOI18N

        buttonGroupAtivacao.add(jRadioButtonTan);
        jRadioButtonTan.setText("Tangente hiperbólica");
        jRadioButtonTan.setActionCommand("Tangente");
        jRadioButtonTan.setName("Tangente"); // NOI18N

        jButtonTreinarParar.setBackground(new java.awt.Color(204, 0, 51));
        jButtonTreinarParar.setText("Parar");
        jButtonTreinarParar.setEnabled(false);
        jButtonTreinarParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTreinarPararActionPerformed(evt);
            }
        });

        buttonGroupAtivacao.add(jRadioButtonLinear);
        jRadioButtonLinear.setText("Linear");
        jRadioButtonLinear.setName("Passo"); // NOI18N

        jButtonTreinar.setText("Treinar");
        jButtonTreinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTreinarActionPerformed(evt);
            }
        });

        jLabelInput.setText("Input");

        jButtonOpenFile.setText("Abrir arquivo");
        jButtonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenFileActionPerformed(evt);
            }
        });

        jTextAreaInput.setColumns(20);
        jTextAreaInput.setRows(5);
        jTextAreaInput.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaInput);

        jLabelAtual.setText("Arquivo de treino atual:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPasso)
                            .addComponent(jRadioButtonSinal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonTan)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonSigmoid)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonLinear))))
                    .addComponent(jLabelAtivacao)
                    .addComponent(jScrollPane1)
                    .addComponent(jButtonGetOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelErroMinimo)
                            .addComponent(jTextFieldErro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTamanhoPopulacao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldTamanhoPop)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelErroMinimo2)
                            .addComponent(jTextFieldTaxaMut, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelErroMinimo3)
                            .addComponent(jTextFieldTaxaCruz)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonOpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConjuntoTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelAtual, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonTreinar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonTreinarParar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTamanhoPop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonConjuntoTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelErroMinimo)
                            .addComponent(jLabelTamanhoPopulacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldErro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelErroMinimo2)
                            .addComponent(jLabelErroMinimo3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTaxaMut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldTaxaCruz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelAtivacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPasso)
                    .addComponent(jRadioButtonSigmoid)
                    .addComponent(jRadioButtonLinear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSinal)
                    .addComponent(jRadioButtonTan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTreinar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTreinarParar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelInput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButtonGetOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setText("Fitness médio");

        jLabelFitnessMedio.setText("0");

        jLabel2.setText("Fitness maior");

        jLabelFitnessMaior.setText("0");

        javax.swing.GroupLayout jPanelBgLayout = new javax.swing.GroupLayout(jPanelBg);
        jPanelBg.setLayout(jPanelBgLayout);
        jPanelBgLayout.setHorizontalGroup(
            jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabelFitnessMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelFitnessMaior, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanelBgLayout.setVerticalGroup(
            jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBgLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelBgLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelBgLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFitnessMedio))
                            .addGroup(jPanelBgLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFitnessMaior)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTreinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreinarActionPerformed
        this.createChart();
        this.clear();
        this.manage(false);
        this.thread = new Thread(this);
        this.thread.start();
    }//GEN-LAST:event_jButtonTreinarActionPerformed

    @Override
    public void run() {
        this.populacao = new Populacao(
            Integer.parseInt(this.jTextFieldTamanhoPop.getText()),
            Double.parseDouble(this.jTextFieldTaxaMut.getText()), 
            Double.parseDouble(this.jTextFieldTaxaCruz.getText())
        );
        Perceptron.ativfunction = this.buttonGroupAtivacao.getSelection().getActionCommand();
        int geracoes = 1;
        Double fitMin = Double.parseDouble(this.jTextFieldErro.getText()), fit = fitMin+1;
        while(fit>fitMin){
            fit = this.populacao.iterar();
            this.jLabelFitnessMedio.setText(String.valueOf(fit));
            this.jLabelFitnessMaior.setText(String.valueOf(populacao.getMelhor().fitness()));
            try {
                Thread.sleep(500);
                this.dataset.addValue(fit, "Fitness", String.valueOf(geracoes++));
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void manage(boolean state) {
        this.jButtonTreinar.setText((state) ? "Treinar" : "Treinando...");
        this.jButtonConjuntoTreinamento.setEnabled(state);
        this.jButtonTreinar.setEnabled(state);
        this.jButtonGetOutput.setEnabled(true);
        this.jTextAreaInput.setEnabled(true);
        this.jRadioButtonPasso.setEnabled(state);
        this.jRadioButtonSigmoid.setEnabled(state);
        this.jRadioButtonSinal.setEnabled(state);
        this.jRadioButtonLinear.setEnabled(state);
        this.jRadioButtonTan.setEnabled(state);
        this.jTextFieldErro.setEnabled(state);
        this.jButtonTreinarParar.setEnabled(!state);
        this.jButtonOpenFile.setEnabled(state);
        this.jTextFieldTamanhoPop.setEnabled(state);
        this.jTextFieldTaxaCruz.setEnabled(state);
        this.jTextFieldTaxaMut.setEnabled(state);
    }

    public void clear() {
        this.jTextAreaInput.setText("");
        this.jTextFieldOutput.setText("");
    }

    private void jButtonGetOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetOutputActionPerformed
        try {
            String[] textoInput = this.jTextAreaInput.getText().split(" ");
            ArrayList<Double> input = new ArrayList<>();
            for (String i: textoInput) {
                input.add(Double.parseDouble(i));
            }
            this.jTextFieldOutput.setText(String.valueOf(Perceptron.getOutput(this.populacao.getMelhor(), input)));
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Entrada inválida! " + e);
        }
    }//GEN-LAST:event_jButtonGetOutputActionPerformed

    private void jButtonConjuntoTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConjuntoTreinamentoActionPerformed
        this.dataScreen = new SetDataScreen(FileScreen.path);
        dataScreen.setVisible(true);
    }//GEN-LAST:event_jButtonConjuntoTreinamentoActionPerformed

    private void jTextFieldErroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldErroKeyTyped
        if ((evt.getKeyChar() == '.' && this.jTextFieldErro.getText().contains(".")) || (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldErroKeyTyped

    private void jButtonTreinarPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreinarPararActionPerformed
        this.thread.stop();
        this.manage(true);
    }//GEN-LAST:event_jButtonTreinarPararActionPerformed

    private void jButtonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenFileActionPerformed
        FileScreen fileScreen = new FileScreen(this, true);
        fileScreen.setVisible(true);
        try {
            this.jTextAreaFilePath.setText(FileScreen.path);
        }
        catch(Exception e) {
            
        }
    }//GEN-LAST:event_jButtonOpenFileActionPerformed

    private void jTextFieldTamanhoPopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTamanhoPopKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTamanhoPopKeyTyped

    private void jTextFieldTaxaMutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTaxaMutKeyTyped
        if ((evt.getKeyChar() == '.' && this.jTextFieldTaxaMut.getText().contains(".")) || (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTaxaMutKeyTyped

    private void jTextFieldTaxaCruzKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTaxaCruzKeyTyped
        if ((evt.getKeyChar() == '.' && this.jTextFieldTaxaCruz.getText().contains(".")) || (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTaxaCruzKeyTyped

    private void jTextFieldTamanhoPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTamanhoPopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTamanhoPopActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAtivacao;
    private javax.swing.JButton jButtonConjuntoTreinamento;
    private javax.swing.JButton jButtonGetOutput;
    private javax.swing.JButton jButtonOpenFile;
    private javax.swing.JButton jButtonTreinar;
    private javax.swing.JButton jButtonTreinarParar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAtivacao;
    private javax.swing.JLabel jLabelAtual;
    private javax.swing.JLabel jLabelErroMinimo;
    private javax.swing.JLabel jLabelErroMinimo2;
    private javax.swing.JLabel jLabelErroMinimo3;
    private javax.swing.JLabel jLabelFitnessMaior;
    private javax.swing.JLabel jLabelFitnessMedio;
    private javax.swing.JLabel jLabelInput;
    private javax.swing.JLabel jLabelOutput;
    private javax.swing.JLabel jLabelTamanhoPopulacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBg;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JRadioButton jRadioButtonLinear;
    private javax.swing.JRadioButton jRadioButtonPasso;
    private javax.swing.JRadioButton jRadioButtonSigmoid;
    private javax.swing.JRadioButton jRadioButtonSinal;
    private javax.swing.JRadioButton jRadioButtonTan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaFilePath;
    private javax.swing.JTextArea jTextAreaInput;
    private javax.swing.JTextField jTextFieldErro;
    private javax.swing.JTextField jTextFieldOutput;
    private javax.swing.JTextField jTextFieldTamanhoPop;
    private javax.swing.JTextField jTextFieldTaxaCruz;
    private javax.swing.JTextField jTextFieldTaxaMut;
    // End of variables declaration//GEN-END:variables

}
