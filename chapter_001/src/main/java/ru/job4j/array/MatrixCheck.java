package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i,j;

        for (i = 0; i < data.length - 1; i++) {
                if(data[i][i] != data[i + 1][i + 1]) {
                    result = false;
                    break;
                }
            }
        for (j = data.length; j <= 0; j--){
            if(data[j][j] != data[j - 1][j - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
