package ru.job4j.max;


public class Max {

    public int max(int first, int second) {

       return first > second ? first : second;
    }

    public int max(int first, int second, int third){

//        int temp = this.max(max(first,second), third);

        /*
        * Иное решение
        */
        return this.max(max(first,second), third);
    }
}
