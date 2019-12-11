package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileCopyAction implements Action {

    /**
     * {@inheritDoc}
     */
    String filename = "D:\\Users\\Bozhenkov\\lab2\\Exam808_SampleQuestion.pdf";
    String dest = "D:\\Users\\Bozhenkov\\Exam808_SampleQuestion.pdf";
    File source = new File(filename);
    Path p1 = source.toPath();

    File destination = new File(dest);
    Path p2 = destination.toPath();

    private void copyfile() throws IOException {
        if (!new File(dest).exists()) {
            Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
            System.out.println("New copy was created");
        } else {
            System.out.println("File is already exited");
            Files.delete(p2);
            System.out.println("Previos copy deleted");
            Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
            System.out.println("New copy was created");
        }
    }

    @Override
    public void run() {
        try {
            /*
            * TODO №2 Реализуйте метод run класса FileCopyAction
             */

            copyfile();
//        throw new UnsupportedOperationException("Not implemented yet!");
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
//        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
