/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.controller.tools;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.model.Entity;
import com.unknownpotato.cyfighter.editor.model.Vector2;
import java.util.Collection;

public class CreationTool implements Tool {
    private Editor editor;
    private String entityType;
    
    public CreationTool(Editor editor) {
        this.editor = editor;
        this.entityType = "spawnpoint";
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        System.out.println("entity type: " + entityType);
        this.entityType = entityType;
    }
    
    public Collection<String> getEntityTypes() {
        return editor.getEntityTypes();
    }
    
    public void mouseDown(int x, int y) {
        editor.getLevel().getEntities().add(new Entity(new Vector2(x, y), entityType, 0));
    }

    public void mouseMoved(int x, int y) {
    }

    public void mouseUp() {
    }

}
