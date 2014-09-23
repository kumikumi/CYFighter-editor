/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.fileio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.unknownpotato.cyfighter.editor.fileio.serializing.Serializer;
import com.unknownpotato.cyfighter.editor.model.Entity;
import com.unknownpotato.cyfighter.editor.model.Level;
import com.unknownpotato.cyfighter.editor.model.Metadata;
import com.unknownpotato.cyfighter.editor.model.Vector2;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;

/**
 *
 * @author mikko
 */
public class MapLoader {

    private Serializer serializer;

    public MapLoader() {
        serializer = new Serializer();
    }

    public Level readMap(File file) {
        System.out.println("Read map: " + file.getAbsolutePath());
        Level level = new Level();

        //File file = new File(path);
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(file);
        } catch (ZipException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Collection<Entity> entities = getEntities(zipfile);
        level.setEntities(entities);

        Image texture = getTexture(zipfile);
        level.setBackground(texture);

        level.setMetadata(getMetadata(zipfile));

        System.out.println(level.getMetadata().nimi + " " + level.getMetadata().versio);

        return level;
    }

    private Collection<Entity> getEntities(ZipFile zipfile) {
        ZipEntry entityEntry = zipfile.getEntry("entities.json");
        InputStream entities = null;
        try {
            entities = zipfile.getInputStream(entityEntry);
        } catch (IOException ex) {
            Logger.getLogger(MapLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return (Collection<Entity>) serializer.load(entities, new TypeReference<Collection<Entity>>() {
        });
    }

    private Image getTexture(ZipFile zipfile) {
        ZipEntry imageEntry = zipfile.getEntry("background.png");
        InputStream imagestream = null;
        try {
            imagestream = zipfile.getInputStream(imageEntry);
        } catch (IOException ex) {
            Logger.getLogger(MapLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Image image = null;
        try {
            image = ImageIO.read(imagestream);
        } catch (IOException ex) {
        }

        return image;
    }

    private Metadata getMetadata(ZipFile zipfile) {
        ZipEntry metadataEntry = zipfile.getEntry("metadata.json");
        InputStream metadata = null;
        try {
            metadata = zipfile.getInputStream(metadataEntry);
        } catch (IOException ex) {
            Logger.getLogger(MapLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return serializer.load(metadata, Metadata.class);
    }

    public void addTestData() {
        Collection<Entity> temp = new ArrayList<Entity>();
        Vector2 paikka1 = new Vector2(3, 4);
        String tyyppi1 = "puu";
        float rot1 = 10.4f;
        Entity otus1 = new Entity(paikka1, tyyppi1, rot1);

        Vector2 paikka2 = new Vector2(5, 1);
        String tyyppi2 = "kivi";
        float rot2 = 3.1f;
        Entity otus2 = new Entity(paikka2, tyyppi2, rot2);

        Vector2 paikka3 = new Vector2(7, 2);
        String tyyppi3 = "kanto";
        float rot3 = 3.8f;
        Entity otus3 = new Entity(paikka3, tyyppi3, rot3);

        temp.add(otus1);
        temp.add(otus2);
        temp.add(otus3);

//        Metadata testimetadata = new Metadata();
//        testimetadata.nimi = "Epic Battle Grounds";
//        testimetadata.versio = "2.03";

        File testifile = new File("/home/mikko/cyfme-test/tavaraa.json");

        serializer.save(temp, testifile);
    }

}
