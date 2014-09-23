/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.fileio;

import com.unknownpotato.cyfighter.editor.fileio.serializing.Serializer;
import com.unknownpotato.cyfighter.editor.model.Level;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author mikko
 */
public class MapSaver {

    private Serializer serializer;

    public MapSaver() {
        this.serializer = new Serializer();
    }

    public void saveMap(Level level, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return;
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        try {
            zipOutputStream.putNextEntry(new ZipEntry("metadata.json"));
            serializer.writeToStream(zipOutputStream, level.getMetadata());

            zipOutputStream.putNextEntry(new ZipEntry("entities.json"));
            serializer.writeToStream(zipOutputStream, level.getEntities());
            
            zipOutputStream.putNextEntry(new ZipEntry("background.png"));
            ImageIO.write((RenderedImage) level.getBackground(), "png", zipOutputStream);

            zipOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        try {
//            zipOutputStream.putNextEntry(new ZipEntry("metadata.json"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        serializer.writeToStream(zipOutputStream, level.getMetadata());
//        try {
//            zipOutputStream.closeEntry();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

}
