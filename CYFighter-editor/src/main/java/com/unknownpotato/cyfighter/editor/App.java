package com.unknownpotato.cyfighter.editor;

import com.unknownpotato.cyfighter.editor.controller.Editor;
import com.unknownpotato.cyfighter.editor.ui.Window;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        
        //Luodaan uusi Editor, annetaan se Window:lle, laitetaan window näkyväksi
        
        final Editor editor = new Editor(new Observer() {
            public void update() {
            }
        });

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window(editor).setVisible(true);
            }
        });

    }
}
