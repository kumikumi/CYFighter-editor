/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unknownpotato.cyfighter.editor.ui;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author mikko
 */
public class MouseListenerImpl implements MouseListener, MouseMotionListener{
    private Editor editor;
    
    public MouseListenerImpl(Editor editor) {
        this.editor = editor;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        editor.mouseDown(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        editor.mouseUp();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        editor.mouseMoved(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        editor.mouseMoved(e.getX(), e.getY());
    }
    
}
