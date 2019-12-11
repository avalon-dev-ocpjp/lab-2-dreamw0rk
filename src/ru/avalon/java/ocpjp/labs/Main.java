package ru.avalon.java.ocpjp.labs;

import java.io.BufferedReader;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import java.io.InputStreamReader;

import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileCreateAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle
 * Certified Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {

    /**
     * Точка входа в приложение.
     *
     * @param args
     */
    private BufferedReader in
            = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.printf("Type help to see list of commands.%n>");
        new Main().run();
    }

    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием перечисления
     * {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        String target;
        String to;
        char type;

        switch (command) {
            case help:
                System.out.printf("show - show all entries in directory from path"
                        + "%ncopy - copy target file or directory to target path"
                        + "%nmove - move target file or directory to target path"
                        + "%ndelete - delete target file or empty directory"
                        + "%ncreate - create file or directory at target path"
                        + "%nexit - exit programm"
                        + "%nEnter command:%n>");
                break;
            case copy:
               
                System.out.print("from: ");
                target = in.readLine();
                System.out.print("to: ");
                to = in.readLine();
                new FileCopyAction(target, to).start();
                break;
            case move:
               
                System.out.print("from: ");
                target = in.readLine();
                System.out.print("to: ");
                to = in.readLine();
                new FileMoveAction(target, to).start();
                break;
            case delete:
                
                System.out.print("Path to deleting file or directory: ");
                target = in.readLine();
                new FileDeleteAction(target).start();
                break;
            case create:
             
                System.out.print("Enter d or f to creating directory or file  : ");
                type = in.readLine().charAt(0);
                System.out.print("Enter name of creating object : ");
                target = in.readLine();
                new FileCreateAction(type, target).start();
                break;
            case exit:
                close();
                break;
            
        }
    }

}
