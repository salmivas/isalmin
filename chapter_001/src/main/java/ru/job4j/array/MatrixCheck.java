package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int row,col;

        for (row = 0; row < data.length -1; row++) {
            for(col = 0; col < data.length - 1; col++){
                if(data[row][col]  != data[row + 1][col + 1]) {
                    result = false;
                }
            }
        }
        return result;
    }
}
