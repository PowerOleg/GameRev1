package game.Models;

public class Field {
    private final int SIZE_FIELD;
    private String[][] stateField;
    private final String DEFAULT_SYMBOL = " ";
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;

    public Field(int SIZE_FIELD) {
        this.SIZE_FIELD = SIZE_FIELD;
        this.MIN_NUMBER = 0;
        this.MAX_NUMBER = getSIZE_FIELD();
/* ? */        stateField = new String[getSIZE_FIELD()][getSIZE_FIELD()];
/* ? */         setStateField(DEFAULT_SYMBOL);
    }

    public int getSIZE_FIELD() {
        return SIZE_FIELD;
    }

    public String[][] getStateField() {
        return stateField;
    }

    public String getDEFAULT_SYMBOL() {
        return DEFAULT_SYMBOL;
    }

    public int getMIN_NUMBER() {
        return MIN_NUMBER;
    }

    public int getMAX_NUMBER() {
        return MAX_NUMBER;
    }

    public String getCellField (int i, int j) /*throws*/ {
        if (checkedCoordinate(i) && checkedCoordinate(j)) {
            return stateField[i][j];
        } else {
            return null;                                            //нужно будет потом удалить return null
        }
    }

/* ? */    public void setStateField(String symbol) {
        for (int i = 0; i < getSIZE_FIELD(); i += 1) {
            for (int j = 0; j < getSIZE_FIELD(); j +=1) {
                setCellField(i , j, symbol);

            }

        }

    }

/* ? symbol */    public void setCellField(int i, int j, String symbol) {
    if (checkedCoordinate(i) && checkedCoordinate(j)) {
        if (stateField[i][j] == DEFAULT_SYMBOL || stateField[i][j] == null) {
            this.stateField[i][j] = symbol;
        } else {
            System.out.println("The cell is full");
        }
    }
}
private boolean checkedCoordinate(int coordinate) {
    if (coordinate >= getMIN_NUMBER() && coordinate <= getMAX_NUMBER()) {
        return true;
    } else {
        System.out.println("Wrong coordinates");
        return false;
    }
}

}
