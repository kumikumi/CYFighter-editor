package com.unknownpotato.cyfighter.editor.model;

public class Entity {

    private float rot;

    /**
     * What we spawn
     */
    private String type;

    /**
     * where we spawn it
     */
    private Vector2 pos;

    public Entity(Vector2 pos, String type, float rot) {
        this.pos = pos;
        this.rot = rot;
        this.type = type;
    }
    
    public Entity() {
        
    }

    public Vector2 getPos() {
        return this.pos;
    }

    public float getRot() {
        return this.rot;
    }

    public String getType() {
        return this.type;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public void setType(String type) {
        this.type = type;
    }

}
