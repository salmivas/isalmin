package ru.job4j.loop;

public class Counter {

    public int add (int start, int finish){
        int i = 0;
        for (start = 1; start <= finish; start++){
            if (start % 2 == 0){
                i += start;
            }
        }
        return i;
    }
}
