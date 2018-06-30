package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i, j;

        for (i = 0, j = data.length; i < data.length - 1 || j <= 0; i++, j--) {
            if (data[i][i] != data[i + 1][i + 1] || data[j][j] != data[j - 1][j - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
