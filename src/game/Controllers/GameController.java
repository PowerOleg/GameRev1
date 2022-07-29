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
        System.out.printf("Please input your coordinate %s: ", coordinate);
        return scanner.nextInt();
        }
    public String inputStringCoordinate(String coordinate) {                    //добавил дичь v1
        System.out.printf("Please input your coordinate %s: ", coordinate);
        return scanner.next();
    }
    //устанавка фигурки игрока на поле, если не удалось, то !!!!!!!
    public void movePlayer(int x, int y, Player player) {
        field.setCellField(x, y, player.getFIGURE());
    }





//currentMove создает temp с пустым StateField массивом и потом не обнавляет и никогда не выдает null
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
    public boolean getWinner(Player player) {
//        System.out.printf("H=%s, V=%s, D1=%s, D2=%s\n",checkHorizontal(player), checkVertical(player),checkDiagonal1(player), checkDiagonal2(player));
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal1(player) || checkDiagonal2(player);
    }
    public String getWinnerName() {
        if (getWinner(player1)){
            return player1.getNAME();
        } else if (getWinner(player2)) {
            return player2.getNAME();
        }
        return "no winner";
    }


    public boolean checkHorizontal(Player player) {
        int count;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                /* ? */
                if (field.getCellField(i, j) == player.getFIGURE()) {
                    count++;
                }
                if (count == field.getSIZE_FIELD()) {
                    return true;
                }
            }



        }
        return false;
    }

    public boolean checkVertical (Player player) {
        int count;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {                  //может тут вначале должен быть j
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
        return false;
    }

    public boolean checkDiagonal1 (Player player) {
        int count=0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            if (field.getCellField(i, i) == player.getFIGURE()) {
                count++;
                }
            }
        if (count == field.getSIZE_FIELD()) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonal2 (Player player) {
        int count = 0;
        for (int i = field.getSIZE_FIELD()-1; i >= 0; i--) {
            for (int j = field.getSIZE_FIELD()-1-i;;) {
                if (field.getCellField(i, j) == player.getFIGURE()) {
                    count++;
                }
                break;
            }
        }
        if (count == field.getSIZE_FIELD()) {
            return true;
        }
        return false;
    }




}
