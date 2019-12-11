package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.ocpjp.labs.actions.Action;
import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
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
    public static void main(String[] args) {
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
        Action cmd = new FileCopyAction();
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */

                cmd.start("copy");

                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */

                cmd.start("move");
                break;
            case exit:
                close();
                break;
            case delete:
                cmd.start("delete");
                break;
            case create:
                cmd.start("create");
                break;
            /*
                 * TODO №9 Обработайте необработанные команды
             */
        }
    }

}
