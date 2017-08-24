/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.BadConsequence;
import napakalaki.Player;


public class PendingBadConsequenceView extends javax.swing.JPanel {

    BadConsequence pendingBadConsequenceModel;
    
    public void setPendingBadConsequence (BadConsequence t) {
        
        pendingBadConsequenceModel = t;
        
        text.setText(pendingBadConsequenceModel.getText());
        levels.setText("Niveles: " + Integer.toString(pendingBadConsequenceModel.getLevels()));
        
        //Finalizar con la siguiente orden para que los cambios se hagan efectivos
        repaint();
    }
    
    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();

        text.setText("Text");

        levels.setText("Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levels)
                    .addComponent(text))
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(text)
                .addGap(18, 18, 18)
                .addComponent(levels)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel levels;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}