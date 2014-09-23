/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unknownpotato.cyfighter.editor.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Collection;

/**
 * Määritellään, että level koostuu metadatasta, entityistä ja yhdestä taustakuvasta.
 * 
 * Määritellään alustavasti myös, että level talletetaan pakattuun tiedostoon seuraavalla tavalla:
 * 
 *-tasonnimi.zip
 * |
 * |- entities.json (sisältää tiedot entityjen deserialisoimiseksi)
 * |- metadata.json (sisältää tiedot metadatan deserialisoimiseksi)
 * |- background.png (sisältää taustan)
 * 
 * 
 * @author kumikumi
 *
 */
public class Level {

	private Image background;
	private Collection<Entity> entities;
	private Metadata metadata;
	
	public Image getBackground() {
		return background;
	}
	public void setBackground(Image background) {
		this.background = background;
	}
	public Collection<Entity> getEntities() {
		return entities;
	}
	public void setEntities(Collection<Entity> entities) {
		this.entities = entities;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	
	
}
