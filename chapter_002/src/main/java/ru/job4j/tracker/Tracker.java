package ru.job4j.tracker;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Реализует добавление новых заявок в хранилище.
     *
     * @param item новая заявка.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Генерирует уникальный ключ для заявки.
     *
     * @return уникальный ключ.
     */
    private String generateId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Ищет ячейку по id, присваивает найденной ячейке объект(меняет ячейку требуемой) принимаемый в аргументе.
     *
     * @param id   искомая ячейка.
     * @param item ячейка которая должна заменить искомую.
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < items.length; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Удаляет ячейку, найденную по уникальному строковому ключу.
     *
     * @param id строковый ключ.
     */
    public void delete(String id) {
        Item[] innerItems = this.items;
        Item delItem = findBuild(id);
        int innerItemsLength = innerItems.length;
        int indexOfDelItem = Arrays.asList(this.items).indexOf(delItem);
        int numMoved = innerItemsLength - indexOfDelItem - 1;

        System.arraycopy(innerItems, indexOfDelItem + 1, this.items, indexOfDelItem, numMoved);
        innerItems[innerItemsLength - 1] = null;
    }

    /**
     * Ищет незаполненные ячейки. Возвращает массив без незаполненных ячеек.
     *
     * @return массив без незаполненных (пустых) ячеек.
     */
    public Item[] findAll() {
        Item[] lookedFor = this.items;
        for (int i = 0; i < lookedFor.length; i++) {
            if (lookedFor[i] == null) {
            //Выполнить delete
            }
        }
        return null;
    }

    /**
     * Ищет совпадения по заданному имени.
     *
     * @param key искомое имя.
     * @return массив найденных совпадений.
     */
    public Item[] findByName(String key) {
        int numberOfFoundElements = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                numberOfFoundElements++;
            }
        }
        Item[] resultArray = new Item[numberOfFoundElements];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                resultArray[i] = this.items[i];
            }
        }
        return resultArray;
    }

    /**
     * Производит поиск по уникальному строковому ключу ячейки и возвращает найденный элемент.
     *
     * @param id строковый индекс ячейки.
     * @return найденный элемент.
     */
    public Item findBuild(String id) {
        Item reqItem = null;
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index].getId().equals(id)) {
                reqItem = this.items[index];
                break;
            } else {
                break;
            }
        }
        return reqItem;
    }
}
