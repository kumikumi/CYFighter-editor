/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.controller.tools;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.model.Entity;
import com.unknownpotato.cyfighter.editor.model.Vector2;

public class CreationTool implements Tool {
    private Editor editor;
    
    public CreationTool(Editor editor) {
        this.editor = editor;
    }
    
    public void mouseDown(int x, int y) {
        editor.getLevel().getEntities().add(new Entity(new Vector2(x, y), "rock", 0));
    }

    public void mouseMoved(int x, int y) {
    }

    public void mouseUp() {
    }

}
