package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    public ArrayChar(String line){
        this.data = line.toCharArray();
    }
    public boolean startWith(String prefix){
        boolean result = true;
        char[] value = prefix.toCharArray();
        for(int i = 0; i < value.length; i++){
            if(value[i] != data[i]){
                result = false;
            }
        }
        return result;
    }
}
