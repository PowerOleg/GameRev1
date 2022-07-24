package game.Controllers;

import game.Models.Field;
import game.Models.Player;

import java.util.Scanner;

public class GameController {
/* ? */    Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Field field;


    public GameController(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int inputCoordinate(String coordinate) {
        System.out.printf("Enter your coordinate %s", coordinate);
        return scanner.nextInt();
        }

    //устанавка фигурки игрока на поле, если не удалось, то !!!!!!!
    public void movePlayer(int x, int y, Player player) {
        field.setCellField(x, y, player.getFIGURE());
    }
    public String currentMove() {
        String[][] temp = field.getStateField();
        int lengthTemp = temp.length;
        int count = 0;
        for (int i = 0; i < lengthTemp; i += 1) {
            for (int j = 0; j < lengthTemp; j += 1) {
                if (temp[i][j] != " ") {
                    count ++;
                }

            }

        }
        if (count == field.getSIZE_FIELD()*field.getSIZE_FIELD()) {
            return null;
        }
if (count %2 == 0) {
    return player1.getFIGURE();
}
return player2.getFIGURE();
    }
    public boolean endGame() {
        if (currentMove() != null) {
            return false;
        }
        return true;
    }
    private boolean getWinner(Player player) {
        int count;
        //проверка по горизонтали
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(i, j) == player.getFIGURE()) {
                    count++;
                }
                if (count == field.getSIZE_FIELD()) {
                    return true;
            }

            }
        }
        //проверка по вертикали
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(j, i) == player.getFIGURE()) {
                    count++;
                }
                if (count == field.getSIZE_FIELD()) {
                    return true;
                }
            }
        }
    //проверка по диагонали
    count=0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(i, j) == player.getFIGURE()) {
                    count++;
                    break;
                }
            }
        }
    if (count == field.getSIZE_FIELD()) {
    return true;
}
    //проверка по диагонали2
count = 0;
        for (int i = field.getSIZE_FIELD(); i >= 0; i--) {
            for (int j = field.getSIZE_FIELD(); j < 0; j--) {
                if (field.getCellField(i, j) == player.getFIGURE()) {
                    count++;
                    break;
                }
            }
        }
        if (count == field.getSIZE_FIELD()) {
            return true;
        }
        return false;

    }
    public String getWinnerName() {
        if (getWinner(player1)){
            return player1.getNAME();
        } else if (getWinner(player2)) {
            return player2.getNAME();
        }
        return "no winner";
    }

}
