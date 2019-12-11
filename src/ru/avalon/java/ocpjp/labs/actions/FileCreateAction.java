/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVA
 */
public class FileCreateAction implements Action{
    String file = "Exam808_SampleQuestion.pdf";
    String path = "D:\\Users\\Bozhenkov\\lab2\\";
public void create() throws IOException{
    File f = new File(path, file);
    if(f.isFile()){
        System.out.println("File is already existed");
    }else {
    boolean created = f.createNewFile();
    if(created)
        System.out.println("File created");
    }
}
    @Override
    public void run() {
        try {
            create();
        } catch (IOException ex) {
            Logger.getLogger(FileCreateAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void close() throws Exception {
       
    }
    
}
