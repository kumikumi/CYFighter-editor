/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.ui;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.controller.ToolType;
import com.unknownpotato.cyfighter.editor.controller.tools.SelectionTool;
import com.unknownpotato.cyfighter.editor.model.Entity;
import com.unknownpotato.cyfighter.editor.model.Level;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Collection;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mikko
 */
public class DrawArea extends JPanel {

    private Editor editor;
    private Level level;
    private Image rockImage;
    private SelectionTool selectionTool;
    
    public DrawArea() {

    }

    public DrawArea(Editor editor) {
        this.editor = editor;
        this.selectionTool = editor.getSelectionTool();
        try {
            rockImage = ImageIO.read(this.getClass().getResource("/Rock.png"));
        } catch (IOException ex) {
            System.out.println("kuvan lukeminen ei onnistunut");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (editor == null || editor.getLevel() == null) {
            drawDefaultScreen(g);
            return;
        }
        
        level = editor.getLevel();

        g.drawImage(level.getBackground(), 0, 0, this);
        drawEntities(g);
        drawEntitySelections(g);
        drawSelection(g);

    }

    @Override
    public Dimension getPreferredSize() {
        if (editor == null || editor.getLevel() == null) {
            return new Dimension(220, 220);
        }
        return new Dimension(editor.getLevel().getBackground().getWidth(null), editor.getLevel().getBackground().getHeight(null));
    }
    
    private void drawEntitySelections(Graphics g) {
        g.setColor(Color.YELLOW);
        for (Entity e : editor.getSelectedEntities()) {
            g.drawRect((int)(e.getPos().x), (int)(e.getPos().y), 30, 30);
        }
    }

    private void drawSelection(Graphics g) {
        if (editor.getCurrentTool() != ToolType.SELECT || !editor.isMouseDown() || !selectionTool.isSelectionMode()) {
            return;
        }
        g.setColor(Color.yellow);

        int alkuX = (int) (Math.min(this.editor.getBeginSelect().x, this.editor.getCurSelect().x) * this.editor.getZoom());
        int alkuY = (int) (Math.min(this.editor.getBeginSelect().y, this.editor.getCurSelect().y) * this.editor.getZoom());
        int loppuX = (int) (Math.max(this.editor.getBeginSelect().x, this.editor.getCurSelect().x) * this.editor.getZoom());
        int loppuY = (int) (Math.max(this.editor.getBeginSelect().y, this.editor.getCurSelect().y) * this.editor.getZoom());

        g.drawRect(alkuX, alkuY, loppuX - alkuX, loppuY - alkuY);

        
    }
    
    private void drawEntities(Graphics g) {
        Collection<Entity> entities = level.getEntities();
        for (Entity e : entities) {
            g.drawImage(rockImage, (int)(e.getPos().x), (int)e.getPos().y, null);
        }
    }

    private void drawDefaultScreen(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        g.setColor(Color.red);
        g.drawRect(20, 20, 20, 20);
        g.drawRect(35, 35, 20, 20);
    }

    public void redraw() {
        super.repaint();
    }

}
