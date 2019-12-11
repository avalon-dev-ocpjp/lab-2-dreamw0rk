package ru.avalon.java.ocpjp.labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileCreateAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче
 * сертификационных экзаменов серии Oracle Certified
 * Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {
    
    Path from;
    Path to;

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Main().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case create:
                System.out.println("Enter the path of the file to be created");
                to = Paths.get(in.readLine());
                new FileCreateAction(to).start();
                break;
            case copy:
                System.out.println("Enter the path of the file to be copied");
                from = Paths.get(in.readLine());
                System.out.println("Enter where to copy the file");
                to = Paths.get(in.readLine());
                new FileCopyAction(from, to).start();
                break;
            case move:
                System.out.println("Enter the path of the file to be moved");
                from = Paths.get(in.readLine());
                System.out.println("Enter where to move the file");
                to = Paths.get(in.readLine());
                new FileMoveAction(from, to).start();
                break;
            case delete:
                System.out.println("Enter the path of the file to be deleted");
                from = Paths.get(in.readLine());
                new FileDeleteAction(from).start();
                break;
            case exit:
                close();
                break;
        }
    }
}
