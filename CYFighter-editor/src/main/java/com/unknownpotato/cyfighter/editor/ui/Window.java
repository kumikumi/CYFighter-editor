/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.ui;

import com.unknownpotato.cyfighter.editor.Observer;
import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.controller.ToolType;
import com.unknownpotato.cyfighter.editor.controller.tools.CreationTool;
import com.unknownpotato.cyfighter.editor.controller.tools.SelectionTool;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

/**
 *
 * @author mikko
 */
public class Window extends javax.swing.JFrame implements Observer {

    private Editor editor;
    private MouseListenerImpl mouseListener;
    private CreationToolPanel createPanel;
    private SelectionToolPanel selectPanel;

    public Window(Editor editor) {
        this.editor = editor;
        this.editor.setObserver(this);
        this.drawArea1 = new DrawArea(editor);
        this.mouseListener = new MouseListenerImpl(editor);
        this.createPanel = new CreationToolPanel((CreationTool)editor.getTools().get(ToolType.CREATE));
        this.selectPanel = new SelectionToolPanel(this, (SelectionTool)editor.getTools().get(ToolType.SELECT));
        
        initComponents();
        sidePanel.setLayout(new FlowLayout());
        drawArea1.addMouseListener(mouseListener);
        drawArea1.addMouseMotionListener(mouseListener);
        this.updateUI();
    }

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
    }

    private void updateUI() {
        this.drawArea1.redraw();
        jScrollPane1.setViewportView(drawArea1);
        updateMenuBar();
        updateToolBar();
        //updateSidePanel();
        //selectPanel.update();
    }

    private void updateMenuBar() {
        saveProjectMenuItem.setEnabled(editor.getCurrentFile() != null);
        saveAsMenuItem.setEnabled(editor.getLevel() != null);
        closeProjectMenuItem.setEnabled(editor.getLevel() != null);
    }

    private void updateToolBar() {
        selectButton.setSelected(editor.getCurrentTool() == ToolType.SELECT);
        createButton.setSelected(editor.getCurrentTool() == ToolType.CREATE);
    }

    private void updateSidePanel() {
        sidePanel.removeAll();
        if (editor.getLevel() == null) {
            return;
        }
        switch (editor.getCurrentTool()) {
            case SELECT:
                sidePanel.add(selectPanel);
                break;
            case CREATE:
                sidePanel.add(createPanel);
                createPanel.refresh();
                break;
        }
        sidePanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        drawArea1 = new DrawArea(editor);
        jToolBar1 = new javax.swing.JToolBar();
        selectButton = new javax.swing.JToggleButton();
        createButton = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        sidePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newProjectMenuItem = new javax.swing.JMenuItem();
        openFileMenuItem = new javax.swing.JMenuItem();
        saveProjectMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        closeProjectMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        stackMenuItem = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout drawArea1Layout = new javax.swing.GroupLayout(drawArea1);
        drawArea1.setLayout(drawArea1Layout);
        drawArea1Layout.setHorizontalGroup(
            drawArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        drawArea1Layout.setVerticalGroup(
            drawArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(drawArea1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        selectButton.setText("Select/Move");
        selectButton.setFocusable(false);
        selectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(selectButton);

        createButton.setText("Create");
        createButton.setFocusable(false);
        createButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(createButton);

        jToggleButton3.setText("jToggleButton3");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jToggleButton3);

        jToggleButton4.setText("jToggleButton4");
        jToggleButton4.setFocusable(false);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jToggleButton4);

        sidePanel.setMaximumSize(new java.awt.Dimension(300, 32767));
        sidePanel.setMinimumSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        newProjectMenuItem.setText("New");
        newProjectMenuItem.setEnabled(false);
        jMenu1.add(newProjectMenuItem);

        openFileMenuItem.setText("Open");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openFileMenuItem);

        saveProjectMenuItem.setText("Save");
        saveProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProjectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveProjectMenuItem);

        saveAsMenuItem.setText("Save as...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsMenuItem);

        closeProjectMenuItem.setText("Close");
        closeProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeProjectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(closeProjectMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        stackMenuItem.setText("Stack");
        stackMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stackMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(stackMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser openFile = new JFileChooser();
        openFile.setDialogTitle("Import level");
        //openFile.setFileSelectionMode(1);
        FileFilter filtteri = new FileFilter() {

            @Override
            public boolean accept(File f) {

                return true;
            }

            @Override
            public String getDescription() {
                return "CYFighter map file";
            }

        };

        openFile.addChoosableFileFilter(filtteri);
        openFile.setFileFilter(filtteri);
        openFile.setFileView(new FileView() {

        });
        int palautus = openFile.showOpenDialog(null);
        if (palautus != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = openFile.getSelectedFile();
        if (file == null) {
            return;
        }
        this.editor.loadLevel(file);
        this.updateUI();
    }//GEN-LAST:event_openFileMenuItemActionPerformed

    private void saveProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProjectMenuItemActionPerformed
        // TODO add your handling code here:
        editor.saveLevel();
    }//GEN-LAST:event_saveProjectMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser saveFile = new JFileChooser();
        saveFile.setDialogTitle("Save map");
        saveFile.showSaveDialog(null);
        File file = saveFile.getSelectedFile();
        if (file == null) {
            return;
        }

        editor.saveLevelAs(file);
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void closeProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeProjectMenuItemActionPerformed
        // TODO add your handling code here:
        editor.close();
    }//GEN-LAST:event_closeProjectMenuItemActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // TODO add your handling code here:
        editor.setCurrentTool(ToolType.SELECT);
        this.updateSidePanel();
        this.updateUI();
    }//GEN-LAST:event_selectButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        editor.setCurrentTool(ToolType.CREATE);
        this.updateSidePanel();
        this.updateUI();
    }//GEN-LAST:event_createButtonActionPerformed

    private void stackMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stackMenuItemActionPerformed
        // TODO add your handling code here:
        new StackToolFrame(editor.getStackTool()).setVisible(true);
    }//GEN-LAST:event_stackMenuItemActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Window().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeProjectMenuItem;
    private javax.swing.JToggleButton createButton;
    private com.unknownpotato.cyfighter.editor.ui.DrawArea drawArea1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem newProjectMenuItem;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveProjectMenuItem;
    private javax.swing.JToggleButton selectButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JMenuItem stackMenuItem;
    // End of variables declaration//GEN-END:variables

    public void refresh() {
        this.updateUI();
    }
}
