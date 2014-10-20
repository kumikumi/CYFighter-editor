/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.controller.tools;

import com.unknownpotato.cyfighter.editor.Observer;
import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.model.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author mikko
 */
public class SelectionTool implements Tool {

    private final Editor editor;
    private boolean selectMode;
    private Observer observer;

    private final List<Entity> selectedEntities;

    public SelectionTool(Editor editor) {
        this.editor = editor;
        this.selectedEntities = new ArrayList();
        this.observer = new Observer(){

            public void refresh() {
            }
            
        };
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public List<Entity> getSelectedEntities() {
        return selectedEntities;
    }

    public void delete() {
        editor.getLevel().getEntities().removeAll(selectedEntities);
        selectedEntities.clear();
    }

    public void mouseDown(int x, int y) {
        editor.getBeginSelect().x = x;
        editor.getBeginSelect().y = y;
        editor.getCurSelect().x = x;
        editor.getCurSelect().y = y;

        // Onko kohdalla joku valittu entity?
        for (Entity e : selectedEntities) {
            if (Math.abs(e.getPos().x - x) < 30) {
                if (Math.abs(e.getPos().y - y) < 30) {
                    selectMode = false;
                    return;
                }
            }
        }

        //Poista valinnat
        selectedEntities.clear();

        //Onko kohdalla jokin muu entity?
        for (Entity e : editor.getLevel().getEntities()) {
            if (Math.abs(e.getPos().x - x) < 30) {
                if (Math.abs(e.getPos().y - y) < 30) {
                    //Valitse se (huom. vain ensimmäinen löydetty)
                    selectedEntities.add(e);
                    selectMode = false;
                    this.observer.refresh();
                    return;
                }
            }
        }

        //ei tehdä mitään, jatkossa siis valitaan entityjä joten select = true
        selectMode = true;

        this.observer.refresh();
    }

    public void mouseMoved(int x, int y) {
        if (!editor.isMouseDown()) {
            return;
        }
        editor.getCurSelect().x = x;
        editor.getCurSelect().y = y;

        if (selectMode) {
            selectEntities();
        } else {
            moveEntities();
        }
        this.observer.refresh();
    }

    private void selectEntities() {
        selectedEntities.clear();
        for (Entity e : editor.getLevel().getEntities()) {
            if ((e.getPos().x > editor.getBeginSelect().x && e.getPos().x < editor.getCurSelect().x)
                    || (e.getPos().x > editor.getCurSelect().x && e.getPos().x < editor.getBeginSelect().x)) {

                if ((e.getPos().y > editor.getBeginSelect().y && e.getPos().y < editor.getCurSelect().y)
                        || (e.getPos().y > editor.getCurSelect().y && e.getPos().y < editor.getBeginSelect().y)) {

                    if (!selectedEntities.contains(e)) {
                        selectedEntities.add(e);
                    }
                }
            }
        }
    }

    private void moveEntities() {
        for (Entity e : selectedEntities) {
            e.getPos().x = e.getPos().x + (editor.getCurSelect().x - editor.getBeginSelect().x);
            e.getPos().y = e.getPos().y + (editor.getCurSelect().y - editor.getBeginSelect().y);
        }
        editor.getBeginSelect().x = editor.getCurSelect().x;
        editor.getBeginSelect().y = editor.getCurSelect().y;
    }

    public void mouseUp() {

    }
    
    public void changeTypeOfSelectedEntities(String type) {
        if (type == null || type.isEmpty()) {
            return;
        }
        for (Entity e : selectedEntities) {
            e.setType(type);
        }
    }

    public boolean isSelectionMode() {
        return this.selectMode;
    }

}
