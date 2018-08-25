package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean retVal = false;
        for (int index = 0; index != this.table.length; index++) {
                if (this.fillBy(Figure3T::hasMarkX, index, 0, 0, 1)
                        || this.fillBy(Figure3T::hasMarkX, 0, index, 1, 0)
                        || this.fillBy(Figure3T::hasMarkX, index, index, 1, 1)
                        || this.fillBy(Figure3T::hasMarkX, this.table.length - 1 - index, index, -1, 1)) {
                    retVal = true;
                    break;
                }
            }
        return retVal;
    }

    public boolean isWinnerO() {
        boolean retVal = false;
        for (int index = 0; index != this.table.length; index++) {
            if (this.fillBy(Figure3T::hasMarkO, index, 0, 0, 1)
                    || this.fillBy(Figure3T::hasMarkO, 0, index, 1, 0)
                    || this.fillBy(Figure3T::hasMarkO, index, index, 1, 1)
                    || this.fillBy(Figure3T::hasMarkO, this.table.length - 1 - index, index, -1, 1)) {
                retVal = true;
                break;
            }
        }
        return retVal;
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

    public boolean hasGap() {
        boolean result = false;
        for (int thisX = 0; thisX != this.table.length; thisX++) {
            for (int thisY = 0; thisY != this.table.length; thisY++) {
                Figure3T cell = this.table[thisX][thisY];
                if (!cell.hasMarkX() && !cell.hasMarkO()) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}


