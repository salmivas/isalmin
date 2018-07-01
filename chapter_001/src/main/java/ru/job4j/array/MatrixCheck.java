package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i;

        for (i = 0; i < data.length; i++){
            if (data[0][0] != data[i][i]){
                result = false;
                break;
            } else if(data[0][0] != data[data.length - 1 - i][i]){
                result = false;
                break;
            }
        }
        return result;
    }
}
