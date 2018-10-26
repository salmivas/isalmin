package ru.job4j.tracker;

public class StubInput implements Input {

    /**
     * Содержит поселдовательность ответов пользователя.
     */
    private final String[] value;

    /**
     * Считает количество вызовов метода "ask".
     */
    private int position;

    /**
     * Конструктор класса.
     * @param value
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Возвращает данные переменной "value" при последовательном вызове, этим
     * симулируя и автоматизируя последовательность действий пользователя в ручном режиме.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
