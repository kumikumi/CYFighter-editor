/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.ui;

import com.unknownpotato.cyfighter.editor.Observer;
import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.controller.tools.CreationTool;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mikko
 */
public class CreationToolPanel extends javax.swing.JPanel implements Observer {

    private CreationTool creationTool;

    public CreationToolPanel(CreationTool creationTool) {
        this.creationTool = creationTool;
        initComponents();
    }

    /**
     * Creates new form CreatePanel
     */
    public CreationToolPanel() {
        this(null);
    }

    @Override
    public void refresh() {
        this.entityTypeBox.setModel(new DefaultComboBoxModel(creationTool.getEntityTypes().toArray()));
        this.entityTypeBox.setSelectedItem(creationTool.getEntityType());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        entityTypeBox = new javax.swing.JComboBox();

        jLabel1.setText("creating stuff");

        entityTypeBox.setEditable(true);
        entityTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        entityTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entityTypeBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addComponent(entityTypeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entityTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void entityTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entityTypeBoxActionPerformed
        // TODO add your handling code here:
//        System.out.println("action performed");
//        System.out.println(entityTypeBox.getSelectedItem());
        creationTool.setEntityType((String) entityTypeBox.getSelectedItem());
        refresh();
    }//GEN-LAST:event_entityTypeBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox entityTypeBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
