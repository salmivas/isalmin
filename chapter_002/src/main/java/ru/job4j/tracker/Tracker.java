package ru.job4j.tracker;

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
    public boolean replace(String id, Item item) {
        boolean check = false;
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
                item.setId(id);
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * Удаляет ячейку, найденную по уникальному строковому ключу.
     *
     * @param id строковый ключ.
     */
    public boolean delete(String id) {
        boolean check = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position - i - 1);
                position--;
                check = true;
            }
        }
        return check;
    }

    /**
     * Ищет незаполненные ячейки. Возвращает массив без незаполненных ячеек.
     * @return массив без незаполненных (пустых) ячеек.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Ищет совпадения по заданному имени.
     * @param key искомое имя.
     * @return массив найденных совпадений.
     */
    public Item[] findByName(String key) {
        int numberOfFoundElements = 0;
        Item[] searchedArray = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                searchedArray[numberOfFoundElements++] = this.items[i];
            }
        }
        return Arrays.copyOf(searchedArray, numberOfFoundElements);
    }

    /**
     * Производит поиск по уникальному строковому ключу ячейки и возвращает найденный элемент.
     *
     * @param id строковый индекс ячейки.
     * @return найденный элемент.
     */
    public Item findById(String id) {
        Item reqItem = new Item("null", "null", 0);
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                reqItem = this.items[index];
                break;
            }
        }
        return reqItem;
    }
}
