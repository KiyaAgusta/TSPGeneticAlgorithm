package tspgeneticalgorithm.view;

import javax.swing.table.DefaultTableModel;
import tspgeneticalgorithm.controller.*;
import tspgeneticalgorithm.model.*;

public class TSPView extends javax.swing.JFrame {
    private static int citySize;
    private static int populationSize;
    private static double mutationRate;
    private DefaultTableModel resultTableModel;

    public TSPView() {
        initComponents();
        resultTableModel = (DefaultTableModel) resultTable.getModel();
    }

    public void setResult() {
        Tour tour;
        
        for (int i = 0; i < citySize; i++)
            CityDatabase.addCity(new City());

        // Initialize population
        Population pop = new Population(populationSize, true);
        initialDistanceLabel.setText("INITIAL DISTANCE \t: " + pop.getFittest().getDistance());

        // Evolve population
        for (int i = 0; i < populationSize; i++)
            pop = TSPLogic.evolvePopulation(pop, mutationRate);

        // Final results
        finalDistanceLabel.setText("FINAL DISTANCE \t: " + pop.getFittest().getDistance());
        tour = pop.getFittest();
        
        for (int i = 0; i < tour.tourSize(); i++) {
            resultTableModel.addRow(new Object[]{"ORDER", "CITY LOCATION"});
            resultTable.setValueAt(i + 1, resultTableModel.getRowCount() - 1, 0);
            resultTable.setValueAt("(" + tour.getCity(i) + ")", resultTableModel.getRowCount() - 1, 1);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        citiesLabel = new javax.swing.JLabel();
        generationLabel = new javax.swing.JLabel();
        mutationLabel = new javax.swing.JLabel();
        citiesTextField = new javax.swing.JTextField();
        generationTextField = new javax.swing.JTextField();
        mutationTextField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        initialDistanceLabel = new javax.swing.JLabel();
        finalDistanceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Made Akira - Genetic Algorithm");

        backgroundPanel.setBackground(new java.awt.Color(204, 255, 255));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("TRAVELING SALESMAN PROBLEM");

        citiesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        citiesLabel.setText("NUMBER OF CITIES :");

        generationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        generationLabel.setText("NUMBER OF GENERATION :");

        mutationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mutationLabel.setText("MUTATION PROBABILITY :");

        processButton.setText("PROCESS");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDER", "CITY LOCATION"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        initialDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        initialDistanceLabel.setText("INITIAL DISTANCE :");

        finalDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        finalDistanceLabel.setText("FINAL DISTANCE :");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(citiesLabel)
                                            .addComponent(generationLabel)
                                            .addComponent(mutationLabel)
                                            .addComponent(finalDistanceLabel)
                                            .addComponent(initialDistanceLabel))
                                        .addGap(25, 25, 25)
                                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(citiesTextField)
                                            .addComponent(generationTextField)
                                            .addComponent(mutationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(citiesLabel)
                    .addComponent(citiesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generationLabel)
                    .addComponent(generationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutationLabel)
                    .addComponent(mutationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(processButton)
                .addGap(18, 18, 18)
                .addComponent(initialDistanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finalDistanceLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        citySize = Integer.valueOf(citiesTextField.getText());
        populationSize = Integer.valueOf(generationTextField.getText());
        mutationRate = Double.valueOf(mutationTextField.getText());
        
        setResult();
    }//GEN-LAST:event_processButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSPView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel citiesLabel;
    private javax.swing.JTextField citiesTextField;
    private javax.swing.JLabel finalDistanceLabel;
    private javax.swing.JLabel generationLabel;
    private javax.swing.JTextField generationTextField;
    private javax.swing.JLabel initialDistanceLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mutationLabel;
    private javax.swing.JTextField mutationTextField;
    private javax.swing.JButton processButton;
    private javax.swing.JTable resultTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
