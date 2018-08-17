package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0 ,this.table.length -1 ,0 ,0) ||
                this.fillBy(Figure3T::hasMarkX,this.table.length - 1 ,this.table.length - 1 , -1 ,0) ||
                this.fillBy(Figure3T::hasMarkX,this.table.length - 1 ,this.table.length - 1 , 0 ,-1);
    }

    public boolean isWinnerO() {
        boolean win = true;
        for (int i = 0; i < table.length; i++) {
            if (table[0][0] != table[i][i] | table[table.length - 1 - i][i] != table[table.length - 2 - i][i + 1]){
                win = false;
                break;
            } else if (table[i][i] != table[i + 1][i] | table[i][i] != table[i][i + 1] | table[i + 1][i] != table[i + 1][i] | table[i][i + 1] != table[i][i + 1] ){
                win = false;
                break;
            }
        }
        return win;
    }

    public boolean hasGap() {
        boolean hollow = false;
        for (int i = 0; i < table.length; i++){
            if(table[i][i] == null | table[table.length - 1 - i][i] == null | table[i + 1][i] == null | table[i][i + 1] == null){
                hollow = true;
                break;
            }
        }
        return hollow;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
