/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknownpotato.cyfighter.editor.fileio.serializing;

/**
 *
 * @author mikko
 */
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializer {

    private ObjectMapper mapper;

    public Serializer() {
        this.mapper = new ObjectMapper();
        mapper.configure(Feature.AUTO_CLOSE_TARGET, false);
        //System.out.println(mapper.isEnabled(Feature.AUTO_CLOSE_TARGET));
        
    }

    public void save(Object o, File f) {
        try {
            this.mapper.writeValue(f, o);
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public <T> T load(File file, Class<T> valueType) {
        try {
            return this.mapper.readValue(file, valueType);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public <T> T load(InputStream stream, Class<T> valueType) {
        try {
            return this.mapper.readValue(stream, valueType);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public <T> T load(InputStream stream, TypeReference typeReference) {
        try {
            return mapper.readValue(stream, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        return null;
    }
    
    public void writeToStream(OutputStream stream, Object object) {
        try {
            this.mapper.writeValue(stream, object);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
