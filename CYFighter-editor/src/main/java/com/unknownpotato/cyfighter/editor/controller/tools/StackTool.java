/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unknownpotato.cyfighter.editor.controller.tools;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.model.Entity;
import com.unknownpotato.cyfighter.editor.model.Vector2;

/**
 *
 * @author kumikumi
 */
public class StackTool {
    private final Editor editor;
    
    private float dx;
    private float dy;
    private int count;

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    
    public StackTool(Editor editor) {
        this.editor = editor;
    }
    
    public void stack() {
        for (Entity e : editor.getSelectionTool().getSelectedEntities()) {
            stack(e);
        }
    }
    
    public void stack(Entity e) {
        if (count == 0) {
            return;
        }
        String type = e.getType();
        float x = e.getPos().x;
        float y = e.getPos().y;
        
        for (int i = 0; i<count; i++) {
            x+=dx;
            y+=dy;
            editor.getLevel().getEntities().add(new Entity(new Vector2(x, y), type, 0));
        }
    }
    
    
}
