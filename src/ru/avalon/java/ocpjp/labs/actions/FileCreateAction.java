package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Действие, которое создает файлы в пределах дискового пространства.
 */
public class FileCreateAction implements Action {

    // хранение пути создаваемого файла.
    private Path to;

    /**
     * Конструктор класса.
     * @param to - путь создаваемого файла.
     */
    public FileCreateAction(Path to) {
        this.to = to;
    }

    private void create() throws IOException {
        Files.createFile(to);
        try {
            close();
        } catch (Exception ignore) {
        } finally {
            service.shutdownNow();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            create();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (Exception ignore) {
            } finally {
                service.shutdownNow();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        service.shutdown();
    }
    
}
