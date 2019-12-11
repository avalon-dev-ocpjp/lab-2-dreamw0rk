package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Действие, которое удаляет файлы в пределах дискового пространства.
 */
public class FileDeleteAction implements Action {

    // хранение пути удаляемого файла.
    private Path from;

    /**
     * Конструктор класса.
     * @param from - путь удаляемого файла.
     */
    public FileDeleteAction(Path from) {
        this.from = from;
    }

    private void delete() throws IOException {
        Files.delete(from);
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
            delete();
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
