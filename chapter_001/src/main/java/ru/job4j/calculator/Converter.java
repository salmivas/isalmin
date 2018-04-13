package ru.job4j.calculator;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро
     */
    public int roubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int roubleToDollar(int value) {
        return value / 60;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return Рубли.
     */
    public int euroToRouble(int value) {
        return value * 70;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value Доллар.
     * @return Рубли.
     */
    public int dollarToRouble(int value) {
        return value * 60;
    }
}
