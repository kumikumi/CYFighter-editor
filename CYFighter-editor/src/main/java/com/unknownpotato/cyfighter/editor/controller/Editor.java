package com.unknownpotato.cyfighter.editor.controller;

import com.unknownpotato.cyfighter.editor.Observer;
import com.unknownpotato.cyfighter.editor.controller.tools.CreationTool;
import com.unknownpotato.cyfighter.editor.controller.tools.SelectionTool;
import com.unknownpotato.cyfighter.editor.controller.tools.StackTool;
import com.unknownpotato.cyfighter.editor.controller.tools.Tool;
import com.unknownpotato.cyfighter.editor.fileio.MapLoader;
import com.unknownpotato.cyfighter.editor.fileio.MapSaver;
import com.unknownpotato.cyfighter.editor.model.Entity;
import com.unknownpotato.cyfighter.editor.model.EntityType;
import com.unknownpotato.cyfighter.editor.model.Level;
import com.unknownpotato.cyfighter.editor.model.Vector2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mikko
 */
public class Editor {

    private final MapLoader maploader;
    private final MapSaver mapsaver;
    private Observer observer;
    private Level level;
    private File currentFile;
    private boolean mouseDown;

    private final Map<ToolType, Tool> tools;

    private ToolType currentTool = ToolType.SELECT;
    private final Vector2 beginSelect;
    private final Vector2 curSelect;
    
    private Set<String> entityTypes;
    
    private StackTool stackTool;

    

    public Editor(Observer observer) {
        this.observer = observer;
        this.maploader = new MapLoader();
        this.mapsaver = new MapSaver();
        this.beginSelect = new Vector2(0, 0);
        this.curSelect = new Vector2(0, 0);
        this.entityTypes = new HashSet<>();
        
        this.tools = new EnumMap<>(ToolType.class);
        tools.put(ToolType.CREATE, new CreationTool(this));
        tools.put(ToolType.SELECT, new SelectionTool(this));
        
        this.stackTool = new StackTool(this);
    }

    public StackTool getStackTool() {
        return stackTool;
    }
    
    public Collection<String> getEntityTypes() {
        entityTypes = new HashSet<>();
        for (Entity e : level.getEntities()) {
            entityTypes.add(e.getType());
        }
        return entityTypes;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public Level getLevel() {
        return level;
    }

    public Map<ToolType, Tool> getTools() {
        return tools;
    }

//    public void newLevel() {
//        this.level = new Level();
//    }
    public void loadLevel(File file) {
        this.currentFile = file;
        this.level = maploader.readMap(file);
        System.out.println("ladattiin taso " + this.level.getMetadata().nimi);
    }

    public void saveLevel() {
        if (level == null) {
            return;
        }
        mapsaver.saveMap(level, currentFile);
    }

    public void saveLevelAs(File file) {
        if (level == null) {
            return;
        }
        mapsaver.saveMap(level, file);
    }

    public void close() {
        this.level = null;
        this.currentFile = null;
        this.observer.refresh();
    }

    public void mouseDown(int x, int y) {
        if (this.level == null) {
            return;
        }
        this.mouseDown = true;
        this.tools.get(currentTool).mouseDown(x, y);
        this.observer.refresh();
    }

    public double getZoom() {
        return 1.0;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void mouseUp() {
        if (this.level == null) {
            return;
        }
        this.mouseDown = false;
        tools.get(currentTool).mouseUp();
        this.observer.refresh();
    }

    public void mouseMoved(int x, int y) {
        if (this.level == null) {
            return;
        }
        tools.get(currentTool).mouseMoved(x, y);
        this.observer.refresh();
    }

    public Vector2 getBeginSelect() {
        return beginSelect;
    }

    public Vector2 getCurSelect() {
        return curSelect;
    }

    public boolean isMouseDown() {
        return mouseDown;
    }

    public void setCurrentTool(ToolType tool) {
        this.currentTool = tool;
    }

    public ToolType getCurrentTool() {
        return currentTool;
    }
    
    public SelectionTool getSelectionTool() {
        return (SelectionTool) this.tools.get(ToolType.SELECT);
    }



}
