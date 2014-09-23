/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.controller.tools;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.model.Entity;

/**
 *
 * @author mikko
 */
public class SelectionTool implements Tool {

    private final Editor editor;
    private boolean selectMode;

    public SelectionTool(Editor editor) {
        this.editor = editor;
    }

    public void mouseDown(int x, int y) {
        editor.getBeginSelect().x = x;
        editor.getBeginSelect().y = y;
        editor.getCurSelect().x = x;
        editor.getCurSelect().y = y;

        // Onko kohdalla joku valittu entity?
        for (Entity e : editor.getSelectedEntities()) {
            if (Math.abs(e.getPos().x - x) < 30) {
                if (Math.abs(e.getPos().y - y) < 30) {
                    selectMode = false;
                    return;
                }
            }
        }

        //Poista valinnat
        editor.getSelectedEntities().clear();

        //Onko kohdalla jokin muu entity?
        for (Entity e : editor.getLevel().getEntities()) {
            if (Math.abs(e.getPos().x - x) < 30) {
                if (Math.abs(e.getPos().y - y) < 30) {
                    //Valitse se (huom. vain ensimmäinen löydetty)
                    editor.getSelectedEntities().add(e);
                    selectMode = false;
                    return;
                }
            }
        }

        //ei tehdä mitään, jatkossa siis valitaan entityjä joten select = true
        selectMode = true;

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
    }

    private void selectEntities() {
        editor.getSelectedEntities().clear();
        for (Entity e : editor.getLevel().getEntities()) {
            if ((e.getPos().x > editor.getBeginSelect().x && e.getPos().x < editor.getCurSelect().x)
                    || (e.getPos().x > editor.getCurSelect().x && e.getPos().x < editor.getBeginSelect().x)) {

                if ((e.getPos().y > editor.getBeginSelect().y && e.getPos().y < editor.getCurSelect().y)
                        || (e.getPos().y > editor.getCurSelect().y && e.getPos().y < editor.getBeginSelect().y)) {

                    if (!editor.getSelectedEntities().contains(e)) {
                        editor.getSelectedEntities().add(e);
                    }
                }
            }
        }
    }

    private void moveEntities() {
        for (Entity e : editor.getSelectedEntities()) {
            e.getPos().x = e.getPos().x + (editor.getCurSelect().x - editor.getBeginSelect().x);
            e.getPos().y = e.getPos().y + (editor.getCurSelect().y - editor.getBeginSelect().y);
        }
        editor.getBeginSelect().x = editor.getCurSelect().x;
        editor.getBeginSelect().y = editor.getCurSelect().y;
    }

    public void mouseUp() {

    }

    public boolean isSelectionMode() {
        return this.selectMode;
    }

}
