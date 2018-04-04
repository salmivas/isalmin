package ru.job4j.calculator;

/**
 * Корвертор валюты.
 */
public class Converter {
    private int result;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int roubleToEuro(int value) {
        this.result = value / 70;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int roubleToDollar(int value) {
        this.result = value / 60;
        return this.result;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return Рубли.
     */
    public int euroToRouble(int value) {
        this.result = value * 70;
        return this.result;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value Доллар.
     * @return Рубли.
     */
    public int dollarToRouble(int value) {
        this.result = value * 60;
        return this.result;
    }
}
