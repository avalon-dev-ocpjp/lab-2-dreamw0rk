package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    String filename = "D:\\Users\\Bozhenkov\\lab2\\Exam808_SampleQuestion.pdf";
    String dest = "D:\\Users\\Bozhenkov\\Exam808_SampleQuestion.pdf";
    File source = new File(filename);
    Path p1 = source.toPath();

    File destination = new File(dest);
    Path p2 = destination.toPath();

    private void movefile() throws IOException {
        Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
    }
    @Override
    public void run() {
        if (!new File(dest).exists()) {
            try {
                Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("New copy was created");
                if (!new File(dest).exists()){
                    System.out.println("Original file deletd");
                }
            } catch (IOException ex) {
                Logger.getLogger(FileMoveAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                System.out.println("File is already existed");
                Files.delete(p2);
                System.out.println("Previos copy deleted");
                Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
                Files.delete(p1);
                System.out.println("New copy was created");
                if (!new File(filename).exists()){
                    System.out.println("Original file deletd");
                } else {
                }
            } catch (IOException ex) {
                Logger.getLogger(FileMoveAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
       
    }

}
