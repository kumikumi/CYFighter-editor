/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.model;

/**
 *
 * @author mikko
 */
public class Vector2 {

    /**
     * the x-component of this vector *
     */
    public float x;
    /**
     * the y-component of this vector *
     */
    public float y;

    /**
     * Constructs a new vector at (0,0)
     */
    public Vector2() {
    }

    /**
     * Constructs a vector with the given components
     *
     * @param x The x-component
     * @param y The y-component
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
    

}
