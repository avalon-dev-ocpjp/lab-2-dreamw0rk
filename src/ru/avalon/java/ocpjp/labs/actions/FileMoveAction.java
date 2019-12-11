package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    
    // хранение текущего пути файла.
    private Path from;
    
    // хранение нового пути файла.
    private Path to;

    /**
     * Конструктор класса.
     * @param from - существующий путь перемещаемого файла.
     * @param to - новый путь перемещаемого файла.
     */
    public FileMoveAction(Path from, Path to) {
        this.from = from;
        this.to = to;
    }

    private void move() throws IOException {
        Files.move(from, to, REPLACE_EXISTING);
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
            move();
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
