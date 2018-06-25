package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = false;
        int i,j;

        for (i = 0; i < data.length; i++) {
            for(j = 0; j < data.length; j++){
                boolean a = data[0][0];
                boolean b = data[0][2];
                boolean c = data[1][1];
                boolean d = data[2][0];
                boolean e = data[2][2];
                if(c == a && c == b && c == d && c == e) {
                    result = true;
                }
            }
        }
        return result;
    }
}
