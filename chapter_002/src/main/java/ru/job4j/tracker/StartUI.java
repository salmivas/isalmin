package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    /**
     * Константа для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для отображения всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа для поиска заявки по ID.
     */
    private static final String FINDID = "4";
    /**
     * Константа для поиска заявки по имени.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор класса, инициализирующий переменные класса.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Отображает меню перед вводом значений.
     */
    public void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item" + System.lineSeparator() +
                "1. Show all items" + System.lineSeparator() +
                "2. Edit item" + System.lineSeparator() +
                "3. Delete item" + System.lineSeparator() +
                "4. Find item by ID" + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit Program");
    }

    /**
     * Реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Long creationTime = System.currentTimeMillis();
        Item item = new Item(name, desc, creationTime);
        this.tracker.add(item);
        System.out.println("------------ Добавлена новая заявка с ID: " + item.getId() + " -----------");
    }

    /**
     * Отображает все созданные заявки.
     */
    private void showAllItems() {
        System.out.println("------------ Отображение всех заявок --------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    /**
     * Меняет ячейку в массиве требуемой ячейкой.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID редактируемой заявки: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Long date = System.currentTimeMillis();
        Item item = new Item(name, desc, date);
        if(this.tracker.replace(id, item)) {
            System.out.println("Item has been edited!");
        } else {
            System.out.println("Item was not found!");
        }
    }

    /**
     * Удаляет заявку по ID.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        if(this.tracker.delete(id)) {
            System.out.println("Item has been deleted!");
        } else {
            System.out.println("Item was not found!");
        }
    }

    /**
     * Проводит поиск заявки по ID.
     */
    public void findById() {
        System.out.println("------------ Поиск заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item targetItem = this.tracker.findById(id);
        if (targetItem.getName().contains("null")) {
            System.out.println("------------ Заявка не найдена! -----------");
        } else {
            System.out.println("------------ Заявка найдена! -----------");
            System.out.println(targetItem.toString());
        }
    }

    /**
     * Проводит поиск заявки по имени.
     */
    public void findByName() {
        System.out.println("------------ Поиск заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] targetItems = this.tracker.findByName(name);
        if(targetItems.length == 0){
            System.out.printf("--- По имени %s%s%s%s%n", "\"", name, "\"", " заявки не найдены! ---");
        } else {
            System.out.printf("--- По имени %s%s%s%s%n", "\"", name, "\"", " найдены следующие заявки: ---");
            for(Item items: targetItems) {
                System.out.println(items.toString());
            }
        }
    }

    /**
     * Цикл программы, в ходе которого проверяется пользовательский ввод и отоброжаются результаты.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findById();
            } else if (FINDNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                System.out.println("Program is terminated. Thank you for using!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
