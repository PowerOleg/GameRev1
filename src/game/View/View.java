package game.View;

import game.Models.Field;

public class View {
    private Field field;


    public View(Field field) {
        this.field = field;
        System.out.println("A new game has just began");
        //System.out.println("---------------------------");
    }
    public void showField() {
        for (int i = 0; i < field.getSIZE_FIELD(); i += 1) {
            for (int j = 0; j < field.getSIZE_FIELD(); j += 1) {
                if (j != 0) {
                    System.out.print("|");
                }
                System.out.printf("[%s]", field.getCellField(i, j));       //команда достает значения массива

            }
            if (i != field.getSIZE_FIELD()-1) {
                System.out.println("\n-----------");
            }


        }
        System.out.println("\n");
    }



}
