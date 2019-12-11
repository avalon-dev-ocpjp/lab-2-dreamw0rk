/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

/**
 *
 * @author JAVA
 */
public class FileDeleteAction implements Action{

     String file = "Exam808_SampleQuestion.pdf";
    String path = "D:\\Users\\Bozhenkov\\lab2\\";
    public void delete(){
        
        File f = new File(path, file);
        if(f.isFile()){
        boolean deleted = f.delete();
        if(deleted)
            System.out.println("File deleted");
        } else {
            System.out.println("File not found");
        }
    }
    
    @Override
    public void run() {
        delete();
        
      
    }

    @Override
    public void close() throws Exception {
        
    }
    
}
