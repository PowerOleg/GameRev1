package game;

import game.Controllers.GameController;
import game.Models.Field;
import game.Models.Player;
import game.View.View;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(3);
        Player player1 = new Player("Max", "0");
        Player player2 = new Player("Leo", "1"); //фэйл если будет 0
        GameController gameController = new GameController(field, player1, player2);
        View view = new View(field);
        view.showField();


        int x, y;
      //  String z;                                                       //добавил дичь v1
while (!gameController.endGame()){
    System.out.printf("Player%s:", Integer.parseInt(gameController.currentMove())+1);
    x = gameController.inputCoordinate("x");
    y = gameController.inputCoordinate("y");
  //  z = gameController.inputStringCoordinate("z");                  //добавил дичь v1
  //  player1.setFIGURE(z);                                           //добавил дичь v1

    gameController.movePlayer(x,y, player1);
    view.showField();
    if (gameController.getWinner(player1)) {
        break;
    }

    System.out.printf("Player%s:", Integer.parseInt(gameController.currentMove())+1);
    x = gameController.inputCoordinate("x");
    y = gameController.inputCoordinate("y");
    gameController.movePlayer(x,y, player2);
    view.showField();
    if (gameController.getWinner(player2)) {
        break;
    }
}
        System.out.printf("The winner is %s", gameController.getWinnerName());

    }
}
